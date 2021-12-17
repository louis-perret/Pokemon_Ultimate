package launch;

import modele.tuiles.Tuile;
import modele.tuiles.TuileHerbe;
import tests.*;
import modele.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

//import static Modele.Type.plante;

public class launcher extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("../FXML/Fenetre.fxml");

        URL bulbURL= getClass().getResource("../Sprite/Sprite_bulbi/bulbasaur-sprite.png");
        Image bulbasaurimg = new Image(bulbURL.toExternalForm());

        URL bulbfURL= getClass().getResource("../Sprite/Sprite_bulbi/bulb_1.png");
        Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());

        URL charmURL= getClass().getResource("../Sprite/Sprite_salam/charmender-sprite.png");
        Image charmimg = new Image(charmURL.toExternalForm());

        URL squirURL= getClass().getResource("../Sprite/Sprite_carap/squirtle-sprite.png");
        Image squirimg = new Image(squirURL.toExternalForm());

        FXMLLoader fxmlloader = new FXMLLoader(url);
        //Canvas racine = (Canvas) fxmlloader.load(); //On charge la fenêtre
        Group racine = new Group();
        Canvas canvas = new Canvas(1000,800);
        VBox content = new VBox();                                  //SCENE DE JEU
        Scene scene = new Scene(content,500,500);
        Scene scene3 = new Scene(racine);
        //GraphicsContext gc = canvas.getGraphicsContext2D(); //Récupère le contexte graphic du canvas
        content.getChildren().add( canvas ); //On ajoute le canvas dans la  Vbox
        racine.getChildren().add(canvas);

        stage.setScene(scene3);
        stage.setTitle("C'est la fenêtre du jeu!");



        Position position = new Position(64,64);
        Type type = Type.plante;
        Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurfimg,50,10,10,10,position,type,tabMouvements,1,0,null);
        tabMouvements[0]=m1;
        Pokemon p = new Pokemon("Salamèche",bulbasaurimg,10,10,10,10,position, Type.feu,tabMouvements,1,0,null);
        AfficheurPokemon affich = new AfficheurPokemon();
        AfficheurTuile affichT = new AfficheurTuile();
        DeplacerPokemon dp = new DeplacerPokemon();


        System.out.println(p.toString());

        URL url2 = getClass().getResource("../FXML/FenetreSelection.fxml");
/*
        fxmlloader = new FXMLLoader(url2);
        Parent parent = fxmlloader.load();
        Scene scene2=new Scene(parent);             //SCENE DE LA SELECTION
        stage.setScene(scene2);
*/

        //affichT.affiche(Tuile.tuileHerbe ,new Position(0,0));
        /*
        affichT.affiche(Tuile.tuileHerbe ,new Position(0,32),gc);
        affichT.affiche(Tuile.tuileHerbe ,new Position(64,64),gc);
        affichT.affiche(Tuile.tuilePbg ,new Position(32,32),gc);
        affichT.affiche(Tuile.tuilePbd ,new Position(0,32),gc);
        affichT.affiche(Tuile.tuilePhg ,new Position(32,0),gc);
        affichT.affiche(Tuile.tuilePhd ,new Position(0,0),gc);
*/

        Monde monde = new Monde("");
        racine.getChildren().addAll(affich.affiche(pokemon, pokemon.getPosition()),
                affichT.affiche(Tuile.tuileHerbe ,new Position(0,0)));    //Méthode d'affichage sans graphic contexts (pas sur que ce soit bien)

        //BoucleJeu boucle = new BoucleJeu();
        //gc.drawImage(a,0,0);
        Touches t = new Touches();
        System.out.println(t.lecture(scene));

        //Thread b = new Thread(new BoucleJeu());
        //b.start();
        stage.show();
        //boucle.run();


        /* Appel des tests */
        Test.testAttaque();
        //Test.testDeplacer();
    }
}
