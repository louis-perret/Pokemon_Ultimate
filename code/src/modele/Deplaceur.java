package modele;

//Interface pour nos deplaceurs
public interface Deplaceur {

    /**
     * Effectue le déplacement d'un pokemon
     * @param p : pokeon a déplacé
     * @param position : la position à laqulle déplacer le pokemon


     */
    public void deplacer(Pokemon p,Position position);

}
