package vues.afficheur;

import javafx.scene.image.ImageView;
import modele.pokemon.Position;

//Interface pour nos afficheurs
public interface Afficheur {

    /**
     * Objet à afficher
     * @param objet : objet à afficher
     * @param position : à telle position
     */
    ImageView affiche(Object objet, Position position);
}
