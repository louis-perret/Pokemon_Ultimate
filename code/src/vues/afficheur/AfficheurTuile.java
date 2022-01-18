package vues.afficheur;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.pokemon.Position;
import modele.monde.Tuile;

/**
 * Classe qui gère l'affichage d'une tuile
 */
public class AfficheurTuile  implements Afficheur {

    /**
     * Gère l'affichage d'un objet
     * @param objet : objet à afficher
     * @param position : à telle position
     * @return une ImageView
     */
    @Override
    public ImageView affiche(Object objet, Position position){
        if (!(objet instanceof Tuile)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas une tuile.");
        }
        Tuile tuile = (Tuile) objet;
        ImageView img = new ImageView();
        img.setImage(new Image(tuile.getImage()));
        img.setX(position.getPositionX());
        img.setY(position.getPositionY());
        return img;
    }


}
