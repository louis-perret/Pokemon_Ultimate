package vues.afficheur;

import javafx.scene.image.ImageView;
import modele.pokemon.Pokemon;
import modele.pokemon.Position;

//Permet d'afficher un pokemon
public class AfficheurPokemon implements Afficheur {

    /**
     * Affiche un pokemon
     * @param objet : pokemon à afficher
     * @param position : à telle position
     */
    @Override
    public ImageView affiche(Object objet, Position position){
        if (!(objet instanceof Pokemon)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas un pokemon.");
        }
        Pokemon pokemon = (Pokemon) objet;
        ImageView img = new ImageView(pokemon.getImage());
        img.setX(position.getPositionX());
        img.setY(position.getPositionY());
        return img;


    }
}
