package vues.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import launch.launcher;
import modele.Manager;
import modele.pokemon.Pokemon;
import modele.pokemon.Position;
import modele.pokemon.Type;
import vues.afficheur.Afficheur;
import vues.afficheur.AfficheurPokemon;

import java.io.File;
import java.net.URL;

public class FenetreCombat {

    @FXML
    private BorderPane panecombat;
    @FXML
    private ImageView fond;
    @FXML
    private ImageView joueur;
    @FXML
    private ImageView ennemi;
    @FXML
    private Button Attaque1;
    @FXML
    private Button Attaque2;
    @FXML
    private Button Attaque3;
    @FXML
    private Button Attaque4;

    private ImageView a = new ImageView();
    //Pokemon test = new Pokemon("abra","/sprite/abra.png",15,5,5,10,new Position(0,0), )
    private Afficheur afficheurPokemon = new AfficheurPokemon();
    private Image fondimg = new Image(getClass().getResource("/FondCombat/Fond.png").toExternalForm());
    private Image joueurimg = new Image(getClass().getResource("/sprite/Sprite_bulbi/bulb_combat_dos.png").toExternalForm());
    private Image ennemiimg = new Image(getClass().getResource("/sprite/abra.png").toExternalForm());
    private Manager manager = launcher.getManager();
    private IntegerProperty pvProperty = new SimpleIntegerProperty();

    Navigateur navigateur = new Navigateur();

    public void lancementCombat(ActionEvent actionEvent) {
        navigateur.lancerFenetreCombat();
    }

    public void initialize(){

        Pokemon pokemonCourant = manager.getPokemonCourant();

        //pvProperty.bind(manager.pvProperty());
        panecombat.setBackground(new Background(new BackgroundImage(fondimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        joueur.setX(100);
        joueur.setY(220);
        joueur.setImage(joueurimg);
        ennemi.setX(500);
        ennemi.setY(100);
        ennemi.setImage(ennemiimg);
        //panecombat.setAccessibleText(pvProperty);

    }
}
