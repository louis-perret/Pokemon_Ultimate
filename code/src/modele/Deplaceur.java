package modele;

//Interface pour nos deplaceurs
public interface Deplaceur {

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param x : sa nouvelle position x
     * @param y : sa nouvelle position y
     */
    public void deplacer(Pokemon p,double x, double y);

}
