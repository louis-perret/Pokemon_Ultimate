package tests;

import modele.*;
import modele.chargement.Stub;
import modele.pokemon.*;

import java.util.HashSet;
import java.util.Set;

//Pour effectuer nos tests
public class Test {


    private static Manager manager = new Stub().charger(); //On effectuera nos tests en passant par le manager

    public static void testAttaque(){
        System.out.println("Test sur l'attaque");
        Mouvement m1 = new Mouvement(10,"flammèche", Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon pAttaque = new Pokemon("Bulbizarre",null,20,10,10,10,null,Type.plante,tabMouvements,3,0,"Herbizarre");
        tabMouvements[0]=m1;
        Pokemon pAttaquant = new Pokemon("Salamèche",null,10,10,10,10,null, Type.feu,tabMouvements,1,90,"Reptincel");

        System.out.println(pAttaquant.getNom() + " : Niveau = " + pAttaquant.getNiveau() + ", Expérience : " + pAttaquant.getExperience());
        System.out.println("Le pokemon " + pAttaquant.getNom() + " attaque "+ pAttaque.getNom() + " avec " + m1.getNom());
        System.out.println("PV de "  + pAttaque.getNom() + " avant attaque = " + pAttaque.getPv());
        manager.attaquerPokemon(pAttaquant,pAttaque,m1);
        System.out.println("PV de "  + pAttaque.getNom() + " après attaque = " + pAttaque.getPv() + "\n");
        System.out.println(pAttaquant.getNom() + " : Niveau = " + pAttaquant.getNiveau() + ", Expérience : " + pAttaquant.getExperience());
    }

    public static void testDeplacer(){
        System.out.println("Test sur le déplacement");
        Position positionInitiale = new Position(0,0);
        Pokemon bulbizarre = new Pokemon("Bulbizarre",null,50,10,10,10,positionInitiale,Type.plante,null,1,0,null);
        System.out.println("Position actuelle de " + bulbizarre.getNom() + " = " + bulbizarre.getPosition());
        manager.setPokemonCourant(bulbizarre);
        //manager.deplacerPokemon("Z");
        System.out.println("Position actuelle de " + bulbizarre.getNom() + " = " + bulbizarre.getPosition() + "\n");
    }

    public static void testCollection(){
        System.out.println("Test de la classe Collection");
        Set<Pokemon> niveau1=new HashSet<>();
        Set<Pokemon> niveau2=new HashSet<>();
        Set<Pokemon> niveau3=new HashSet<>();

        Pokemon p = new Pokemon("Bulbizarre",null,50,10,10,10,null,Type.plante,null,1,0,"Herbizarre");
        niveau1.add(p);
        p = new Pokemon("Salamèche",null,10,10,10,10,null, Type.feu,null,1,0,"Reptincel");
        niveau1.add(p);
        p = new Pokemon("Carapuce",null,10,10,10,10,null, Type.eau,null,1,0,"Carabaffe");
        niveau1.add(p);

        p = new Pokemon("Herbizarre",null,20,20,20,20,null, Type.plante,null,2,0,"Florizarre");
        niveau2.add(p);
        p = new Pokemon("Reptincel",null,20,20,20,20,null, Type.feu,null,2,0,"Dracaufeu");
        niveau2.add(p);
        p = new Pokemon("Carabaffe",null,20,20,20,20,null, Type.eau,null,2,0,"Tortank");
        niveau2.add(p);

        p = new Pokemon("Florizarre",null,30,30,30,30,null, Type.plante,null,3,0,null);
        niveau3.add(p);
        p = new Pokemon("Dracaufeu",null,30,30,30,30,null, Type.feu,null,3,0,null);
        niveau3.add(p);
        p = new Pokemon("Tortank",null,30,30,30,30,null, Type.eau,null,3,0,null);
        niveau3.add(p);

        CollectionPokemon collectionPokemon = new CollectionPokemon(niveau1,niveau2,niveau3);
        System.out.println(collectionPokemon);

        p=collectionPokemon.getPokemon("Tortank",3);
        if(p!=null) {
            System.out.println("Pokemon récupéré : " + p.getNom());
        }
        else{
            System.out.println("Pokemon non trouvé\n");
        }
        p=collectionPokemon.getPokemon(p.getEvolution(),p.getNiveau());
        if(p!=null) {
            System.out.println("Son évolution est : " + p.getNom());
        }
        else{
            System.out.println("Ce pokemon n'a pas d'évolution\n");
        }
    }
}
