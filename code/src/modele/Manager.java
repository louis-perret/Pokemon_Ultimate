package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.combat.*;
import modele.boucle.BoucleJeu;
import modele.boucle.BoucleJeu16;
import modele.deplaceur.DeplaceurPokemonSimple;
import modele.deplaceur.DeplaceurPokemon;
import modele.monde.Tuile;
import modele.observateurs.Observateur;
import modele.observateurs.ObservateurBoucle;
import modele.pokemon.*;
import modele.monde.Carte;
import modele.monde.Monde;
import modele.pokemon.Mouvement;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * Classe qui gère toutes les fonctionnalités du jeu
 */
public class Manager implements Serializable {

    private transient DeplaceurPokemon deplaceur; //pour le déplacement
    private transient ControleurCombat controleurCombat; //pour les combats

    private transient Pokemon pokemonCourant; //le pokemon choisie par l'utilisateur
    private transient Pokemon pokemonEnnemiCourant; //pokemon qu'affronte le joueur
    private transient int numeroVague = 1; //numéro de la vague
    private transient List<Pokemon> listePokemonByVague; //liste des pokemon ennemi de la vague

    private transient Carte carteCourante; //la carte actuellement affichée
    private transient Monde monde; //notre monde
    private CollectionPokemon pokedex; //collection des pokemons
    private int nbVictoires = 0; //nombre de victoires du joueur
    private Map<Integer, Tuile> dicoTuiles; //dictionnaire contenant toutes les types de tuiles de nos cartes (pour le sauvegarder)
    private transient Thread thread; //thread de la boucle de jeu


    //Propriété compteur (utile pour les déplacements du personnages car notifie la fenêtre d'un beep de la part de notre boucle jeu)
    private transient IntegerProperty compteur = new SimpleIntegerProperty(); //On déclare la propriété
    public int getCompteur() { return compteur.get();} //getter
    public void setCompteur(int nombre) { compteur.set(nombre);} //setter
    public IntegerProperty compteurProperty() { return compteur;} //Renvoie la propriété

    private transient IntegerProperty changeur = new SimpleIntegerProperty(); //On déclare la propriété
    public int getChangeur() {return changeur.get();}
    public void setChangeur(int nombre) {this.changeur.set(nombre);}
    public IntegerProperty changeurProperty() { return changeur;}





    /**
     * Constructeur
     * @param collectionPokemon : collection des pokemons
     * @param dicoTuiles : type de tuiles
     */
    public Manager(CollectionPokemon collectionPokemon, Map<Integer, Tuile>dicoTuiles){
        this.deplaceur = new DeplaceurPokemonSimple();
        this.pokedex=collectionPokemon;
        this.controleurCombat = new ControleurCombatV1(collectionPokemon);
        this.dicoTuiles=dicoTuiles;
        this.monde=new Monde(dicoTuiles);
    }

    /**
     * Initialise le deplaceur, le controleur combat et le monde de Manager après sa désérialisation
     */
    public void initialisationOnDeserialized(){
        deplaceur = new DeplaceurPokemonSimple();
        controleurCombat = new ControleurCombatV1(pokedex);
        monde=new Monde(dicoTuiles);
    }

