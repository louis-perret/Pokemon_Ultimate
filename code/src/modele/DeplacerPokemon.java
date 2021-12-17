package modele;

//Permet de déplacer un pokemon
public class DeplacerPokemon implements Deplaceur{
    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param position : la position à laqulle déplacer le pokemon
     */
    public void deplacer(Pokemon p, Position position){
        p.getPosition().setPositionX(position.getPositionX());
        p.getPosition().setPositionY(position.getPositionY());

    }
}