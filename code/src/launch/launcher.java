package launch;

import persistance.Chargeur;
import persistance.ChargeurBinaire;
import modele.*;
import javafx.application.Application;
import javafx.stage.Stage;
import persistance.Stub;
import tests.TestPersistance;
import vues.controller.Navigateur;

//import static Modele.Type.plante;

/**
 * Lance l'application
 */
public class launcher extends Application {

    private static Manager manager;
    private static Stage primaryStage;
    private Navigateur navigateur;
    private static String cheminFichier;

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

    public static String getCheminFichier() {
        return cheminFichier;
    }

    public static void setCheminFichier(String cheminFichier) {
        launcher.cheminFichier = cheminFichier;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
        stage.setTitle("Pokemon Colosseum");
        try {
            cheminFichier = "Ressources/source/source.bin";
            Chargeur chargeur = new ChargeurBinaire(cheminFichier);
            manager = chargeur.charger();
            //manager = new Stub().charger();
            navigateur = new Navigateur();
            navigateur.lancerFenetreLancement();
            primaryStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        /* Appel des tests */
        //Test.testAttaque();
        //TestBoucle.testBoucleJeu();
        //TestMonde.testerChargementCarte();
        //TestMonde.testerGetTuile();
        //TestPersistance.testSauvegarde();
        //TestPersistance.testChargement();
    }
}
