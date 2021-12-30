package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import modele.*;
import launch.*;
import modele.tuiles.Tuile;

import java.net.URL;

import static javafx.scene.input.KeyCode.*;

public class Fenetre {

    @FXML
    private GridPane grid;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView imageView2;

    private ImageView a = new ImageView();
    private ImageView at[] = new ImageView[10000];
    private Manager manager = launcher.getManager();
    private Afficheur afficheurPokemon = new AfficheurPokemon();
    private Afficheur afficheurTuile = new AfficheurTuile();
    private IntegerProperty compteur = new SimpleIntegerProperty();
    private Group racine = new Group();
    private Monde monde = new Monde("Ressources/Monde.txt");


    public void initialize(){
        compteur.bind(manager.compteurProperty()); //binding unidirectionnel
        //On lui affecte un ChangeListener
        compteur.addListener((observableValue, number, t1) -> {
/*
            racine = monde.affichage();
            AfficheurPokemon affich = new AfficheurPokemon();
            URL bulbfURL= getClass().getResource("../Sprite/Sprite_bulbi/bulb_1.png");
            Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());
            Position position = new Position(64,64);
            Type type = Type.plante;
            Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
            Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
            Mouvement[] tabMouvements=new Mouvement[]{m2};
            Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurfimg,50,10,10,10,position,type,tabMouvements,1,0,null);
            racine.getChildren().addAll(affich.affiche(pokemon, pokemon.getPosition()));
*/
            //at = afficheurTuile.affiche(Tuile.lesTuiles[1], new Position(220,220));
            /*
            imageView2.setImage(at[0].getImage());
            imageView2.setTranslateX(at[0].getX());
            imageView2.setTranslateY(at[0].getY());
            */
/*
            imageView2.setImage(at[1].getImage());
            imageView2.setTranslateX(at[1].getX());
            imageView2.setTranslateY(at[1].getY());

            a = afficheurPokemon.affiche(manager.getPokemonCourant(),manager.getPokemonCourant().getPosition());
            imageView.setImage(a.getImage());
            imageView.setTranslateX(a.getX());
            imageView.setTranslateY(a.getY());

*/
            //Monde monde = new Monde("");
            //at = monde.affichage();
            //imageView.setImage(at[0].getImage());
            //imageView.setImage(at[1].getImage());
            //imageView.setImage(at[2].getImage());
            //imageView.setImage(at[3].getImage());






        }
        );
    }
}
