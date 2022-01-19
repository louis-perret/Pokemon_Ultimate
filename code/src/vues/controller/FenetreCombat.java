package vues.controller;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import launch.launcher;
import modele.Manager;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;
import modele.pokemon.Position;
import modele.pokemon.Type;
import vues.afficheur.Afficheur;
import vues.afficheur.AfficheurPokemon;

import java.io.File;
import java.net.URL;
import java.util.List;

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
    private Text nomJoueur;
    @FXML
    private Text pvJoueur;
    @FXML
    private Text nomEnnemi;
    @FXML
    private Text pvEnnemi;

    @FXML
    private Button attaque1;
    @FXML
    private Button attaque2;
    @FXML
    private Button attaque3;
    @FXML
    private Button attaque4;

    private ImageView a = new ImageView();
    private Afficheur afficheurPokemon = new AfficheurPokemon();
    private Image fondimg = new Image(getClass().getResource("/FondCombat/Fond.png").toExternalForm());
    //private Image joueurimg = new Image(getClass().getResource("/sprite/Sprite_bulbi/bulb_combat_dos.png").toExternalForm());
    private StringProperty joueurimg = new SimpleStringProperty();
    //private Image ennemiimg = new Image(getClass().getResource("/sprite/abra.png").toExternalForm());
    private StringProperty ennemiimg = new SimpleStringProperty();
    private Manager manager = launcher.getManager();

    Navigateur navigateur = new Navigateur();

    public void lancementCombat(ActionEvent actionEvent) {
        navigateur.lancerFenetreCombat();
    }

    private void setDecor(){
        panecombat.setBackground(new Background(new BackgroundImage(fondimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        joueur.setX(100);
        joueur.setY(200);
        joueur.setImage(new Image(joueurimg.get()));
        ennemi.setX(500);
        ennemi.setY(80);
        ennemi.setImage(new Image(ennemiimg.get()));
    }

    public void initialize(){
        manager.lancerVague(); //update le pokemon que devra affronter le joueur
        nomJoueur.textProperty().bind(manager.getPokemonCourant().nomProperty());
        pvJoueur.textProperty().bind(manager.getPokemonCourant().pvProperty().asString());
        nomEnnemi.textProperty().bind(manager.getPokemonEnnemiCourant().nomProperty());
        pvEnnemi.textProperty().bind(manager.getPokemonEnnemiCourant().pvProperty().asString());
        joueurimg.bind(manager.getPokemonCourant().imageCombatProperty());
        ennemiimg.bind(manager.getPokemonEnnemiCourant().imageCombatProperty());
        setDecor();


        int i=1; //Pour mettre une attaque dans un bouton
        for(Mouvement m : manager.getPokemonCourant().getMouvements()) {
            if(i==1) {
                attaque1.textProperty().bind(m.nomProperty());
            }
            if(i==2) {
                attaque2.textProperty().bind(m.nomProperty());
            }
            if(i==3) {
                attaque3.textProperty().bind(m.nomProperty());
            }
            if(i==4) {
                attaque4.textProperty().bind(m.nomProperty());
            }
            i++;
        }
    }
}
