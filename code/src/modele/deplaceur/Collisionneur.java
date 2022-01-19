package modele.deplaceur;

import modele.pokemon.Position;
import modele.monde.Carte;

import static java.lang.Math.abs;

/**
 * Classe qui gère les collisions
 */
public abstract class Collisionneur {

    private int hauteurSurface; //hauteur de surface de jeu
    private int largeurSurface; //largeur de la surface de jeu
    private int hauteurTuile; //Taille du pas

    /**
     * Effectue les collisions pour le déplacement
     * @param nextPosition : Position enviée
     * @param carte : Carte sur laquelle on se déplace
     * @return True si y'a collision
     */
    public abstract boolean isCollision(Position nextPosition, Carte carte);

    //getter et setter
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
