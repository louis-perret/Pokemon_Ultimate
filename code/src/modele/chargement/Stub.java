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

        Position position = new Position(0,0);

        /* Création des attaques */
        Mouvement flammèche = new Mouvement(10,"Flammèche",feu);
        Mouvement foutLiane = new Mouvement(10,"Fouet-liane",plante);
        Mouvement[] tabMouvements=new Mouvement[]{foutLiane};

        Pokemon p = new Pokemon("Bulbizarre","/sprite/Sprite_bulbi/bulb_1.png",50,10,10,10,position, plante,tabMouvements,1,0,"Herbizarre", true);
        niveau1.add(p);

        tabMouvements=new Mouvement[]{flammèche};
        p = new Pokemon("Salamèche","/sprite/Sprite_salam/salam_1.png",10,10,10,10,position, feu,tabMouvements,1,0,"Reptincel", true);
        niveau1.add(p);
        p = new Pokemon("Carapuce","/sprite/Sprite_carap/squi_1.png",10,10,10,10,position, eau,null,1,0,"Carabaffe", true);
        niveau1.add(p);

        p = new Pokemon("Herbizarre","/sprite/Sprite_herbi/herb_1.png",20,20,20,20,position, plante,null,2,0,"Florizarre", true);
        niveau2.add(p);
        p = new Pokemon("Reptincel","/sprite/Sprite_rept/rept_1.png",20,20,20,20,position, feu,null,2,0,"Dracaufeu", true);
        niveau2.add(p);
        p = new Pokemon("Carabaffe","/sprite/Sprite_carab/war_1.png",20,20,20,20,position, eau,null,2,0,"Tortank", true);
        niveau2.add(p);

        p = new Pokemon("Florizarre","/sprite/Sprite_flo/flo_1.png",30,30,30,30,position, plante,null,3,0,null, true);
        niveau3.add(p);
        p = new Pokemon("Dracaufeu","/sprite/Sprite_drac/drac_1.png",30,30,30,30,position, feu,null,3,0,null, true);
        niveau3.add(p);
        p = new Pokemon("Tortank","/sprite/Sprite_tort/blas_1.png",30,30,30,30,position, eau,null,3,0,null, true);
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
