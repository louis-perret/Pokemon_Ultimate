package Modele;

import javafx.scene.canvas.GraphicsContext;

public class AfficheurPokemon implements Afficheur{
    public void affiche(Pokemon pokemon, GraphicsContext gc){
        gc.drawImage(pokemon.getImage(),pokemon.getPosition().getPositionX() ,pokemon.getPosition().getPositionY());
    }
}
