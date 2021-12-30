package vues.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.*;
import launch.*;
import vues.afficheur.Afficheur;
import vues.afficheur.AfficheurPokemon;
import vues.afficheur.AfficheurTuile;
import vues.monde.Monde;

public class Fenetre {

    @FXML
    private GridPane grid;
    @FXML
    private ImageView imageView;
    @FXML
    private Group groupe;

    private ImageView a = new ImageView();
    private Manager manager = launcher.getManager();
    private Afficheur afficheurPokemon = new AfficheurPokemon();
    private Afficheur afficheurTuile = new AfficheurTuile();
    private IntegerProperty compteur = new SimpleIntegerProperty();


    public void initialize(){
        Group racine = new Group();
        Monde monde = new Monde("Ressources/Monde.txt");
        racine = monde.affichage();
        groupe.getChildren().addAll(racine);

        compteur.bind(manager.compteurProperty()); //binding unidirectionnel
        //On lui affecte un ChangeListener
        compteur.addListener((observableValue, number, t1) -> {



            a = afficheurPokemon.affiche(manager.getPokemonCourant(),manager.getPokemonCourant().getPosition());
            imageView.setImage(a.getImage());
            imageView.setTranslateX(a.getX());
            imageView.setTranslateY(a.getY());


        }
        );
    }
}
