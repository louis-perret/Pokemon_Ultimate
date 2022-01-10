package modele.deplaceur;

import modele.pokemon.Position;
import modele.monde.Carte;

import static java.lang.Math.abs;

//Gère les collisions
public abstract class Collisionneur {

    private int hauteurFenetre;
    private int largeurFenetre;
    private int hauteurTuile; //Taille du pas

    /**
     * Effectue les collisions pour le déplacement
     * @param nextPosition : Position enviée
     * @param carte : Carte sur laquelle on se déplace
     * @return True si y'a collision
     */
    public abstract boolean isCollision(Position nextPosition, Carte carte);

    //getter et setter
    public int getHauteurFenetre() {
        return hauteurFenetre;
    }

    public void setHauteurFenetre(int hauteurFenetre) {
        this.hauteurFenetre = hauteurFenetre;
    }

    public int getLargeurFenetre() {
        return largeurFenetre;
    }

    public void setLargeurFenetre(int largeurFenetre) {
        this.largeurFenetre = largeurFenetre;
    }

    public int getHauteurTuile() {
        return hauteurTuile;
    }

    public void setHauteurTuile(int hauteurTuile) {
        this.hauteurTuile = hauteurTuile;
    }
}
