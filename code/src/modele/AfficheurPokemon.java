package modele;

import javafx.scene.canvas.GraphicsContext;

//Permet d'afficher un pokemon
public class AfficheurPokemon implements Afficheur{

    /**
     * Affiche un pokemon
     * @param objet : pokemon à afficher
     * @param position : à telle position
     * @param gc : dans quel container
     */
    @Override
    public void affiche(Object objet, Position position, GraphicsContext gc){
        if (!(objet instanceof Pokemon)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas un pokemon.");
        }
        Pokemon pokemon = (Pokemon) objet;
        gc.drawImage(pokemon.getImage(), position.getPositionX(), position.getPositionY());
    }
}
