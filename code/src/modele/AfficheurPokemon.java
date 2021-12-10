package Modele;

import javafx.scene.canvas.GraphicsContext;

public class AfficheurPokemon implements Afficheur{
    public void affiche(Pokemon pokemon, Position position, GraphicsContext gc){
        gc.drawImage(pokemon.getImage(), position.getPositionX(), position.getPositionY());
    }
}
