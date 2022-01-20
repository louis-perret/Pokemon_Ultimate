package chargement;

import chargement.Chargeur;
import modele.pokemon.*;
import modele.Manager;
import modele.monde.Tuile;
import modele.pokemon.Mouvement;
import modele.pokemon.etat.Empoisonné;
import modele.pokemon.etat.Inflammé;
import modele.pokemon.etat.Paralysé;

import java.util.*;

/**
 * Classe simulant un chargement à partir d'un jeu de données
 */
public class Stub extends Chargeur{

    /**
     * Charge un objet Manager à partir d'un jeu de données
     * @return un Manager
     */
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
        Type poison = new Type(NomType.poison,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.psy);
        faiblesses.add(NomType.vol);
        forces = new ArrayList<>();
        forces.add(NomType.normal);
        forces.add(NomType.roche);
        forces.add(NomType.glace);
        Type combat = new Type(NomType.combat,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.feu);
        faiblesses.add(NomType.vol);
        forces = new ArrayList<>();
        forces.add(NomType.psy);
        forces.add(NomType.plante);
        Type insecte = new Type(NomType.insecte,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.insecte);
        faiblesses.add(NomType.ténèbre);
        forces = new ArrayList<>();
        forces.add(NomType.combat);
        forces.add(NomType.poison);
        Type psy = new Type(NomType.insecte,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.combat);
        faiblesses.add(NomType.feu);
        faiblesses.add(NomType.roche);
        faiblesses.add(NomType.sol);
        forces = new ArrayList<>();
        forces.add(NomType.insecte);
        forces.add(NomType.dragon);
        forces.add(NomType.plante);
        forces.add(NomType.vol);
        forces.add(NomType.sol);
        Type glace = new Type(NomType.glace,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.electrique);
        faiblesses.add(NomType.glace);
        faiblesses.add(NomType.roche);
        forces = new ArrayList<>();
        forces.add(NomType.insecte);
        forces.add(NomType.plante);
        Type vol = new Type(NomType.vol,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.ténèbre);
        forces = new ArrayList<>();
        forces.add(NomType.psy);
        Type spectre = new Type(NomType.spectre,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.dragon);
        faiblesses.add(NomType.glace);
        forces = new ArrayList<>();
        forces.add(NomType.dragon);
        Type dragon = new Type(NomType.dragon,forces,faiblesses);

        faiblesses = new ArrayList<>();
        forces = new ArrayList<>();
        Type normal = new Type(NomType.normal,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.sol);
        forces = new ArrayList<>();
        forces.add(NomType.eau);
        forces.add(NomType.vol);
        Type electrique = new Type(NomType.electrique,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.eau);
        faiblesses.add(NomType.plante);
        faiblesses.add(NomType.glace);
        forces = new ArrayList<>();
        forces.add(NomType.electrique);
        forces.add(NomType.roche);
        Type sol = new Type(NomType.sol,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.combat);
        forces = new ArrayList<>();
        forces.add(NomType.spectre);
        Type tenebre = new Type(NomType.ténèbre,forces,faiblesses);

        faiblesses = new ArrayList<>();
        faiblesses.add(NomType.eau);
        faiblesses.add(NomType.plante);
        forces = new ArrayList<>();
        forces.add(NomType.vol);
        forces.add(NomType.glace);
        Type roche = new Type(NomType.roche,forces,faiblesses);

        Position position = new Position(128,128);
        Empoisonné empoisonne = new Empoisonné("Empoisonné","/Status/poison.png");
        Paralysé paralyse = new Paralysé("Paralysé","/Status/paralysie.png");
        Inflammé inflamme = new Inflammé("Inflammé","/Status/brulure.png");

