package Launch;

import Modele.AfficheurPokemon;
import Modele.DeplacerPokemon;
import Modele.Pokemon;
import Modele.Position;
import Modele.Type;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
        Canvas racine = (Canvas) fxmlloader.load();
        VBox content = new VBox();
        Scene scene = new Scene(content,500,500);
        GraphicsContext gc = racine.getGraphicsContext2D();
        content.getChildren().add( racine );

        stage.setScene(scene);
        stage.setTitle("C'est la fenêtre du jeu!");
        Position position = new Position(0,0);
        Type type = plante;
        AfficheurPokemon affich = new AfficheurPokemon();
        Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurimg,10,10,10,10,position,type);
        DeplacerPokemon dp = new DeplacerPokemon();
        System.out.println(pokemon.getPosition());
        dp.deplacer(pokemon,10,10);
        System.out.println(pokemon.getPosition());
        affich.affiche(pokemon,gc);

        stage.show();
    }
}
