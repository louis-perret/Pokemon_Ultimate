package vues.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FenetreVictoire {
    @FXML
    private ImageView masterball;

    private Image master = new Image(getClass().getResource("/ContenuFenetres/masterball.png").toExternalForm());

    public void initialize(){
        masterball.setImage(master);
    }
}
