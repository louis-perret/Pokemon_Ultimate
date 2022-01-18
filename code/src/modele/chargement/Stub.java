package modele.chargement;

import modele.pokemon.*;
import modele.Manager;
import modele.monde.Tuile;
import modele.pokemon.Mouvement;
import modele.pokemon.etat.Empoisonné;
import modele.pokemon.etat.Inflammé;
import modele.pokemon.etat.Paralysé;

import java.util.*;

public class Stub implements Chargeur{

    @Override
    public Manager charger() {
        List<Pokemon> niveau1=new ArrayList<>();
        List<Pokemon> niveau2=new ArrayList<>();
        List<Pokemon> niveau3=new ArrayList<>();

        /* Création des types */
        List<NomType> faiblesses = new ArrayList<>();
        List<NomType> forces = new ArrayList<>();

        faiblesses.add(NomType.feu);
        faiblesses.add(NomType.glace);
        faiblesses.add(NomType.insecte);
        faiblesses.add(NomType.poison);
        faiblesses.add(NomType.vol);
        forces.add(NomType.eau);
        forces.add(NomType.sol);
        forces.add(NomType.roche);
        Type plante = new Type(NomType.plante,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.eau);
        faiblesses.add(NomType.sol);
        faiblesses.add(NomType.roche);
        forces = new ArrayList<>();
        forces.add(NomType.glace);
        forces.add(NomType.plante);
        forces.add(NomType.insecte);
        Type feu = new Type(NomType.feu,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.plante);
        faiblesses.add(NomType.electrique);
        forces = new ArrayList<>();
        forces.add(NomType.feu);
        forces.add(NomType.sol);
        forces.add(NomType.roche);
        Type eau = new Type(NomType.eau,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.psy);
        faiblesses.add(NomType.sol);
        forces = new ArrayList<>();
        forces.add(NomType.plante);
        Type poison = new Type(NomType.eau,forces,faiblesses);

        Position position = new Position(0,0);

        /* Création des attaques */
        Mouvement flammèche = new Mouvement(10,"Flammèche",feu,null);
        Mouvement foutLiane = new Mouvement(10,"Fouet-liane",plante,null);
        Mouvement pistolet_a_eau = new Mouvement(10,"Pistolet à eau",eau,null);
        Mouvement toxic = new Mouvement(0,"Toxic",eau,new Paralysé("paralysé",null));
        Mouvement[] tabMouvements=new Mouvement[]{foutLiane,toxic};

        Pokemon p = new Pokemon("Bulbizarre","/sprite/Sprite_bulbi/bulb_1.png",50,10,30,10,position, plante,tabMouvements,1,0,"Herbizarre", true);
        niveau1.add(p);

        tabMouvements=new Mouvement[]{flammèche};
        p = new Pokemon("Salamèche","/sprite/Sprite_salam/salam_1.png",50,15,10,10,position, feu,tabMouvements,1,0,"Reptincel", true);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{pistolet_a_eau};
        p = new Pokemon("Carapuce","/sprite/Sprite_carap/squi_1.png",50,10,10,15,position, eau,tabMouvements,1,0,"Carabaffe", true);
        niveau1.add(p);
        p= new Pokemon("Chenipan",null,10,10,10,10,null,null,null,1,0,"Chrysacier",false);
        niveau1.add(p);
        p= new Pokemon("Ratatta",null,10,10,10,10,null,null,null,1,0,"Ratattac",false);
        niveau1.add(p);
        p = new Pokemon("Herbizarre","/sprite/Sprite_herbi/herb_1.png",100,20,20,20,position, plante,null,2,0,"Florizarre", true);
        niveau2.add(p);
        p = new Pokemon("Reptincel","/sprite/Sprite_rept/rept_1.png",100,20,20,20,position, feu,null,2,0,"Dracaufeu", true);
        niveau2.add(p);
        p = new Pokemon("Carabaffe","/sprite/Sprite_carab/war_1.png",100,20,20,20,position, eau,null,2,0,"Tortank", true);
        niveau2.add(p);

        p = new Pokemon("Florizarre","/sprite/Sprite_flo/flo_1.png",200,30,30,30,position, plante,null,3,0,null, true);
        niveau3.add(p);
        p = new Pokemon("Dracaufeu","/sprite/Sprite_drac/drac_1.png",200,30,30,30,position, feu,null,3,0,null, true);
        niveau3.add(p);
        p = new Pokemon("Tortank","/sprite/Sprite_tort/blas_1.png",200,30,30,30,position, eau,tabMouvements,3,0,null, true);
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
