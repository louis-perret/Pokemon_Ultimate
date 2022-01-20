package vues.controller;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modele.*;
import launch.*;
import modele.monde.Tuile;
import modele.pokemon.Position;
import vues.afficheur.Afficheur;
import vues.afficheur.AfficheurPokemon;
import vues.afficheur.AfficheurTuile;
import modele.monde.Carte;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.net.http.WebSocket;

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
    private IntegerProperty changeur = new SimpleIntegerProperty();
    Navigateur navigateur = new Navigateur();




    /**
     * Affiche la carte
     */
    public void affichageCarte(){
        Group racine = new Group();
        Carte carte = manager.getCarteCourante(); //On récupère la carte à charger

        //On parcours chaque tuile pour l'ajouter à racine
        for(int j=0;carte.getHauteur()>j;j++){
            for(int i=0;i<carte.getLargeur();i++) {
                racine.getChildren().addAll(afficheurTuile.affiche(carte.getTuile(i,j),new Position(i* Tuile.tuileLargeur,
                        j*Tuile.tuileHauteur)));
            }
        }
        if(!groupe.getChildren().isEmpty()) {
            groupe.getChildren().remove(0); //On enlève l'ancienne carte si y'en a une
        }
        groupe.getChildren().add(racine); //On ajoute la nouvelle carte
    }

    /**
     * Initialise la fenêtre à son chargement
     */
    public void initialize(){
        affichageCarte();
        changeur.bind(manager.changeurProperty()); //binding unidirectionnel
        compteur.bind(manager.compteurProperty()); //binding unidirectionnel
        //On lui affecte un ChangeListener pour effectuer une action quand la propriété change
        compteur.addListener((observableValue, number, newValue) -> {
            a = afficheurPokemon.affiche(manager.getPokemonCourant(),manager.getPokemonCourant().getPosition());
            imageView.setImage(a.getImage());
            imageView.setTranslateX(a.getX());
            imageView.setTranslateY(a.getY());

        }
        );
        changeur.addListener((observableValue2, number2, newValue2) -> {
            if(newValue2.intValue() == 3){
                navigateur.lancerFenetreCombat();
            }
            else {
                affichageCarte();
            }
        });
    }
}
