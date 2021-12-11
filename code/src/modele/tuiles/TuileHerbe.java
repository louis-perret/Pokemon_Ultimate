package modele.tuiles;

import javafx.scene.image.Image;
import modele.chargement.Stub;

import java.net.URL;

public class TuileHerbe extends Tuile{



    public TuileHerbe(int id){
        super(id, Stub.Herbe);
    }

    @Override
    public boolean isTraversable(){
        return true;
    }
}
