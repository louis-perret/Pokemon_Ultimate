package Launch;

import Modele.*;
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

import static Modele.Type.plante;

public class launcher extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("../FXML/Fenetre.fxml");

        URL bulbURL= getClass().getResource("../Sprite_bulbi/bulbasaur-sprite.png");
        Image bulbasaurimg = new Image(bulbURL.toExternalForm());

        URL bulbfURL= getClass().getResource("../Sprite_bulbi/bulb_1.png");
        Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());

        URL charmURL= getClass().getResource("../Sprite_salam/charmender-sprite.png");
        Image charmimg = new Image(charmURL.toExternalForm());

        URL squirURL= getClass().getResource("../Sprite_carap/squirtle-sprite.png");
        Image squirimg = new Image(squirURL.toExternalForm());

        FXMLLoader fxmlloader = new FXMLLoader(url);
        //Canvas racine = (Canvas) fxmlloader.load(); //On charge la fenêtre
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



        Position position = new Position(0,0);
        Type type = plante;
        Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurfimg,50,10,10,10,position,type,tabMouvements);
        tabMouvements[0]=m1;
        Pokemon p = new Pokemon("Salamèche",bulbasaurimg,10,10,10,10,position, Type.feu,tabMouvements);
        AfficheurPokemon affich = new AfficheurPokemon();



        DeplacerPokemon dp = new DeplacerPokemon();
        System.out.println(pokemon.getPosition());
        dp.deplacer(pokemon,10,10);
        System.out.println(pokemon.getPosition());
        dp.deplacer(pokemon,20,20);
        System.out.println(pokemon.getPosition());


        System.out.println(p.toString());

        System.out.println("Le pokemon " + p.getNom() + " attaque "+ pokemon.getNom() + " avec " + m1.getNom());
        Attaqueur attaqueur = new AttaqueurPokemon();
        attaqueur.attaquer(p,pokemon,m1);
        System.out.println("PV de "  + pokemon.getNom() + " = " + pokemon.getPv());


        URL url2 = getClass().getResource("../FXML/FenetreSelection.fxml");
        /*
        fxmlloader = new FXMLLoader(url2);
        Parent parent = fxmlloader.load();
        Scene scene2=new Scene(parent);             //SCENE DE LA SELECTION
        stage.setScene(scene2);
        */
        affich.affiche(pokemon, pokemon.getPosition(), gc);
        //gc.drawImage(bulbasaurimg,0,0);
        stage.show();
    }
}
