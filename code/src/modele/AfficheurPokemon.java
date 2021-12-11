package modele;

import javafx.scene.canvas.GraphicsContext;

public class AfficheurPokemon implements Afficheur{
    @Override
    public void affiche(Object objet, Position position, GraphicsContext gc){
        if (!(objet instanceof Pokemon)) {
            throw new IllegalArgumentException("L'objet " + objet.toString() + " passé en paramètre n'est pas un pokemon.");
        }
        Pokemon pokemon = (Pokemon) objet;
        gc.drawImage(pokemon.getImage(), position.getPositionX(), position.getPositionY());
    }
}
