package tests;

import modele.Manager;
import modele.boucle.BoucleJeu16;
import modele.boucle.*;
import modele.chargement.Stub;
import observateurs.Observateur;
import observateurs.ObservateurBoucle;

import java.util.LinkedList;
import java.util.List;

public class TestBoucle {

    public static void testBoucleJeu(){
        Manager m = new Stub().charger();
        List<Observateur> listeOb = new LinkedList<>();
        Observateur o = new ObservateurBoucle(m);
        listeOb.add(o);
        BoucleJeu b = new BoucleJeu16(listeOb);
        Thread t = new Thread(b);
        t.start();
        while(m.getCompteur()<10) {
            System.out.println("Compteur : " + m.getCompteur());
        }
    }
}
