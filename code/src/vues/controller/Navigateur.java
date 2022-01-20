package vues.controller;

import persistance.Sauveur;
import persistance.SauveurBinaire;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modele.Manager;

import java.io.IOException;

/**
 * Classe qui permet le déplacement entre nos différentes fenêtres
 */
public class Navigateur {

    private Manager manager = launch.launcher.getManager(); //manager du jeu
    private Stage primaryStage = launch.launcher.getPrimaryStage(); //la fenêtre
    private String cheminFichier = launch.launcher.getCheminFichier();


    /**
     * Lance la première fenêtre du jeu
     */
    public void lancerFenetreLancement() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/vue/FenetreLancement.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/css/Lancement.css").toExternalForm());
            primaryStage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre où l'on sélectionne le starter du jeu
     */
    public void lancerFenetreSelection() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/vue/FenetreSelection.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/css/Selection.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre du jeu où l'on peut se déplacer
     */
    public void lancerFenetreJeu() {
        try {
            manager.setCarteCourante("lobby");
            //if(sceneJeu == null) {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/vue/Fenetre.fxml")));
            Scene scene = new Scene(parent);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
                manager.deplacerPokemon(keyEvent.getCode().getChar());
            });
            primaryStage.setScene(scene);
            primaryStage.setMinHeight(512);
            primaryStage.setMinWidth(320);
            primaryStage.setMaxHeight(512);
            primaryStage.setMaxWidth(320);
            manager.lancerBoucleJeu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre de combat du jeu
     */
    public void lancerFenetreCombat() {
        try {
            manager.terminerBoucleJeu();
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/vue/FenetreCombat.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/css/Combat.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setMinHeight(450);
            primaryStage.setMinWidth(800);
            primaryStage.setMaxHeight(450);
            primaryStage.setMaxWidth(800);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Ferme la fenêtre de jeu.
     */
    public void quitterJeu() throws Exception {
        Sauveur sauveur = new SauveurBinaire(cheminFichier);
        if (!sauveur.sauver(manager)) {
            throw new Exception("Problème dans la sauvegarde des données");
        }
        primaryStage.close();
    }

    /**
     * Lance la fenêtre quand on gagne
     */
    public void lancerFenetreVictoire() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/vue/FenetreVictoire.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/css/Victoire.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lance la fenêtre quand on perd
     */
    public void lancerFenetreDefaite() {
        try {
            Parent parent = FXMLLoader.load((getClass().getResource("/FXML/vue/FenetreDefaite.fxml")));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("/FXML/css/Defaite.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
