package modele.deplaceur;

import modele.monde.Carte;
import modele.pokemon.Position;

import static java.lang.Math.abs;

/**
 * Classe gérant les collisions
 */
public class CollisionneurV1 extends Collisionneur{

    /**
     * Constructeur
     */

    public CollisionneurV1(int hauteurFenetre, int largeurFenetre){
        setHauteurSurface(hauteurFenetre/2);
        setLargeurSurface(largeurFenetre);
        setHauteurTuile(32);
    }

    /**
     * Effectue les collisions pour le déplacement
     * @param nextPosition : Position enviée
     * @param carte : Carte sur laquelle on se déplace
     * @return True si y'a collision
     */
    public boolean isCollision(Position nextPosition, Carte carte){
        int nextX = (int)nextPosition.getPositionX();
        int nextY = (int)nextPosition.getPositionY();
        if(nextX < 0 ) { return true; } //Pour pas passer outre la bordure de gauche
        if(abs(nextY) >= getHauteurSurface() || nextX>=getLargeurSurface()) { //Pour pas dépasser les autres bordures
            return true;
        }

        //Le y sur la fenêtre commence à 0 au milieu de la fenêtre, il fallait gérer cette partie
        int posTuilX = nextX/getHauteurTuile(),posTuilY = nextY;
        if(posTuilY<0){ //Si c'est négatif
            posTuilY = (abs(getHauteurSurface() - getHauteurTuile()) + posTuilY)/getHauteurTuile(); //On fait partir le y du début du tableau
        }
        else{ //Si c'est positif
            posTuilY=(carte.getHauteur()/2)+(posTuilY/getHauteurTuile()); //on fait partir le y du milieu du tableau
        }
        return !carte.getTuile(posTuilX,posTuilY).getTraversable(); //Renvoie true s'il y a collision
    }
}
