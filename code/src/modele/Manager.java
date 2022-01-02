package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import vues.afficheur.Afficheur;
import vues.afficheur.AfficheurPokemon;
import vues.monde.Monde;

//Permet de gérer nos différentes fonctionnalités
public class Manager {

    private Attaqueur attaqueur;
    private Afficheur afficheur;
    private Deplaceur deplaceur;
    private ControleurNiveau controleurNiveau;
    private Pokemon pokemonCourant;

    //Propriété compteur
    private IntegerProperty compteur = new SimpleIntegerProperty(); //On déclare la propriété
    public int getCompteur() { return compteur.get();} //getter
    public void setCompteur(int nombre) { compteur.set(nombre);} //setter
    public IntegerProperty compteurProperty() { return compteur;} //Renvoie la propriété

    //private CollectionPokemon collectionPokemon=null;
    private Monde monde;
    private Collisionneur collisionneur;

    /**
     * Constructeur
     * @param collectionPokemon
     */
    public Manager(CollectionPokemon collectionPokemon,String monde) {
        this.attaqueur = new AttaqueurPokemon();
        this.afficheur = new AfficheurPokemon();
        this.deplaceur = new DeplacerPokemon();
        this.controleurNiveau=new ControleurNiveau(collectionPokemon);
        this.collisionneur=new Collisionneur();
        this.monde=new Monde(monde);
    }

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon qui attaque
     * @param attaque : pokemon qui est attaqué
     * @param m : l'attaque utilisée
     */
    public void attaquerPokemon(Pokemon attaquant, Pokemon attaque,Mouvement m){
        boolean battu=attaqueur.attaquer(attaquant,attaque,m);
        if(battu) { //S'il a gagné le combat
            controleurNiveau.gagnerExperience(attaquant, attaque); //On le fait gagner de l'expéricence
        }
    }

    /**
     * Gère le déplacement d'un pokemon
     * @param pokemon : pokemon qui se déplace
     * @param  : sa nouvelle position x
     * @param : sa nouvelle position y
     */
    public void deplacerPokemon(Pokemon pokemon,Position position,double hauteurFenetre, double largeurFenetre){
        //Penser à prendre en compte le collisionneur avant de déplacer
        if(!collisionneur.isCollision(pokemon.getPosition(),position,monde)) {
            deplaceur.deplacer(pokemon,position);
        }
    }

    public Pokemon getPokemonCourant() {
        return pokemonCourant;
    }

    public void setPokemonCourant(Pokemon pokemonCourant) {
        this.pokemonCourant = pokemonCourant;
    }
}
