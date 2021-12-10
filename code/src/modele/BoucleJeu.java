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
    private void init(GraphicsContext gc){
        //appel pour l'affichage d'iamges ici
        URL url = getClass().getResource("../FXML/Fenetre.fxml");

        URL bulbURL= getClass().getResource("../Sprite/Sprite_bulbi/bulbasaur-sprite.png");
        Image bulbasaurimg = new Image(bulbURL.toExternalForm());

        URL bulbfURL= getClass().getResource("../Sprite/Sprite_bulbi/bulb_1.png");
        Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());

        URL charmURL= getClass().getResource("../Sprite/Sprite_salam/charmender-sprite.png");
        Image charmimg = new Image(charmURL.toExternalForm());

        URL squirURL= getClass().getResource("../Sprite/Sprite_carap/squirtle-sprite.png");
        Image squirimg = new Image(squirURL.toExternalForm());
        Position position = new Position(0,0);
        Type type = Type.plante;
        Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurfimg,50,10,10,10,position,type,tabMouvements);
        tabMouvements[0]=m1;
        Pokemon p = new Pokemon("Salamèche",bulbasaurimg,10,10,10,10,position, Type.feu,tabMouvements);

        AfficheurPokemon affich = new AfficheurPokemon();
        affich.affiche(pokemon, pokemon.getPosition(), gc);
    }

    private void Base(Stage stage){
        Group racine = new Group();
        Canvas canvas = new Canvas(1000,800);
        VBox content = new VBox();                                  //SCENE DE JEU
        Scene scene = new Scene(content,500,500);
        Scene scene3 = new Scene(racine);
        GraphicsContext gc = canvas.getGraphicsContext2D(); //Récupère le contexte graphic du canvas
        content.getChildren().add( canvas ); //On ajoute le canvas dans la  Vbox
        racine.getChildren().add(canvas);

        stage.setScene(scene3);
        stage.setTitle("C'est la fenêtre du jeu!");
        // bouger la définition du canvas, graphicscontext, ... du jeu ici
    }

    public synchronized void debut(){
        if (tourne)
            return;
        tourne = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void fin(){
        if (!tourne)
            return;
        tourne = false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void tick(){

    }

    @Override
    public void run() {     //Boucle qui tick une fois par sec (normalement)
        //init();

        int fps = 60;
        double tempsTick = 1000000000 / fps;
        double delta = 0;
        long actuel;
        long ancien = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while(tourne){
            actuel = System.nanoTime();
            delta += (actuel - ancien) / tempsTick;
            timer += actuel - ancien;
            ancien = actuel;
            if (delta >= 1){
                tick();
                Base(stage);
                ticks++;
                delta--;
            }
            if (timer >=1000000000){
                System.out.println("Tick");
                ticks =0;
                timer =0;
            }
        }
        fin();
    }
    //BOUCLE DE JEU  A FAIRE PLUS TARD
}
