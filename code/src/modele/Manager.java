package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import modele.attaqueur.Attaqueur;
import modele.attaqueur.AttaqueurPokemon;
import modele.attaqueur.ControleurNiveau;
import modele.deplaceur.DeplaceurPokemon;
import modele.deplaceur.Deplaceur;
import modele.monde.Tuile;
import modele.pokemon.*;
import modele.monde.Carte;
import modele.monde.Monde;

import java.net.URL;
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
     * @param m : l'attaque utilisée
     */
    public void attaquerPokemon(Pokemon attaquant, Pokemon attaque, Mouvement m){
        boolean battu=attaqueur.attaquer(attaquant,attaque,m);
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


    //Getter et setter
    public Pokemon getPokemonCourant() {

        /*if(pokemonCourant == null){
            URL bulbfURL= getClass().getResource("../sprite/Sprite_bulbi/bulb_1.png");
            Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());
            Position position = new Position(64,64);
            NomType nomType = NomType.plante;
            Mouvement m1 = new Mouvement(10,"flammèche", ;
            Mouvement m2 = new Mouvement(10,"fouet-liane", );
            Mouvement[] tabMouvements=new Mouvement[]{m2};
            Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurfimg,50,10,10,10,position, nomType,tabMouvements,1,0,null);
            this.setPokemonCourant(pokemon);
        }*/
        return pokemonCourant;
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
