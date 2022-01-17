package tests;

import modele.*;
import modele.chargement.Stub;
import modele.pokemon.*;

import java.util.List;
import java.util.Scanner;

//Pour effectuer nos tests
public class Test {


    private static Manager manager = new Stub().charger(); //On effectuera nos tests en passant par le manager

    public static void testAttaque(){
        System.out.println("Test combat");

        int i, ko=0;
        Pokemon allie = manager.getPokedex().getPokemon("Bulbizarre",1).cloner();
        Pokemon ennemi = manager.getPokedex().getPokemon("Carapuce",1);
        Mouvement mouvement;

        System.out.println(allie.getNom() + " affrontera " + ennemi.getNom() + ".");
        while(ko==0){
            System.out.println("Techniques de bulbizarre : ");
            i=1;
            for (Mouvement m : allie.getMouvements()) {
                System.out.print(i + "." + m.getNom() + ", ");
            }
            System.out.println();
            System.out.print("Attaque sélectionnée : ");
            Scanner scanner = new Scanner(System.in);
            i=scanner.nextInt();
            mouvement = allie.getMouvements()[i-1];
            System.out.println("Bulbizarre effectue : " + mouvement.getNom());
            ko=manager.tourDeCombat(allie,ennemi,mouvement);
            System.out.println("Nombre de pv restant pour " + allie.getNom() + " : " + allie.getPv());
            System.out.println("Nombre de pv restant pour " + ennemi.getNom() + " : " + ennemi.getPv());
        }

        if(ko==2){
            System.out.println("Vous avez perdu le combat. Ressayer");
        }
        else{
            System.out.println("Vous avez gagné le combat. Bien joué");
            Pokemon p = manager.getPokedex().getPokemon("Bulbizarre",1);
            System.out.println(p.getNom() + " PV : " + p.getPv() + ", Expérience : " + p.getExperience());
        }

        System.out.println(allie.getNom() + " est de niveau : " + allie.getNiveau() + " avec " + allie.getExperience() + " d'expériences");
        System.out.println(ennemi.getNom() + " est de niveau : " + ennemi.getNiveau() + " avec " + ennemi.getExperience() + " d'expériences");
    }

    public static void testVague(){
        manager.setPokemonCourant(manager.getPokedex().getPokemon("Bulbizarre",1));
        List<Pokemon> listePokemon = manager.lancerVague();
        for(Pokemon p : listePokemon){
            System.out.print(p.getNom() + ", ");
        }
    }
    public static void testDeplacer(){
        /*System.out.println("Test sur le déplacement");
        Position positionInitiale = new Position(0,0);
        Pokemon bulbizarre = new Pokemon("Bulbizarre",null,50,10,10,10,positionInitiale, NomType.plante,null,1,0,null);
        System.out.println("Position actuelle de " + bulbizarre.getNom() + " = " + bulbizarre.getPosition());
        manager.setPokemonCourant(bulbizarre);
        //manager.deplacerPokemon("Z");
        System.out.println("Position actuelle de " + bulbizarre.getNom() + " = " + bulbizarre.getPosition() + "\n");*/
    }

    public static void testCollection(){
        /*System.out.println("Test de la classe Collection");
        Set<Pokemon> niveau1=new HashSet<>();
        Set<Pokemon> niveau2=new HashSet<>();
        Set<Pokemon> niveau3=new HashSet<>();

        Pokemon p = new Pokemon("Bulbizarre",null,50,10,10,10,null, NomType.plante,null,1,0,"Herbizarre");
        niveau1.add(p);
        p = new Pokemon("Salamèche",null,10,10,10,10,null, NomType.feu,null,1,0,"Reptincel");
        niveau1.add(p);
        p = new Pokemon("Carapuce",null,10,10,10,10,null, NomType.eau,null,1,0,"Carabaffe");
        niveau1.add(p);

        p = new Pokemon("Herbizarre",null,20,20,20,20,null, NomType.plante,null,2,0,"Florizarre");
        niveau2.add(p);
        p = new Pokemon("Reptincel",null,20,20,20,20,null, NomType.feu,null,2,0,"Dracaufeu");
        niveau2.add(p);
        p = new Pokemon("Carabaffe",null,20,20,20,20,null, NomType.eau,null,2,0,"Tortank");
        niveau2.add(p);

        p = new Pokemon("Florizarre",null,30,30,30,30,null, NomType.plante,null,3,0,null);
        niveau3.add(p);
        p = new Pokemon("Dracaufeu",null,30,30,30,30,null, NomType.feu,null,3,0,null);
        niveau3.add(p);
        p = new Pokemon("Tortank",null,30,30,30,30,null, NomType.eau,null,3,0,null);
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
        }*/
    }
}
