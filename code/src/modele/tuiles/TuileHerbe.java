package Modele.Tuiles;

import javafx.scene.image.Image;

import java.net.URL;

public class TuileHerbe extends Tuile{
    public TuileHerbe(int id){
        super(id, "Herbe.png"/*new Image(new URL(getClass().getResource("Herbe.png")).toExternalForm())*/);
    }

    @Override
    public boolean isTraversable(){
        return true;
    }
}
