package modele;

import javafx.scene.canvas.GraphicsContext;

public interface Afficheur {
    void affiche(Object objet, Position position, GraphicsContext gc);
}