        /* Création des attaques */
        Mouvement flammèche = new Mouvement(10,"Flammèche",feu,null);
        Mouvement foutLiane = new Mouvement(10,"Fouet-liane",plante,null);
        Mouvement pistolet_a_eau = new Mouvement(10,"Pistolet à eau",eau,null);
        Mouvement toxic = new Mouvement(0,"Toxic",poison,empoisonne);
        Mouvement dracosouffle = new Mouvement(15,"Dracosouffle",dragon,null);
        Mouvement eclair = new Mouvement(10,"Eclair",electrique,null);
        Mouvement ouragan = new Mouvement(10,"Ouragan",vol,null);
        Mouvement tomberoche = new Mouvement(12,"Tomberoche",roche,null);
        Mouvement pietisol = new Mouvement(10,"Piétisol",sol,null);
        Mouvement piqure = new Mouvement(9,"Piqûre",insecte,null);
        Mouvement charge = new Mouvement(9,"Charge",normal,null);
        Mouvement sabotage = new Mouvement(11,"Sabotage",tenebre,null);
        Mouvement ombre_portee = new Mouvement(11,"Ombre-portée",spectre,null);
        Mouvement eclat_glace = new Mouvement(10,"Eclat-glace",glace,null);
        Mouvement machpunch = new Mouvement(11,"Mach Punch",combat,null);
        Mouvement vague_psy = new Mouvement(10,"Vague Psy",psy,null);
        Mouvement trempette = new Mouvement(0,"Trempette",normal,null);


        Mouvement lanceFlamme = new Mouvement(20,"Lance-flamme",feu,null);
        Mouvement feuilleMagik = new Mouvement(20,"FeuilleMagik",plante,null);
        Mouvement surf = new Mouvement(20,"Surf",eau,null);
        Mouvement acide = new Mouvement(10,"Acide",poison,empoisonne);
        Mouvement dracogriffe = new Mouvement(25,"Dracogriffe",dragon,null);
        Mouvement rayonChargé = new Mouvement(20,"Rayon chargé",electrique,null);
        Mouvement cru_aile = new Mouvement(20,"Cru_aile",vol,null);
        Mouvement tomberoche2 = new Mouvement(22,"Tomberoche2",roche,null);
        Mouvement magnitude = new Mouvement(20,"Magnitude",sol,null);
        Mouvement survInsecte = new Mouvement(19,"SurvInsecte",insecte,null);
        Mouvement belier = new Mouvement(20,"Bélier",normal,null);
        Mouvement tranche_nuit = new Mouvement(21,"Tranche-Nuit",tenebre,null);
        Mouvement griffOmbre = new Mouvement(21,"Griffe Ombre",spectre,null);
        Mouvement avalanche = new Mouvement(20,"Avalanche",glace,null);
        Mouvement pied_saute = new Mouvement(21,"Pied sauté",combat,null);
        Mouvement choque_psy = new Mouvement(20,"Choque Psy",psy,null);


        Mouvement deflagration = new Mouvement(30,"Déflagration",feu,null);
        Mouvement tempeteVerte = new Mouvement(30,"TempêteVerte",plante,null);
        Mouvement hydrocanon = new Mouvement(30,"Hydrocanon",eau,null);
        Mouvement detricanon = new Mouvement(25,"Détricanon",poison,empoisonne);
        Mouvement draco_meteore = new Mouvement(25,"Draco-Météore",dragon,null);
        Mouvement tonnerre = new Mouvement(30,"Tonerre",electrique,null);
        Mouvement rapace = new Mouvement(30,"Rapace",vol,null);
        Mouvement lame_de_roc = new Mouvement(30,"Lame de Roc",roche,null);
        Mouvement seisme = new Mouvement(30,"Séisme",sol,null);
        Mouvement bourdon = new Mouvement(30,"Bourdon",insecte,null);
        Mouvement giga_impact = new Mouvement(30,"Giga-Impact",normal,null);
        Mouvement coup_bas = new Mouvement(30,"Coup Bas",tenebre,null);
        Mouvement ball_ombre = new Mouvement(30,"Ball'Ombre",spectre,null);
        Mouvement blizzard = new Mouvement(30,"Blizzard",glace,null);
        Mouvement close_combat = new Mouvement(30,"Close combat",combat,null);
        Mouvement psyko = new Mouvement(30,"Psyko",psy,null);


        Mouvement[] tabMouvements=new Mouvement[]{foutLiane,toxic,charge,sabotage};

