package tests;

import modele.Manager;
import modele.boucle.BoucleJeu16;
import modele.boucle.*;
import modele.chargement.Stub;
import modele.observateurs.Observateur;
import modele.observateurs.ObservateurBoucle;

import java.util.LinkedList;
import java.util.List;

//Pour effectuer nos tests
public class TestBoucle {

    /**
     * Test la boucle de jeu
     */
    public static void testBoucleJeu(){
        Manager m = new Stub().charger();
        Observateur o = new ObservateurBoucle(m);
        BoucleJeu b = new BoucleJeu16();
        b.addObservateur(o);
        Thread t = new Thread(b);
        t.start();
        while(m.getCompteur()<10) {
            System.out.println("Compteur : " + m.getCompteur()); //on voit bien que le compteur est incrémenté indépendamment du while
        }
    }
}
