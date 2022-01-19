package tests;

import chargement.*;
import modele.Manager;
import modele.pokemon.CollectionPokemon;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;
import modele.pokemon.Type;

public class TestPersistance {

    private static Manager manager = new Stub().charger(); //On effectuera nos tests en passant par le manager

    public static void testSauvegarde(){
        String cheminFichier = "Ressources/source/source.bin";
        Sauveur sauveur = new SauveurBinaire(cheminFichier);
        sauveur.sauver(manager);
    }

    public static void testChargement(){
        String cheminFichier = "Ressources/source/source.bin";
        Chargeur chargeur = new ChargeurBinaire(cheminFichier);
        Manager p = chargeur.charger();
        if(p != null){
            System.out.println("Chargement correcte.");
        }
        /*System.out.println("Chargement effectué. Nom : " + type.getNom());
            System.out.print("faiblesses : ");
            for(NomType n : type.getFaiblesses()){
                System.out.print(n + ", ");
            }
            System.out.print("forces : ");
            for(NomType n : type.getForces()){
                System.out.print(n + ", ");
            }*/
    }
}
