package launch;

import javafx.scene.input.KeyEvent;
import modele.chargement.Stub;
import modele.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tests.Test;
import vues.controller.Navigateur;

//import static Modele.Type.plante;

public class launcher extends Application {

    private static Manager manager = new Stub().charger();
    private static Stage primaryStage;
    private Navigateur navigateur;


    public static Manager getManager() {
        return manager;
    }

    public static void setManager(Manager m) {
        launcher.manager = m;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public Navigateur getNavigateur() {
        return navigateur;
    }

    public void setNavigateur(Navigateur navigateur) {
        this.navigateur = navigateur;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
        stage.setTitle("Pokemon Colosseum");

        navigateur = new Navigateur();
        navigateur.lancerFenetreLancement();
        //primaryStage.show();

        /* Appel des tests */
        Test.testAttaque();
        //Test.testDeplacer();
        //TestBoucle.testBoucleJeu();
        //TestMonde.testerChargementCarte();
        //TestMonde.testerGetTuile();
    }
}
