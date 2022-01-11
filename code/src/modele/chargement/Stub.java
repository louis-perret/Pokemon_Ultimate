package modele.chargement;

import modele.pokemon.*;
import modele.Manager;
import modele.monde.Tuile;

import java.util.*;

public class Stub implements Chargeur{

    @Override
    public Manager charger() {
        Set<Pokemon> niveau1=new HashSet<>();
        Set<Pokemon> niveau2=new HashSet<>();
        Set<Pokemon> niveau3=new HashSet<>();

        /* Création des types */
        List<NomType> faiblessesPlante = new ArrayList<>();
        faiblessesPlante.add(NomType.feu);
        faiblessesPlante.add(NomType.glace);
        faiblessesPlante.add(NomType.insecte);
        faiblessesPlante.add(NomType.poison);
        faiblessesPlante.add(NomType.vol);

        List<NomType> forcesPlante = new ArrayList<>();
        forcesPlante.add(NomType.eau);
        forcesPlante.add(NomType.sol);
        forcesPlante.add(NomType.roche);

        Type plante = new Type(NomType.plante,forcesPlante,faiblessesPlante);

        List<NomType> faiblessesFeu = new ArrayList<>();
        faiblessesFeu.add(NomType.eau);
        faiblessesFeu.add(NomType.sol);
        faiblessesFeu.add(NomType.roche);

        List<NomType> forcesFeu = new ArrayList<>();
        forcesFeu.add(NomType.glace);
        forcesFeu.add(NomType.plante);
        forcesFeu.add(NomType.insecte);

        Type feu = new Type(NomType.feu,forcesFeu,faiblessesFeu);

        Type eau = new Type(NomType.eau,forcesFeu,faiblessesFeu);

        /* Création des attaques */
        Mouvement flammèche = new Mouvement(10,"Flammèche",feu);
        Mouvement foutLiane = new Mouvement(10,"Fouet-liane",plante);
        Mouvement[] tabMouvements=new Mouvement[]{foutLiane};
        Pokemon p = new Pokemon("Bulbizarre",null,50,10,10,10,null, plante,tabMouvements,1,0,"Herbizarre");
        niveau1.add(p);

        tabMouvements=new Mouvement[]{flammèche};
        p = new Pokemon("Salamèche",null,10,10,10,10,null, feu,tabMouvements,1,0,"Reptincel");
        niveau1.add(p);
        p = new Pokemon("Carapuce",null,10,10,10,10,null, eau,null,1,0,"Carabaffe");
        niveau1.add(p);

        p = new Pokemon("Herbizarre",null,20,20,20,20,null, plante,null,2,0,"Florizarre");
        niveau2.add(p);
        p = new Pokemon("Reptincel",null,20,20,20,20,null, feu,null,2,0,"Dracaufeu");
        niveau2.add(p);
        p = new Pokemon("Carabaffe",null,20,20,20,20,null, eau,null,2,0,"Tortank");
        niveau2.add(p);

        p = new Pokemon("Florizarre",null,30,30,30,30,null, plante,null,3,0,null);
        niveau3.add(p);
        p = new Pokemon("Dracaufeu",null,30,30,30,30,null, feu,null,3,0,null);
        niveau3.add(p);
        p = new Pokemon("Tortank",null,30,30,30,30,null, eau,null,3,0,null);
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
