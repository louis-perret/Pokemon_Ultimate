package modele;

import javafx.scene.canvas.GraphicsContext;

//Interface pour nos afficheurs
public interface Afficheur {

    /**
     * Objet à afficher
     * @param objet : objet à afficher
     * @param position : à telle position
     * @param gc : dans quel container
     */
    void affiche(Object objet, Position position, GraphicsContext gc);
}
