package vues.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FenetreLancement {

    @FXML
    private VBox vbox;

    @FXML
    private Text t1;

    @FXML
    private Button boutonStart;

    Navigateur navigateur = new Navigateur();

    /**
     * Lance la fenêtre de jeu
     */
    public void lancementJeu() {
        navigateur.lancerFenetreSelection();
    }


    /**
     * Ferme la fenêtre de jeu
     */
    public void quitterJeu() throws Exception {
        navigateur.quitterJeu();
    }

    /**
     * Initialisation
     */
    public void initialize(){
        vbox.setPadding(new Insets(10));
    }


}
