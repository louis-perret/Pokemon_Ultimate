package vues.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FenetreLancement {

    @FXML
    private VBox vbox;

    @FXML
    private Text t1;

    public void initialize(){
        vbox.setPadding(new Insets(10));
    }
}
