package modele;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

//import static Modele.Type.plante;

public class BoucleJeu implements Runnable{

    private boolean tourne = true;
    private Thread thread;
    Stage stage;

    public BoucleJeu(){
        //Constructeur
    }



    public synchronized void debut(){

    }

    public synchronized void fin(){

    }

    private void beep(){

    }

    @Override
    public void run() {     //Boucle qui tick une fois par sec (normalement)



        fin();
    }
    //BOUCLE DE JEU  A FAIRE PLUS TARD
}
