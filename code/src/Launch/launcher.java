package Launch;

import Modele.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

        URL bulbURL= getClass().getResource("../bulbasaur-sprite.png");
        Image bulbasaurimg = new Image(bulbURL.toExternalForm());

        FXMLLoader fxmlloader = new FXMLLoader(url);
        Canvas racine = (Canvas) fxmlloader.load(); //On charge la fenêtre

        VBox content = new VBox();
        Scene scene = new Scene(content,500,500);
        GraphicsContext gc = racine.getGraphicsContext2D(); //Récupère le contexte graphic du canvas
        content.getChildren().add( racine ); //On ajoute le canvas dans la  Vbox

        stage.setScene(scene);
        stage.setTitle("C'est la fenêtre du jeu!");

        Position position = new Position(0,0);
        Type type = plante;
        Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurimg,50,10,10,10,position,type,tabMouvements);
        tabMouvements[0]=m1;
        Pokemon p = new Pokemon("Salamèche",bulbasaurimg,10,10,10,10,position, Type.feu,tabMouvements);
        AfficheurPokemon affich = new AfficheurPokemon();
        DeplacerPokemon dp = new DeplacerPokemon();
        System.out.println(pokemon.getPosition());
        dp.deplacer(pokemon,10,10);
        System.out.println(pokemon.getPosition());
        dp.deplacer(pokemon,20,20);
        System.out.println(pokemon.getPosition());
        affich.affiche(pokemon,gc);

        System.out.println(p.toString());

        System.out.println("Le pokemon " + p.getNom() + " attaque "+ pokemon.getNom() + " avec " + m1.getNom());
        Attaqueur attaqueur = new AttaqueurPokemon();
        attaqueur.attaquer(p,pokemon,m1);
        System.out.println("PV de "  + pokemon.getNom() + " = " + pokemon.getPv());


        URL url2 = getClass().getResource("../FXML/FenetreSelection.fxml");
        fxmlloader = new FXMLLoader(url2);
        Parent parent = fxmlloader.load();
        Scene scene2=new Scene(parent);
        stage.setScene(scene2);
        stage.show();
    }
}
