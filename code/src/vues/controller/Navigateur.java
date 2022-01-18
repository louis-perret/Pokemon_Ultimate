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

public class Navigateur {

    private Manager manager = launch.launcher.getManager();
    private Stage primaryStage = launch.launcher.getPrimaryStage();

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

    public void lancerFenetreJeu() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/Fenetre.fxml")));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                manager.deplacerPokemon(keyEvent.getCode().getChar());

            });
            manager.setCarteCourante("lobby");
            manager.lancerBoucleJeu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
