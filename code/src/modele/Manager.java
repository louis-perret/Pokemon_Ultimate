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

import java.util.List;
import java.util.Map;

//Permet de gérer nos différentes fonctionnalités
public class Manager {

    private Attaqueur attaqueur;
    private DeplaceurPokemon deplaceur = new DeplaceurPokemonSimple();
    private ControleurCombat controleurCombat;
    private Pokemon pokemonCourant;
    private Carte carteCourante;
    private int numeroVague = 0;
    private Monde monde;
    private CollectionPokemon pokedex;
    private Thread thread;

    //Propriété compteur
    private IntegerProperty compteur = new SimpleIntegerProperty(); //On déclare la propriété
    public int getCompteur() { return compteur.get();} //getter
    public void setCompteur(int nombre) { compteur.set(nombre);} //setter
    public IntegerProperty compteurProperty() { return compteur;} //Renvoie la propriété

    private IntegerProperty pv = new SimpleIntegerProperty();

    public IntegerProperty pvProperty() {
        //pv = pokemonCourant.getPv();
        return pv;
    }


    private IntegerProperty changeur = new SimpleIntegerProperty(); //On déclare la propriété

    public int getChangeur() {return changeur.get();}
    public void setChangeur(int nombre) {this.changeur.set(nombre);}
    public IntegerProperty changeurProperty() { return changeur;}






    /**
     * Constructeur
     * @param collectionPokemon
     */
    public Manager(CollectionPokemon collectionPokemon, Map<Integer, Tuile>dicoTuiles){
        this.attaqueur = new AttaqueurPokemon();
        this.deplaceur = new DeplaceurPokemonSimple();
        this.pokedex=collectionPokemon;
        this.controleurCombat = new ControleurCombatV1(collectionPokemon);
        this.monde=new Monde(dicoTuiles);
    }

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param allie : pokemon qui attaque
     * @param ennemi : pokemon qui est attaqué
     * @param mAllie : l'attaque utilisée
     */
    public int tourDeCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie){
        return controleurCombat.effectuerCombat(allie,ennemi,mAllie);
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
        setCompteur(0);
        Observateur observateur = new ObservateurBoucle(this); //On créé l'observateur de la boucle
        BoucleJeu boucleJeu = new BoucleJeu16();
        boucleJeu.addObservateur(observateur);
        thread = new Thread(boucleJeu);
        thread.start(); //On lance le thread qui contient la boucle
    }

    public void terminerBoucleJeu(){
        thread.interrupt();
    }

    /**
     * Gère les vagues de pokemon ennemi du jeu
     * @return une liste de 3 pokemon que devra combattre le joueur
     */
    public List<Pokemon> lancerVague(){
        if(numeroVague>=3){ //Le joueur a gagné toutes les vagues
            return null; //Pour prévenir qu'il n'y a plus de pokemon à combattre
        }
        numeroVague++;
        return pokedex.getListePokemon(numeroVague,3, pokemonCourant);  //Sinon on renvoie les pokemon de la vague d'après
    }
    //Getter et setter
    public Pokemon getPokemonCourant() {
        return pokemonCourant;
    }

    public List<Pokemon> getStarterslvl1() {
        return pokedex.getStarterLvl1();
    }

    public void setPokemonCourant(Pokemon pokemonCourant) {
        //On clone le pokemon pour éviter qu'il pointe vers la même référence et ainsi éviter qu'il modifie directement le pokemon contenu dans le pokedex
        this.pokemonCourant = pokemonCourant.cloner();
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
