package tests;

import modele.Manager;
import chargement.Stub;
import modele.monde.*;

import java.util.Collection;

//Pour effectuer nos tests
public class TestMonde {

    private static Manager manager = new Stub().charger(); //On effectuera nos tests en passant par le manager

    /**
     * Teste le chargement de la carte
     */
    public static void testerChargementCarte(){
        Monde m = manager.getMonde();
        Collection<Carte> cartes = m.getLesCartes().values();
        for(Carte c : cartes){
            System.out.println(c);
        }
    }

    /**
     * Test de récupérer une tuile
     */
    public static void testerGetTuile(){
        Monde m = manager.getMonde();
        Carte c = m.getCarte("lobby");
        System.out.println(c.getTuile(6,1));
    }
}
