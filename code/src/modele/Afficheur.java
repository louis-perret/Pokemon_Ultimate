package modele;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

//Interface pour nos afficheurs
public interface Afficheur {

    /**
     * Objet à afficher
     * @param objet : objet à afficher
     * @param position : à telle position
     */
    ImageView affiche(Object objet, Position position);
}
