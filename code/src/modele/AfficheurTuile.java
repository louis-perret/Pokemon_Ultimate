package modele;

import javafx.scene.canvas.GraphicsContext;
import modele.tuiles.Tuile;

//Permet d'afficher uen tuile
public class AfficheurTuile  implements Afficheur{
    /**
     * Affiche une tuile
     * @param objet : tuile à afficher
     * @param position : la position où l'insérer
     * @param gc : dans quel container
     */
    @Override
    public void affiche(Object objet, Position position, GraphicsContext gc){
        if (!(objet instanceof Tuile)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas une tuile.");
        }
        Tuile tuile = (Tuile) objet;
        gc.drawImage(tuile.getImage(), position.getPositionX(), position.getPositionY());
        System.out.println(("test"));
    }
}
