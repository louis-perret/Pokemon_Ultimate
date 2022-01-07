package vues.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.*;
import launch.*;
import modele.tuiles.Tuile;
import vues.afficheur.Afficheur;
import vues.afficheur.AfficheurPokemon;
import vues.afficheur.AfficheurTuile;
import vues.monde.Carte;
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
    Group racine = new Group();

    public Group affichageCarte(Carte carte){
        AfficheurTuile at = new AfficheurTuile();
        for(int i=0;carte.getLargeur()>i;i++){
            for(int j=0;j<carte.getHauteur();j++) {
                racine.getChildren().addAll(at.affiche(carte.getTuile(i,j),new Position(i* Tuile.TuileLargeur,
                        j*Tuile.TuileHauteur)));

            }
        }
        return racine;
    }


    public void initialize(){

        Monde monde = new Monde();
        racine = this.affichageCarte(monde.getLesCartes().get(1));
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
