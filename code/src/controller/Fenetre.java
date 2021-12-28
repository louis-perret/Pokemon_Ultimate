package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import modele.Afficheur;
import modele.AfficheurPokemon;
import modele.Manager;
import launch.*;
import modele.Position;

import java.net.URL;

import static javafx.scene.input.KeyCode.*;

public class Fenetre {

    @FXML
    private GridPane grid;
    @FXML
    private ImageView imageView;

    private ImageView a = new ImageView();
    private Manager manager = launcher.getManager();
    private Afficheur afficheurPokemon = new AfficheurPokemon();
    private IntegerProperty compteur = new SimpleIntegerProperty();

    public void initialize(){
        compteur.bind(manager.compteurProperty()); //binding unidirectionnel
        //On lui affecte un ChangeListener
        compteur.addListener((observableValue, number, t1) -> {
            a= afficheurPokemon.affiche(manager.getPokemonCourant(),manager.getPokemonCourant().getPosition());
            imageView.setImage(a.getImage());
            imageView.setTranslateX(a.getX());
            imageView.setTranslateY(a.getY());
        }
        );
    }
}
