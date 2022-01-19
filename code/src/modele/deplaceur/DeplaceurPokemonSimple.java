package modele.deplaceur;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Manager;
import modele.pokemon.Pokemon;
import modele.pokemon.Position;
import modele.monde.Carte;

//Permet de déplacer un pokemon
public class DeplaceurPokemonSimple extends DeplaceurPokemon {



    //Constructeur
    public DeplaceurPokemonSimple() {
        super.setCollisionneur(new CollisionneurV1());
        super.setChangeurCarte(new ChangeurCarteV1());
    }

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param keyChar : touche appuyée
     * @param carte : Carte pour vérifier la collision
     */
    @Override
    public void deplacer(Pokemon p, String keyChar, Carte carte, Manager manager){
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
        //Mettre isChangement ici
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 1) {
            manager.setCarteCourante("lobby");
            System.out.println(manager.getCarteCourante().toString());
            manager.setChangeur(1);

        }
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 2) {
            manager.setCarteCourante("arene");
            System.out.println(manager.getCarteCourante().toString());
            manager.setChangeur(2);

        }
        if(getChangeurCarte().isChangement(p.getPosition(), carte) == 3) {
            manager.terminerBoucleJeu();
            manager.setChangeur(3);

            //scene combat
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