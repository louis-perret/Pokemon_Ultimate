package modele.chargement;

import javafx.scene.image.Image;
import modele.pokemon.CollectionPokemon;
import modele.Manager;
import modele.pokemon.Pokemon;
import modele.pokemon.Type;
import modele.monde.Tuile;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Stub implements Chargeur{

    public void ChargeImages() {
        URL url = getClass().getResource("tuiles/Herbe.png");
        Image Herbe = new Image(url.toExternalForm());
        URL urlPbg = getClass().getResource("tuiles/portail_bas_gauche.png");
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

        Tuile tuileHerbe = new Tuile(0, "tuiles/herbe.png",true);
        Tuile tuilePbg = new Tuile(1,"tuiles/portail_bas_gauche.png",false);
        Tuile tuilePbd = new Tuile(2,"tuiles/portail_bas_droite.png",false);
        Tuile tuilePhg = new Tuile(3,"tuiles/portail_haut_gauche.png",false);
        Tuile tuilePhd = new Tuile(4,"tuiles/portail_haut_droite.png",false);
        Tuile tuileBrique = new Tuile(5,"tuiles/brique.png",true);

        Map<Integer,Tuile> dicoTuiles=new HashMap<>();
        dicoTuiles.put(tuileHerbe.getId(),tuileHerbe);
        dicoTuiles.put(tuilePbg.getId(),tuilePbg);
        dicoTuiles.put(tuilePbd.getId(),tuilePbd);
        dicoTuiles.put(tuilePhg.getId(),tuilePhg);
        dicoTuiles.put(tuilePhd.getId(),tuilePhd);
        dicoTuiles.put(tuileBrique.getId(),tuileBrique);
        return new Manager(collectionPokemon,dicoTuiles);
    }
}
