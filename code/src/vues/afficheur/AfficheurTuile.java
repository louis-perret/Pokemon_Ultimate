package vues.afficheur;

import javafx.scene.image.ImageView;
import modele.Position;
import modele.tuiles.Tuile;

//Permet d'afficher uen tuile

public class AfficheurTuile  implements Afficheur {
    /**
     * Affiche une tuile
     * @param objet : tuile à afficher
     * @param position : la position où l'insérer
     */

    @Override
    public ImageView affiche(Object objet, Position position){
        if (!(objet instanceof Tuile)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas une tuile.");
        }
        Tuile tuile = (Tuile) objet;
        ImageView img = new ImageView();
        img.setImage(tuile.getImage());
        img.setX(position.getPositionX());
        img.setY(position.getPositionY());
        return img;
        //gc.drawImage(tuile.getImage(), position.getPositionX(), position.getPositionY());
    }


}
