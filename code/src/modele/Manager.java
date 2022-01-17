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
    private DeplaceurPokemon deplaceur;
    private ControleurCombat controleurCombat;
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
