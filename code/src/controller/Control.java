package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;

import java.net.URL;

public class Control {
    @FXML
    private Button demarrageButton;

    @FXML
    private void actionDemarrage(javafx.event.ActionEvent actionEvent) {
        demarrageButton.setText("Démarrage...");
    }

 
}
