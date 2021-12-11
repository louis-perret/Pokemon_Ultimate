package modele;

//Permet de déplacer un pokemon
public class DeplacerPokemon implements Deplaceur{
    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param x : sa nouvelle position x
     * @param y : sa nouvelle position y
     */
    public void deplacer(Pokemon p, double x, double y){
        p.getPosition().setPositionX(x);
        p.getPosition().setPositionY(y);

    }
}