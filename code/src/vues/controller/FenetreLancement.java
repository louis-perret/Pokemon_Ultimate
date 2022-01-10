package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class FenetreLancement {

    @FXML
    private VBox vbox;

    @FXML
    private Text t1;

    @FXML
    private Button boutonStart;

    public void lancementJeu(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/FenetreSelection.fxml")));
            Scene scene = new Scene(parent);
            launch.launcher.getPrimaryStage().setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        vbox.setPadding(new Insets(10));
    }


}
