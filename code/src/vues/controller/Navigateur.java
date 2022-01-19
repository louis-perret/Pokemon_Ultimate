package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modele.Manager;
import modele.pokemon.Pokemon;

import java.io.IOException;
import java.util.List;

/**
 * Classe qui permet le déplacement entre nos différentes fenêtres
 */
public class Navigateur {

    private Manager manager = launch.launcher.getManager(); //manager du jeu
    private Stage primaryStage = launch.launcher.getPrimaryStage(); //la fenêtre
    private Scene sceneJeu;
    private Scene sceneCombat;


    /**
     * Lance la première fenêtre du jeu
     */
    public void lancerFenetreLancement() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/FenetreLancement.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/Lancement.css").toExternalForm());
            primaryStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre où l'on sélectionne le starter du jeu
     */
    public void lancerFenetreSelection() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/FenetreSelection.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/Selection.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre du jeu où l'on peut se déplacer
     */
    public void lancerFenetreJeu() {
        try {
            manager.setCarteCourante("lobby");
            if(sceneJeu == null) {
                Parent parent = FXMLLoader.load((getClass().getResource("/FXML/Fenetre.fxml")));
                sceneJeu = new Scene(parent);
                sceneJeu.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                    manager.deplacerPokemon(keyEvent.getCode().getChar());

                });
            }
            primaryStage.setScene(sceneJeu);
            primaryStage.setMinHeight(512);
            primaryStage.setMinWidth(320);
            primaryStage.setMaxHeight(512);
            primaryStage.setMaxWidth(320);
            manager.lancerBoucleJeu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre de combat du jeu
     */
    public void lancerFenetreCombat() {
        try {
            manager.terminerBoucleJeu();
            if(sceneCombat == null) {
                Parent parent = FXMLLoader.load((getClass().getResource("/FXML/FenetreCombat.fxml")));
                sceneCombat = new Scene(parent);
                sceneCombat.getStylesheets().add(getClass().getResource("/FXML/Combat.css").toExternalForm());
            }
            primaryStage.setScene(sceneCombat);
            primaryStage.setMinHeight(450);
            primaryStage.setMinWidth(800);
            primaryStage.setMaxHeight(450);
            primaryStage.setMaxWidth(800);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void quitterJeu() {
        primaryStage.close();
    }
}
