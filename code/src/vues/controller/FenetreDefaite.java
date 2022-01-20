package vues.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.awt.event.ActionEvent;

public class FenetreDefaite {

    @FXML
    private Button quitter;

    Navigateur navigateur = new Navigateur();

    public void fermer(javafx.event.ActionEvent actionEvent) {
        navigateur.lancerFenetreLancement();
    }

    public void initialize(){}
}
