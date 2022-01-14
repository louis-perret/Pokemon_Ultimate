package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import modele.Manager;
import modele.pokemon.Pokemon;

import java.io.IOException;
import java.util.List;

public class Navigateur {




    public void lancementJeu(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/FenetreSelection.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/Selection.css").toExternalForm());
            launch.launcher.getPrimaryStage().setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choixPokemon1(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/Fenetre.fxml")));
            Scene scene = new Scene(parent);
            launch.launcher.getPrimaryStage().setScene(scene);
            System.out.println(launch.launcher.getPrimaryStage().getScene());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choixPokemon2(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/Fenetre.fxml")));
            Scene scene = new Scene(parent);
            launch.launcher.getPrimaryStage().setScene(scene);
            System.out.println(launch.launcher.getPrimaryStage().getScene());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choixPokemon3(ActionEvent actionEvent) {
        try {

            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/Fenetre.fxml")));
            Scene scene = new Scene(parent);
            launch.launcher.getPrimaryStage().setScene(scene);
            System.out.println(launch.launcher.getPrimaryStage().getScene());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
