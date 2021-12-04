package Controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;

public class FenetreSelection {

    @FXML
    private HBox hbox;

    @FXML
    private ImageView Image;
    @FXML
    private ImageView Image2;
    @FXML
    private ImageView Image3;

    private Image i = new Image(getClass().getResource("../bulbasaur-sprite.png").toExternalForm());

    public void initialize(){
        hbox.setPadding(new Insets(20));
        Image.setImage(i);
        Image2.setImage(i);
        Image3.setImage(i);

    }
}
