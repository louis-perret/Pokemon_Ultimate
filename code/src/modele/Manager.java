package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.combat.Attaqueur;
import modele.combat.AttaqueurPokemon;
import modele.combat.ControleurNiveau;
import modele.boucle.BoucleJeu;
import modele.boucle.BoucleJeu16;
import modele.deplaceur.DeplaceurPokemon;
import modele.deplaceur.Deplaceur;
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
    private Deplaceur deplaceur;
    private ControleurNiveau controleurNiveau;
    private Pokemon pokemonCourant;
    private Carte carteCourante;

    //Propriété compteur
    private IntegerProperty compteur = new SimpleIntegerProperty(); //On déclare la propriété
    public int getCompteur() { return compteur.get();} //getter
    public void setCompteur(int nombre) { compteur.set(nombre);} //setter
    public IntegerProperty compteurProperty() { return compteur;} //Renvoie la propriété

    private Monde monde;
    private CollectionPokemon pokedex;


    /**
     * Constructeur
     * @param collectionPokemon
     */
    public Manager(CollectionPokemon collectionPokemon, Map<Integer, Tuile>dicoTuiles){
        this.attaqueur = new AttaqueurPokemon();
        this.deplaceur = new DeplaceurPokemon();
        this.pokedex=collectionPokemon;
        this.controleurNiveau=new ControleurNiveau(collectionPokemon);
        this.monde=new Monde(dicoTuiles);
    }


    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon qui attaque
     * @param attaque : pokemon qui est attaqué
     * @param mouvementAttaquant : l'attaque utilisée
     */
    public void tourDeCombat(Pokemon attaquant, Pokemon attaque, Mouvement mouvementAttaquant,Mouvement mouvementAttaque){
        boolean battu=attaqueur.attaquer(attaquant,attaque,mouvementAttaquant);
        if(battu) { //S'il a gagné le combat
            controleurNiveau.gagnerExperience(attaquant, attaque); //On lui fait gagner de l'expéricence
        }
    }

    /**
     * Gère le déplacement d'un pokemon
     * @param keyChar : Touche appuyée par l'utilisateur
     */
    public void deplacerPokemon(String keyChar){
            deplaceur.deplacer(pokemonCourant,keyChar,carteCourante);
    }

    public void lancerBoucleJeu(){
        setCompteur(0);
        Observateur observateur = new ObservateurBoucle(this);
        BoucleJeu boucleJeu = new BoucleJeu16();
        boucleJeu.addObservateur(observateur);
        Thread thread = new Thread(boucleJeu);
        thread.start();
    }

    //Getter et setter
    public Pokemon getPokemonCourant() {
        return pokemonCourant;
    }

    public List<Pokemon> getStarterslvl1() {
        return pokedex.getStarterLvl1();
    }

    public void setPokemonCourant(Pokemon pokemonCourant) {
        this.pokemonCourant = pokemonCourant;
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
