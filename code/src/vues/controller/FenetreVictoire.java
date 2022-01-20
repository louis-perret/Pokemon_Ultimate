package vues.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;

public class FenetreVictoire {
    @FXML
    private ImageView masterball;
    @FXML
    private Button quitter;

    private Image master = new Image(getClass().getResource("/ContenuFenetres/masterball.png").toExternalForm());
    Navigateur navigateur = new Navigateur();

    public void retour(javafx.event.ActionEvent actionEvent){
        navigateur.lancerFenetreLancement();
    }



    public void initialize(){
        masterball.setImage(master);
    }



}
