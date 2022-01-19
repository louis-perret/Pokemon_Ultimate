package modele.deplaceur;

import modele.monde.Carte;
import modele.pokemon.Position;

public abstract class ChangeurCarte {

    private int hauteurSurface;
    private int largeurSurface;
    private int hauteurTuile; //Taille du pas

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