    /**
     * Gère un tour de combat entre deux pokemon
     * @param allie : pokemon du joueur
     * @param ennemi : pokemon ennemi
     * @param mAllie : l'attaque utilisée par le pokemon du joueur
     */
    public int tourDeCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie){
        int resultat = controleurCombat.effectuerCombat(allie,ennemi,mAllie);
        if(resultat == 1){ //le pokemon ennemi est ko
            listePokemonByVague.remove(0); //on l'enlève de la liste des pokemon ennemis
            if(!listePokemonByVague.isEmpty()){ //s'il reste des pokemon à combattre
                setPokemonEnnemiCourant(listePokemonByVague.get(0)); //on envoie le prochain au casse-pipe
                return 1;
            }
            else{ //sinon la vague est finie
                pokemonCourant.setPv(pokedex.getPokemon(pokemonCourant.getNom(),pokemonCourant.getNiveau()).getPv()); //on le soigne
                numeroVague++;
                return 3;
            }
        }
        else{
            if(resultat == 2){
                numeroVague=1;
                return 2; //le pokemon du joueur est ko
            }
        }
        return 0; //aucun pokemon n'est ko
    }

    /**
     * Gère le déplacement d'un pokemon
     * @param keyChar : Touche appuyée par l'utilisateur
     */
    public void deplacerPokemon(String keyChar){
        deplaceur.deplacer(pokemonCourant,keyChar,carteCourante, this);
    }

    /**
     * Lance la boucle de jeu utile au déplacement du pokemon du joueur
     */
    public void lancerBoucleJeu(){

        pokemonCourant.setPosition(new Position(carteCourante.getSpawnX(),carteCourante.getSpawnY())); //on set la position du pokemon au point de spawn de la map
        setCompteur(0); //on remet le compteur à 0
        Observateur observateur = new ObservateurBoucle(this); //On créé l'observateur de la boucle
        BoucleJeu boucleJeu = new BoucleJeu16();
        boucleJeu.addObservateur(observateur);
        thread = new Thread(boucleJeu);
        thread.start(); //On lance le thread qui contient la boucle
    }

    /**
     * Arrête le thread de la boucle de jeu
     */
    public void terminerBoucleJeu(){
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Problème dans l'arrêt de la boucle de jeu");
        }
    }

    /**
     * Gère les vagues de pokemon ennemi du jeu
     * @return une liste de 3 pokemon que devra combattre le joueur
     */
    public boolean lancerVague(){
        if(numeroVague>=3){ //Le joueur a gagné toutes les vagues
            return true;//Pour prévenir qu'il n'y a plus de pokemon à combattre
        }
        System.out.println("numéro de vague : " + numeroVague);
        listePokemonByVague=pokedex.getListePokemon(numeroVague,3, pokemonCourant);  //Sinon on renvoie les pokemon de la vague d'après
        pokemonEnnemiCourant=listePokemonByVague.get(0);
        return false;
    }

    public List<Pokemon> getStarterslvl1() {
        return pokedex.getStarterLvl1();
    }

    //Getter et setter
    public Pokemon getPokemonCourant() {
        return pokemonCourant;
    }

    public void setPokemonCourant(Pokemon pokemonCourant) {
        //On clone le pokemon pour éviter qu'il pointe vers la même référence et ainsi éviter qu'il modifie directement le pokemon contenu dans le pokedex
        this.pokemonCourant = pokemonCourant.cloner();
    }

    public Pokemon getPokemonEnnemiCourant() {
        return pokemonEnnemiCourant;
    }

    public void setPokemonEnnemiCourant(Pokemon pokemon) {
        pokemonEnnemiCourant.setNom(pokemon.getNom());
        pokemonEnnemiCourant.setPv(pokemon.getPv());
        pokemonEnnemiCourant.setImageCombat(pokemon.getImageCombat());
        pokemonEnnemiCourant.setImage(pokemon.getImage());
        pokemonEnnemiCourant.setMouvements(pokemon.getMouvements());
        pokemonEnnemiCourant.setEtat(pokemon.getEtat());
        pokemonEnnemiCourant.setVitesse(pokemon.getVitesse());
        pokemonEnnemiCourant.setAttaque((pokemon.getAttaque()));
        pokemonEnnemiCourant.setDefense(pokemon.getDefense());
        pokemonEnnemiCourant.setType(pokemon.getType());
    }

    public Carte getCarteCourante() {
        if(carteCourante == null){
            this.setCarteCourante("lobby");
        }
        return carteCourante;
    }

    public void setCarteCourante(String nomCarte) {
        this.carteCourante = monde.getCarte(nomCarte);
    }

    public Monde getMonde() {
        return monde;
    }

    public CollectionPokemon getPokedex() {
        return pokedex;
    }


}
