package vues.controller;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private ImageView etatJoueur;
    @FXML
    private Text nomEnnemi;
    @FXML
    private Text pvEnnemi;
    @FXML
    private ImageView etatEnnemi;

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
    private StringProperty joueurimg = new SimpleStringProperty();
    private StringProperty ennemiimg = new SimpleStringProperty();
    private Manager manager = launcher.getManager();

    Navigateur navigateur = new Navigateur();

    public void lancementCombat(ActionEvent actionEvent) {
        navigateur.lancerFenetreCombat();
    }

    /**
     * Bind les attaques du joueur
     */

    public void setBoutonsAttaques() {
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

    /**
     * Dispose les images sur la fenêtre.
     */

    private void setDecor(){
        panecombat.setBackground(new Background(new BackgroundImage(fondimg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        joueur.setX(100);
        joueur.setY(200);
        joueur.setImage(new Image(joueurimg.get()));
        ennemi.setX(500);
        ennemi.setY(80);
        ennemi.setImage(new Image(ennemiimg.get()));
    }



    /**
     * Fonction permettant d'effectuer la première attaque
     * @param actionEvent: clique de la souris
     */

    public void effectuerAttaque1(ActionEvent actionEvent) {
        if(attaque1.getText() != null) { //si le pokemon a une première attaque
            combat(manager.tourDeCombat(manager.getPokemonCourant(), manager.getPokemonEnnemiCourant(), manager.getPokemonCourant().getMouvement(attaque1.getText())));
        }
    }

    /**
     * Fonction permettant d'effectuer la deuxième attaque
     * @param actionEvent: clique de la souris
     */


    public void effectuerAttaque2(ActionEvent actionEvent) {
        if(attaque2.getText() != null) { //si le pokemon a une deuxième attaque
            combat(manager.tourDeCombat(manager.getPokemonCourant(), manager.getPokemonEnnemiCourant(), manager.getPokemonCourant().getMouvement(attaque2.getText())));
        }
    }

    /**
     * Fonction permettant d'effectuer la troisième attaque
     * @param actionEvent: clique de la souris
     */

    public void effectuerAttaque3(ActionEvent actionEvent) {
        if(attaque3.getText()!=null) { //si le pokemon a une troisième attaque
            combat(manager.tourDeCombat(manager.getPokemonCourant(), manager.getPokemonEnnemiCourant(), manager.getPokemonCourant().getMouvement(attaque3.getText())));
        }
    }

    /**
     * Fonction permettant d'effectuer la quatrième attaque
     * @param actionEvent: clique de la souris
     */

    public void effectuerAttaque4(ActionEvent actionEvent) {
        if(attaque4.getText()!=null) { //si le pokemon a une quatrième attaque
            combat(manager.tourDeCombat(manager.getPokemonCourant(), manager.getPokemonEnnemiCourant(), manager.getPokemonCourant().getMouvement(attaque4.getText())));
        }
    }

    /**
     * Permet de réaliser le combat
     * @param resultat: Résultat du combat
     */

    public void combat(int resultat){
        if(resultat == 2){
            navigateur.lancerFenetreDefaite();
        }
        else{
            if(resultat == 3){
                navigateur.lancerFenetreJeu();
            }
            else{
                if (resultat == 4){
                    navigateur.lancerFenetreVictoire();
                }
                else{
                    if(resultat == 1){ //si le pokemon ennemi est battu
                        etatEnnemi.setImage(null); //on actualise l'image de son état (car il en a pas au début)
                    }
                    if(manager.getPokemonCourant().getEtat()!=null){
                        etatJoueur.setImage(new Image(manager.getPokemonCourant().getEtat().getImage()));
                    }
                    if(manager.getPokemonEnnemiCourant().getEtat()!=null){
                        etatEnnemi.setImage(new Image(manager.getPokemonEnnemiCourant().getEtat().getImage()));
                    }
                }
            }
        }
    }

    /**
     * Initialisation.
     */
    public void initialize(){
        manager.lancerVague(); //update le pokemon que devra affronter le joueur
        nomJoueur.textProperty().bind(manager.getPokemonCourant().nomProperty());
        pvJoueur.textProperty().bind(manager.getPokemonCourant().pvProperty().asString());
        nomEnnemi.textProperty().bind(manager.getPokemonEnnemiCourant().nomProperty());
        pvEnnemi.textProperty().bind(manager.getPokemonEnnemiCourant().pvProperty().asString());
        joueurimg.bind(manager.getPokemonCourant().imageCombatProperty());
        ennemiimg.bind(manager.getPokemonEnnemiCourant().imageCombatProperty());
        setDecor();
        setBoutonsAttaques();
        nomJoueur.textProperty().addListener((observableValue, s, t1) -> {
        });


        //Dans le cas où l'image d'un des deux pokemon changent, il faut la recharger dans le ImageView
        joueurimg.addListener((observableValue, s, t1) -> {
                    setBoutonsAttaques();
                    joueur.setImage(new Image(joueurimg.get()));
                }
        );
        ennemiimg.addListener((observableValue, s, t1) -> {
                    ennemi.setImage(new Image(ennemiimg.get()));
                }
        );
    }
}
