package modele;

import javafx.scene.canvas.GraphicsContext;

public interface Afficheur {
    void affiche(Pokemon pokemon, Position position, GraphicsContext gc);
}
