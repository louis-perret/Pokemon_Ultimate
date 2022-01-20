package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import launch.launcher;
import modele.Manager;
import modele.pokemon.Pokemon;
import vues.afficheur.AfficheurPokemon;

import java.util.List;

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
    @FXML
    private Text nbVictoire;

    AfficheurPokemon afficheurPokemon = new AfficheurPokemon();
    Navigateur navigateur = new Navigateur();
    private Manager manager = launcher.getManager();
    private List<Pokemon> listeStarter;


    public void choixPokemon(ActionEvent actionEvent) {
        if (actionEvent.getSource() == boutonbulb){
            manager.setPokemonCourant(listeStarter.get(0));
        }
        if (actionEvent.getSource() == boutonsalam){
            manager.setPokemonCourant(listeStarter.get(1));
        }
        if (actionEvent.getSource() == boutoncarap){
            manager.setPokemonCourant(listeStarter.get(2));
        }
        navigateur.lancerFenetreJeu();
    }



    private Image b = new Image(getClass().getResource("/sprite/Sprite_bulbi/bulbasaur-sprite.png").toExternalForm());
    private Image c = new Image(getClass().getResource("/sprite/Sprite_salam/charmender-sprite.png").toExternalForm());
    private Image s = new Image(getClass().getResource("/sprite/Sprite_carap/squirtle-sprite.png").toExternalForm());

    public void initialize(){
        hbox.setPadding(new Insets(20));
        listeStarter = manager.getStarterslvl1();
        nbVictoire.textProperty().bind(manager.nbVictoiresProperty().asString());

        Image.setImage(b);
        Image2.setImage(c);
        Image3.setImage(s);

    }
}
