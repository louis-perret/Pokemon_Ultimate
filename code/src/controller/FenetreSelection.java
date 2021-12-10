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

    private Image b = new Image(getClass().getResource("../Sprite_bulbi/bulbasaur-sprite.png").toExternalForm());
    private Image c = new Image(getClass().getResource("../Sprite_salam/charmender-sprite.png").toExternalForm());
    private Image s = new Image(getClass().getResource("../Sprite_carap/squirtle-sprite.png").toExternalForm());

    public void initialize(){
        hbox.setPadding(new Insets(20));
        Image.setImage(b);
        Image2.setImage(c);
        Image3.setImage(s);

    }
}
