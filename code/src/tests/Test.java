package tests;

import modele.*;
import persistance.Stub;
import modele.pokemon.*;
import modele.pokemon.etat.Inflammé;
import modele.pokemon.etat.Paralysé;
import modele.pokemon.Mouvement;

import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * Effectue le test de nos fonctionnalités sur le combat
 */
public class Test {


    private static Manager manager = new Stub().charger(); //On effectuera nos tests en passant par le manager

    /**
     * Test sur l'entièreté de la fonctionnalité combat avec système de vagues et de victoires
     */
    public static void testAttaque(){
        System.out.println("Test combat");
        int i, ko=0;
        manager.setPokemonCourant(manager.getPokedex().getPokemon("Bulbizarre",1)); //on set le pokemon courant
        Mouvement mouvement;
        System.out.println("Nombre de victoires : " + manager.getNbVictoires());
        while(!manager.lancerVague()){ //on lance les 3 vagues
            System.out.println("Nouvelle vague");
            while(true) { //Effectue une vague
                System.out.println(manager.getPokemonCourant().getNom() + " affrontera " + manager.getPokemonEnnemiCourant().getNom() + ".");
                System.out.println("Techniques de " + manager.getPokemonCourant().getNom() + " : ");
                i = 1;
                for (Mouvement m : manager.getPokemonCourant().getMouvements()) {
                    System.out.print(i + "." + m.getNom() + ", ");
                    i++;
                }
                System.out.println();
                System.out.print("Attaque sélectionnée : ");
                Scanner scanner = new Scanner(System.in);
                i = scanner.nextInt();
                mouvement = manager.getPokemonCourant().getMouvements()[i - 1];
                System.out.println(manager.getPokemonCourant().getNom() + " effectue : " + mouvement.getNom());
                ko = manager.tourDeCombat(manager.getPokemonCourant(), manager.getPokemonEnnemiCourant(), mouvement); //on effectue un tour de combat
                System.out.println("Nombre de pv restant pour " + manager.getPokemonCourant().getNom() + " : " + manager.getPokemonCourant().getPv());
                if(ko==0) { //si le pokemon ennemi n'est pas ko
                    System.out.println("Nombre de pv restant pour " + manager.getPokemonEnnemiCourant().getNom() + " : " + manager.getPokemonEnnemiCourant().getPv());
                    if (manager.getPokemonEnnemiCourant().getEtat() != null) { //si le pokemon ennemi subit un changement de status
                        System.out.println("Etat : " + manager.getPokemonEnnemiCourant().getEtat().getNom()); //on l'affiche pour avertir le joueur
                    }
                }
                else{
                    if(ko==1){ //si le joueur a gagné le combat
                        System.out.println("Vous l'avez battu");
                    }
                    else{ //sinon ça veut dire soit il a perdu, soit il a gagné la vague
                        break;
                    }
                }
            }
            if(ko==2){ //s'il a perdu, on arrête le jeu
                System.out.println("Vous avez perdu le combat. Ressayer");
                break;
            }
            else{ //sinon il a remporté la vague
                System.out.println("Vous avez remporté cette vague, bonne chance pour la prochaine !");
            }
        }
        System.out.println("Nombre de victoires : " + manager.getNbVictoires());
    }

    /**
     * Test l'implémentation des états d'un pokemon
     */
    public static void testEtat(){
        Pokemon p = manager.getPokedex().getPokemon("Bulbizarre",1);
        System.out.println("Ce pokemon est en pleine santé");
        p.setEtat(new Inflammé("inflammé", null));
        System.out.println("Ce pokemon est inflammé et va perde peur à peu de la vie");
        while(p.getPv()>0){ //La vie descend bien correctement (même fonctionnement qu'avec l'empoisonnement)
            p.appliquerEtat(); //on effectue le comportement de son état
            System.out.println("Il lui reste : " + p.getPv() + " PV");
        }

        p.setEtat(new Paralysé("paralysé", null)); //on teste la paralysie qui baisse seulement une fois la vitesse du pokemon
        System.out.println("Ce pokemon est paralysé et va perdre en vitesse");
        System.out.println("Vitesse du pokemon : " + p.getVitesse());
        for(int i=0;i<10;i++){
            p.appliquerEtat();
            System.out.println("Vitesse du pokemon : " + p.getVitesse()); //On voit bien que sa vitesse n'a diminué qu'une seule fois
        }
    }
}
