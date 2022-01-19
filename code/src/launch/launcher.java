package launch;

import chargement.Chargeur;
import chargement.ChargeurBinaire;
import chargement.Stub;
import modele.*;
import javafx.application.Application;
import javafx.stage.Stage;
import tests.Test;
import tests.TestPersistance;
import vues.controller.Navigateur;

//import static Modele.Type.plante;

public class launcher extends Application {

    private static Manager manager;
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

        Chargeur chargeur = new ChargeurBinaire("Ressources/source/source.bin");
        manager=chargeur.charger();

        navigateur = new Navigateur();
        navigateur.lancerFenetreLancement();
        primaryStage.show();


        /* Appel des tests */

        //Test.testAttaque();
        //Test.testVague();

        //Test.testDeplacer();
        //TestBoucle.testBoucleJeu();
        //TestMonde.testerChargementCarte();
        //TestMonde.testerGetTuile();
        //TestPersistance.testSauvegarde();
        //TestPersistance.testChargement();
    }
}
