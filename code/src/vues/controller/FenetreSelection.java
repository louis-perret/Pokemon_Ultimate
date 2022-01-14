package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import launch.launcher;
import modele.Manager;
import modele.pokemon.Pokemon;

import java.io.IOException;
import java.util.List;

public class FenetreSelection {

    @FXML
    private HBox hbox;

    @FXML
    private ImageView Image;
    @FXML
    private ImageView Image2;
    @FXML
    private ImageView Image3;

    @FXML
    private Button boutonbulb;

    @FXML
    private Button boutonsalam;

    @FXML
    private Button boutoncarap;

    Navigateur navigateur = new Navigateur();

    private Manager manager = launcher.getManager();
    private List<Pokemon> listeStarter;




    public void choixPokemon(ActionEvent actionEvent) {

        listeStarter = manager.getStarterslvl1();

        if (actionEvent.getSource() == boutonbulb){
            navigateur.choixPokemon1(actionEvent);
            manager.setPokemonCourant(listeStarter.get(0));
        }

        if (actionEvent.getSource() == boutonsalam){
            navigateur.choixPokemon2(actionEvent);
            manager.setPokemonCourant(listeStarter.get(1));

        }

        if (actionEvent.getSource() == boutoncarap){
            navigateur.choixPokemon3(actionEvent);
            manager.setPokemonCourant(listeStarter.get(2));

        }



    }



    private Image b = new Image(getClass().getResource("/sprite/Sprite_bulbi/bulbasaur-sprite.png").toExternalForm());
    private Image c = new Image(getClass().getResource("/sprite/Sprite_salam/charmender-sprite.png").toExternalForm());
    private Image s = new Image(getClass().getResource("/sprite/Sprite_carap/squirtle-sprite.png").toExternalForm());

    public void initialize(){
        hbox.setPadding(new Insets(20));
        Image.setImage(b);
        Image2.setImage(c);
        Image3.setImage(s);

    }
}
