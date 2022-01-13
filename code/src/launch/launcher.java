package launch;

import javafx.scene.input.KeyEvent;
import modele.boucle.BoucleJeu;
import modele.boucle.BoucleJeu16;
import modele.chargement.Stub;
import modele.observateurs.Observateur;
import modele.observateurs.ObservateurBoucle;
import modele.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;
import modele.pokemon.Position;
import modele.pokemon.Type;
import tests.Test;
import vues.afficheur.AfficheurPokemon;

import java.util.LinkedList;
import java.util.List;

//import static Modele.Type.plante;

public class launcher extends Application {

    private static Manager manager = new Stub().charger();

    private static Stage primaryStage;


    public static Manager getManager() {
        return manager;
    }

    public static void setManager(Manager m) {
        launcher.manager = m;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
        stage.setTitle("C'est la fenêtre du jeu!");

        /*Parent parent = FXMLLoader.load(getClass().getResource("../FXML/Fenetre.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);*/
        //primaryStage.show();
       /* URL url = getClass().getResource("../FXML/Fenetre.fxml");

        URL bulbURL= getClass().getResource("../sprite/Sprite_bulbi/bulbasaur-sprite.png");
        Image bulbasaurimg = new Image(bulbURL.toExternalForm());

        URL bulbfURL= getClass().getResource("../sprite/Sprite_bulbi/bulb_1.png");
        Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());

        URL charmURL= getClass().getResource("../sprite/Sprite_salam/charmender-sprite.png");
        Image charmimg = new Image(charmURL.toExternalForm());

        URL squirURL= getClass().getResource("../sprite/Sprite_carap/squirtle-sprite.png");
        Image squirimg = new Image(squirURL.toExternalForm());

        FXMLLoader fxmlloader = new FXMLLoader(url);
        //Canvas racine = (Canvas) fxmlloader.load(); //On charge la fenêtre
        Group racine = new Group();
        Canvas canvas = new Canvas(1000,800);
        VBox content = new VBox();                                  //SCENE DE JEU
        Scene scene = new Scene(content,500,500);
        //Scene scene3 = new Scene(racine);
        //GraphicsContext gc = canvas.getGraphicsContext2D(); //Récupère le contexte graphic du canvas
        content.getChildren().add( canvas ); //On ajoute le canvas dans la  Vbox
        racine.getChildren().add(canvas);

        //stage.setScene(scene3);
*/
        //racine.getChildren().addAll(affich.affiche(pokemon, pokemon.getPosition())
        //        /*affichT.affiche(Tuile.tuileHerbe ,new Position(0,0))*/ );


        //Test du déplacement

        Parent parent = FXMLLoader.load(this.getClass().getResource("../FXML/Fenetre.fxml"));
        Scene scene1 = new Scene(parent);
        primaryStage.setScene(scene1);
        //On ajoute un filtre d'évènement pour s'abonner à l'évènement keyPressed pour le déplacement du pokemon
        primaryStage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            manager.deplacerPokemon(keyEvent.getCode().getChar());
        });
/*
        stage.setScene(scene1);
        stage.setMaxHeight(520);
        stage.setMinHeight(520);
        stage.setMaxWidth(320);
        stage.setMinHeight(320);
        */
        manager.lancerBoucleJeu();
        primaryStage.show();

        /* Appel des tests */
        //Test.testAttaque();
        //Test.testDeplacer();
        //TestBoucle.testBoucleJeu();
        //TestMonde.testerChargementCarte();
        //TestMonde.testerGetTuile();
    }
}
