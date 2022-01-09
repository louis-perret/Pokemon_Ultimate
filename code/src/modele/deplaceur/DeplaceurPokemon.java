package modele.deplaceur;

import modele.pokemon.Pokemon;
import modele.pokemon.Position;
import modele.monde.Carte;

//Permet de déplacer un pokemon
public class DeplaceurPokemon extends Deplaceur {

    //Constructeur
    public DeplaceurPokemon() {
        super.setCollisionneur(new CollisionneurV1());
    }

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param keyChar : touche appuyée
     * @param carte : Carte pour vérifier la collision
     */
    @Override
    public void deplacer(Pokemon p, String keyChar, Carte carte){
        switch (keyChar){
            case "Z" :
                deplacerEnHaut(p,carte);
                break;
            case "D" :
                deplacerADroite(p,carte);
                break;
            case "S" :
                deplacerEnBas(p,carte);
                break;
            case "Q" :
                deplacerAGauche(p,carte);
                break;
        }
    }

    /* Déplacer dans les 4 directions */

    /**
     * Déplacer le pokemon vers la gauche
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerAGauche(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX()-32,positionPokemon.getPositionY()); //On set la nouvelle position
        if(!super.getCollisionneur().isCollision(position,carte)) { //Si y'a pas de collisions
            //On update les coordonnées du pokemon
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer le pokemon vers la droite
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerADroite(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX()+32,positionPokemon.getPositionY());
        if(!super.getCollisionneur().isCollision(position,carte)) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer le pokemon vers le haut
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnHaut(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX(),positionPokemon.getPositionY()-32);
        if(!super.getCollisionneur().isCollision(position,carte)) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }

    /**
     * Déplacer le pokemon vers le bas
     * @param p : Pokemon a déplacer
     * @param carte : Carte pour la collision
     */
    @Override
    public void deplacerEnBas(Pokemon p,Carte carte) {
        Position positionPokemon = p.getPosition();
        Position position = new Position(positionPokemon.getPositionX(),positionPokemon.getPositionY()+32);
        if(!super.getCollisionneur().isCollision(position,carte)) {
            p.getPosition().setPositionX(position.getPositionX());
            p.getPosition().setPositionY(position.getPositionY());
        }
    }
}