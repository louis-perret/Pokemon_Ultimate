package modele.deplaceur;

import modele.monde.Carte;
import modele.pokemon.Position;

/**
 * Classe qui gère les évènements
 */

public abstract class ChangeurCarte {

    private int hauteurSurface;
    private int largeurSurface;
    private int hauteurTuile; //Taille du pas

    /**
     * Détecte des évènements en se déposant.
     * @param positionActuel : Position actuelle du joueur
     * @param carte : Carte sur laquelle on se déplace
     * @return un entier, il y a un entier par évènement
     */

    public abstract int isChangement(Position positionActuel, Carte carte);

    public int getHauteurSurface() {
        return hauteurSurface;
    }

    public void setHauteurSurface(int hauteurSurface) {
        this.hauteurSurface = hauteurSurface;
    }

    public int getLargeurSurface() {
        return largeurSurface;
    }

    public void setLargeurSurface(int largeurSurface) {
        this.largeurSurface = largeurSurface;
    }

    public int getHauteurTuile() {
        return hauteurTuile;
    }

    public void setHauteurTuile(int hauteurTuile) {
        this.hauteurTuile = hauteurTuile;
    }
}
