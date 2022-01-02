package modele.chargement;

import javafx.scene.image.Image;
import modele.CollectionPokemon;
import modele.Manager;
import modele.Pokemon;
import modele.Type;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Stub implements Chargeur{

    //public static Image Herbe;
    //public static Image Portail_bas_gauche;
    public static Image Herbe = new Image("Tuiles/herbe.png");
    public static Image Portail_bas_gauche = new Image("Tuiles/portail_bas_gauche.png");
    public static Image Portail_haut_gauche = new Image("Tuiles/portail_haut_gauche.png");
    public static Image Portail_bas_droite = new Image("Tuiles/portail_bas_droite.png");
    public static Image Portail_haut_droite = new Image("Tuiles/portail_haut_droite.png");
    public static Image Brique = new Image("Tuiles/brique.png");


    public void ChargeImages() {
        URL url = getClass().getResource("Tuiles/Herbe.png");
        Image Herbe = new Image(url.toExternalForm());
        URL urlPbg = getClass().getResource("Tuiles/portail_bas_gauche.png");
        Image Portail_bas_gauche = new Image(urlPbg.toExternalForm());
    }

    @Override
    public Manager charger() {
        Set<Pokemon> niveau1=new HashSet<>();
        Set<Pokemon> niveau2=new HashSet<>();
        Set<Pokemon> niveau3=new HashSet<>();

        Pokemon p = new Pokemon("Bulbizarre",null,50,10,10,10,null, Type.plante,null,1,0,"Herbizarre");
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
        return new Manager(collectionPokemon,"Ressources/Monde.txt");
    }
}
