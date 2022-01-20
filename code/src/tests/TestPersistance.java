package tests;

import persistance.*;
import modele.Manager;

/**
 * Effectue les tests sur la persistance
 */
public class TestPersistance {

    private static Manager manager = new Stub().charger(); //On effectuera nos tests en passant par le manager

    /**
     * Test la sauvegarde du manager
     */
    public static void testSauvegarde(){
        String cheminFichier = "Ressources/source/source.bin";
        Sauveur sauveur = new SauveurBinaire(cheminFichier);
        sauveur.sauver(manager);
    }

    /**
     * Test le chargement du manager
     */
    public static void testChargement(){
        String cheminFichier = "Ressources/source/source.bin";
        Chargeur chargeur = new ChargeurBinaire(cheminFichier);
        Manager p = chargeur.charger();
        if(p != null){
            System.out.println("Chargement correcte.");
        }
    }
}