        Pokemon p = new Pokemon("Bulbizarre","/sprite/Sprite_bulbi/bulb_1.png","/sprite/Sprite_bulbi/bulb_combat_dos.png",2000,30,20,20,position, plante,tabMouvements,1,0,"Herbizarre", true);
        niveau1.add(p);

        tabMouvements=new Mouvement[]{flammèche,charge,ombre_portee,trempette};
        p = new Pokemon("Salamèche","/sprite/Sprite_salam/salam_1.png","/sprite/Sprite_salam/salam_combat_dos.png",2000,350,20,150,position, feu,tabMouvements,1,0,"Reptincel", true);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{pistolet_a_eau,charge,sabotage,machpunch};
        p = new Pokemon("Carapuce","/sprite/Sprite_carap/squi_1.png","/sprite/Sprite_carap/squi_combat_dos.png",70,20,40,10,position, eau,tabMouvements,1,0,"Carabaffe", true);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{piqure,charge,toxic,dracosouffle};
        p= new Pokemon("Chenipan","/sprite/chenipan.png","/sprite/chenipan.png",35,9,9,9,position,insecte,tabMouvements,1,0,"Chrysacier",false);

        niveau1.add(p);
        tabMouvements=new Mouvement[]{charge};
        p= new Pokemon("Ratatta",null,"/sprite/ratata.png",35,10,10,10,position,normal,tabMouvements,1,0,"Ratattac",false);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{machpunch,sabotage};
        p= new Pokemon("Machoc",null,"/sprite/machoc.png",35,11,10,10,position,combat,tabMouvements,1,0,"Machopeur",false);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{vague_psy,ombre_portee};
        p= new Pokemon("Abra",null,"/sprite/abra.png",38,15,9,13,position,psy,tabMouvements,1,0,"Ratattac",false);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{ombre_portee,vague_psy,toxic};
        p= new Pokemon("Fantominus",null,"/sprite/fantominus.png",40,13,9,12,position,spectre,tabMouvements,1,0,"Ratattac",false);
        niveau1.add(p);
        tabMouvements=new Mouvement[]{trempette};
        p= new Pokemon("Magicarp",null,"/sprite/magicarp.png",35,7,15,4,position,eau,tabMouvements,1,0,"Leviathor",false);
        niveau1.add(p);


        tabMouvements=new Mouvement[]{feuilleMagik,acide,belier,tranche_nuit};
        p = new Pokemon("Herbizarre","/sprite/Sprite_herbi/herb_1.png","/sprite/Sprite_herbi/herb_combat_dos.png",400,60,50,20,position, plante,tabMouvements,2,0,"Florizarre", true);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{lanceFlamme,cru_aile,belier,pietisol};
        p = new Pokemon("Reptincel","/sprite/Sprite_rept/rept_1.png","/sprite/Sprite_rept/rept_combat_dos.png",400,450,20,250,position, feu,tabMouvements,2,0,"Dracaufeu", true);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{surf,pied_saute,belier,tomberoche2};
        p = new Pokemon("Carabaffe","/sprite/Sprite_carab/war_1.png","/sprite/Sprite_carab/war_combat_dos.png",110,30,40,20,position, eau,tabMouvements,2,0,"Tortank", true);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{choque_psy};
        p = new Pokemon("Kadabra",null,"/sprite/kadabra.png",68,45,39,43,position, psy,tabMouvements,2,0,"Alakazam", false);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{acide,griffOmbre,sabotage};
        p = new Pokemon("Spectrum",null,"/sprite/spectrum.png",70,43,39,42,position, spectre,tabMouvements,2,0,"Ectoplasma", false);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{survInsecte};
        p = new Pokemon("Chrysacier",null,"/sprite/chrysacier.png",70,10,60,10,position, insecte,tabMouvements,2,0,"Papillusion", false);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{belier,charge};
        p = new Pokemon("Ratatak",null,"/sprite/ratatak.png",65,40,40,40,position, normal,tabMouvements,2,0,null, false);
        niveau2.add(p);
        tabMouvements=new Mouvement[]{pied_saute};
        p = new Pokemon("Machopeur",null,"/sprite/machopeur.png",70,41,40,40,position, combat,tabMouvements,2,0,"Mackogneur", false);
        niveau2.add(p);



