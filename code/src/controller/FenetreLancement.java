package controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
