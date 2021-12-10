package tests;

import javafx.scene.image.Image;
import modele.*;

import java.net.URL;

public class Test {

    private static Manager manager = new Manager(); //On effectuera nos tests en passant par le manager

    public static void testAttaque(){
        System.out.println("Test sur l'attaque");
        Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon bulbizarre = new Pokemon("Bulbizarre",null,50,10,10,10,null,Type.plante,tabMouvements);
        tabMouvements[0]=m1;
        Pokemon salameche = new Pokemon("Salamèche",null,10,10,10,10,null, Type.feu,tabMouvements);

        System.out.println("Le pokemon " + salameche.getNom() + " attaque "+ bulbizarre.getNom() + " avec " + m1.getNom());
        Attaqueur attaqueur = new AttaqueurPokemon();
        System.out.println("PV de "  + bulbizarre.getNom() + " avant attaque = " + bulbizarre.getPv());
        manager.attaquerPokemon(salameche,bulbizarre,m1);
        System.out.println("PV de "  + bulbizarre.getNom() + " après attaque = " + bulbizarre.getPv() + "\n");
    }

    public static void testDeplacer(){
        System.out.println("Test sur le déplacement");
        Position positionInitiale = new Position(0,0);
        Pokemon bulbizarre = new Pokemon("Bulbizarre",null,50,10,10,10,positionInitiale,Type.plante,null);
        System.out.println("Position actuelle de " + bulbizarre.getNom() + " = " + bulbizarre.getPosition());
        manager.deplacerPokemon(bulbizarre,10,10);
        System.out.println("Position actuelle de " + bulbizarre.getNom() + " = " + bulbizarre.getPosition() + "\n");
    }
}