        tabMouvements=new Mouvement[]{tempeteVerte,detricanon,giga_impact,seisme};
        p = new Pokemon("Florizarre","/sprite/Sprite_flo/flo_1.png","/sprite/Sprite_flo/flo_combat_dos.png",280,100,80,80,position, plante,tabMouvements,3,0,null, true);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{deflagration,rapace,draco_meteore,tonnerre};
        p = new Pokemon("Dracaufeu","/sprite/Sprite_drac/drac_1.png","/sprite/Sprite_drac/drac_combat_dos.png",2000,1000,30,950,position, feu,tabMouvements,3,0,null, true);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{hydrocanon,close_combat,blizzard,lame_de_roc};
        p = new Pokemon("Tortank","/sprite/Sprite_tort/blas_1.png","/sprite/Sprite_tort/blas_combat_dos.png",200,80,130,80,position, eau,tabMouvements,3,0,null, true);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{psyko,ball_ombre};
        p = new Pokemon("Alakazam",null,"/sprite/alakazam.png",100,80,65,80,position, psy,tabMouvements,3,0,null, false);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{ball_ombre,detricanon,psyko,coup_bas};
        p = new Pokemon("Ectoplasma",null,"/sprite/ectoplasama.png",110,80,70,79,position, spectre,tabMouvements,3,0,null, false);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{hydrocanon,giga_impact};
        p = new Pokemon("Leviathor",null,"/sprite/leviathor.png",110,70,80,70,position, eau,tabMouvements,3,0,null, false);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{close_combat};
        p = new Pokemon("Mackogneur",null,"/sprite/mackogneur.png",120,70,80,60,position, combat,tabMouvements,3,0,null, false);
        niveau3.add(p);
        tabMouvements=new Mouvement[]{bourdon,rapace};
        p = new Pokemon("Papillusion",null,"/sprite/papillusion.png",80,70,60,180,position, insecte,tabMouvements,3,0,null, false);
        niveau3.add(p);

        CollectionPokemon collectionPokemon = new CollectionPokemon(niveau1,niveau2,niveau3);

        Tuile tuileHerbe = new Tuile(0, "tuiles/herbe.png",true,0);
        Tuile tuilePbg = new Tuile(1,"tuiles/portail_bas_gauche.png",true,2);
        Tuile tuilePbd = new Tuile(2,"tuiles/portail_bas_droite.png",true,2);
        Tuile tuilePhg = new Tuile(3,"tuiles/portail_haut_gauche.png",false, 0);
        Tuile tuilePhd = new Tuile(4,"tuiles/portail_haut_droite.png",false, 0);
        Tuile tuileBrique = new Tuile(5,"tuiles/brique.png",false,0);
        Tuile tuileSortie = new Tuile(6,"tuiles/sortie.png",true,1);
        Tuile tuileSolA = new Tuile(7,"tuiles/sol_arene.png",true,3);
        Tuile tuilePanneau = new Tuile(8,"tuiles/panneau.png",false,0);



        Map<Integer,Tuile> dicoTuiles=new HashMap<>();
        dicoTuiles.put(tuileHerbe.getId(),tuileHerbe);
        dicoTuiles.put(tuilePbg.getId(),tuilePbg);
        dicoTuiles.put(tuilePbd.getId(),tuilePbd);
        dicoTuiles.put(tuilePhg.getId(),tuilePhg);
        dicoTuiles.put(tuilePhd.getId(),tuilePhd);
        dicoTuiles.put(tuileBrique.getId(),tuileBrique);
        dicoTuiles.put(tuileSortie.getId(),tuileSortie);
        dicoTuiles.put(tuileSolA.getId(),tuileSolA);
        dicoTuiles.put(tuilePanneau.getId(),tuilePanneau);
        return new Manager(collectionPokemon,dicoTuiles);
    }
}
