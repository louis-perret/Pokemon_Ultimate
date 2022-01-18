package modele.deplaceur;

import modele.pokemon.Pokemon;
import modele.monde.Carte;

/**
 * Interface pour les déplacements d'un pokemon
 */
public abstract class DeplaceurPokemon {

    private Collisionneur collisionneur; //pour savoir les collisions

    //Getter et Setter
    public Collisionneur getCollisionneur() {
        return collisionneur;
    }

    public void setCollisionneur(Collisionneur collisionneur) {
        this.collisionneur = collisionneur;
    }

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokemon à déplacer
     * @param keyChar : touche appuyée
     * @param carte : Carte pour vérifier la collision
     */
    public abstract void deplacer(Pokemon p, String keyChar, Carte carte);


    /* Déplacer dans les 4 directions */

    /**
     * Déplacer le pokemon vers la gauche
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerAGauche(Pokemon p,Carte carte);

    /**
     * Déplacer le pokemon vers la droite
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerADroite(Pokemon p,Carte carte);

    /**
     * Déplacer le pokemon vers le haut
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnHaut(Pokemon p,Carte carte);

    /**
     * Déplacer le pokemon vers le bas
     * @param p : Pokemon à déplacer
     * @param carte : Carte pour la collision
     */
    public abstract void deplacerEnBas(Pokemon p,Carte carte);
}
