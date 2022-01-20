package tests;

import modele.Manager;
import persistance.Stub;

/**
 * Effectue le test sur la boucle de jeu
 */
public class TestBoucle {

    /**
     * Test la boucle de jeu
     */
    public static void testBoucleJeu(){
        Manager m = new Stub().charger();
        m.setPokemonCourant(m.getPokedex().getPokemon("Bulbizarre",1));
        m.lancerBoucleJeu();
        while(m.getCompteur()<10) {
            System.out.println("Compteur : " + m.getCompteur()); //on voit bien que le compteur est incrémenté indépendamment du while
        }
        m.terminerBoucleJeu();
    }
}
