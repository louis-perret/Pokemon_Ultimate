package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class FenetreSelection {

    @FXML
    private HBox hbox;

    @FXML
    private ImageView Image;
    @FXML
    private ImageView Image2;
    @FXML
    private ImageView Image3;

    @FXML
    private Button boutonbulb;

    @FXML
    private Button boutonsalam;

    @FXML
    private Button boutoncarap;

    public void choixPokemon(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/Fenetre.fxml")));
            Scene scene = new Scene(parent);
            if (actionEvent.getSource() == boutonbulb) {
                launch.launcher.getPrimaryStage().setScene(scene);
                System.out.println(launch.launcher.getPrimaryStage().getScene());

            }
            else if(actionEvent.getSource() == boutonsalam){
                //URL charmURL= getClass().getResource("/sprite/Sprite_salam/charmender-sprite.png");
                //Image charmimg = new Image(charmURL.toExternalForm());
                //Manager.setPokemonCourant(new Pokemon("Salamèche",charmimg,10,10,10,10,new Position(0,0), Type.feu,null,1,0,"Reptincel"));
                System.out.println("Salamèche");
                launch.launcher.getPrimaryStage().setScene(scene);

            }
            else if(actionEvent.getSource() == boutoncarap){
                System.out.println("Carapuce");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private Image b = new Image(getClass().getResource("/sprite/Sprite_bulbi/bulbasaur-sprite.png").toExternalForm());
    private Image c = new Image(getClass().getResource("/sprite/Sprite_salam/charmender-sprite.png").toExternalForm());
    private Image s = new Image(getClass().getResource("/sprite/Sprite_carap/squirtle-sprite.png").toExternalForm());

    public void initialize(){
        hbox.setPadding(new Insets(20));
        Image.setImage(b);
        Image2.setImage(c);
        Image3.setImage(s);

    }
}
