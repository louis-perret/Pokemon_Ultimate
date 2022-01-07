package modele.deplaceur;

import modele.pokemon.Pokemon;
import modele.monde.Carte;

//Interface pour nos deplaceurs
public abstract class Deplaceur {

    private Collisionneur collisionneur;

    //Getter et Setter
    public Collisionneur getCollisionneur() {
        return collisionneur;
    }

    public void setCollisionneur(Collisionneur collisionneur) {
        this.collisionneur = collisionneur;
    }

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param keyChar : touche appuyée
     * @param carte : Carte pour vérifier la collision
     */
    public void deplacer(Pokemon p, String keyChar, Carte carte){

    }


    /* Déplacer dans les 4 directions */

    /**
     * Déplacer le pokemon vers la gauche
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    public void deplacerAGauche(Pokemon p,Carte carte){

    }

    /**
     * Déplacer le pokemon vers la droite
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    public void deplacerADroite(Pokemon p,Carte carte){

    }

    /**
     * Déplacer le pokemon vers le haut
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    public void deplacerEnHaut(Pokemon p,Carte carte){

    }

    /**
     * Déplacer le pokemon vers le bas
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    public void deplacerEnBas(Pokemon p,Carte carte){

    }
}
