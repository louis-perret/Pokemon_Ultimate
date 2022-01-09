package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.attaqueur.Attaqueur;
import modele.attaqueur.AttaqueurPokemon;
import modele.attaqueur.ControleurNiveau;
import modele.deplaceur.DeplaceurPokemon;
import modele.deplaceur.Deplaceur;
import modele.monde.Tuile;
import modele.pokemon.CollectionPokemon;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;
import modele.monde.Carte;
import modele.monde.Monde;

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

    /**
     * Constructeur
     * @param collectionPokemon
     */
    public Manager(CollectionPokemon collectionPokemon, Map<Integer, Tuile>dicoTuiles){
        this.attaqueur = new AttaqueurPokemon();
        this.deplaceur = new DeplaceurPokemon();
        this.controleurNiveau=new ControleurNiveau(collectionPokemon);
        this.monde=new Monde(dicoTuiles);
    }

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon qui attaque
     * @param attaque : pokemon qui est attaqué
     * @param m : l'attaque utilisée
     */
    public void attaquerPokemon(Pokemon attaquant, Pokemon attaque, Mouvement m){
        boolean battu=attaqueur.attaquer(attaquant,attaque,m);
        if(battu) { //S'il a gagné le combat
            controleurNiveau.gagnerExperience(attaquant, attaque); //On le fait gagner de l'expéricence
        }
    }

    /**
     * Gère le déplacement d'un pokemon
     * @param keyChar : Touche appuyée par l'utilisateur
     */
    public void deplacerPokemon(String keyChar){
            deplaceur.deplacer(pokemonCourant,keyChar,carteCourante);
    }


    //Getter et setter
    public Pokemon getPokemonCourant() {
        return pokemonCourant;
    }

    public void setPokemonCourant(Pokemon pokemonCourant) {
        this.pokemonCourant = pokemonCourant;
    }

    public Carte getCarteCourante() {
        return carteCourante;
    }

    public void setCarteCourante(String nomCarte) {
        this.carteCourante = monde.getCarte(nomCarte);
    }

    public Monde getMonde() {
        return monde;
    }
}
