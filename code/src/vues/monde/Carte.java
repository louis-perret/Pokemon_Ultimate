package vues.monde;

import javafx.scene.Group;
import modele.LectureMonde;
import modele.Position;
import modele.chargement.Stub;
import modele.tuiles.Tuile;
import vues.afficheur.AfficheurTuile;

import java.util.Dictionary;

public class Carte {

    private int[][] lesTuiles;
    private Dictionary<Integer,Tuile> dicoTuiles;
    private int hauteur, largeur, spawnX, spawnY;
    public static Tuile[] lesTuiless = new Tuile[30];
    public static Tuile tuileHerbe = new Tuile(0, Stub.Herbe,true);
    public static Tuile tuilePbg = new Tuile(1,Stub.Portail_bas_gauche,false);
    public static Tuile tuilePbd = new Tuile(2,Stub.Portail_bas_droite,false);
    public static Tuile tuilePhg = new Tuile(3,Stub.Portail_haut_gauche,false);
    public static Tuile tuilePhd = new Tuile(4,Stub.Portail_haut_droite,false);
    public static Tuile tuileBrique = new Tuile(5,Stub.Brique,false);



    public Carte(String chemin){
        chargerCarte(chemin);
    }
/*
    public Group affichage(){
        AfficheurTuile at = new AfficheurTuile();
        for(int i=0;largeur>i;i++){
            for(int j=0;j<hauteur;j++) {
                //at.affiche(getTuile(i,j),new Position(largeur*Tuile.TuileLargeur,hauteur*Tuile.TuileHauteur));
                racine.getChildren().addAll(at.affiche(getTuile(i,j),new Position(i* Tuile.TuileLargeur,
                        j*Tuile.TuileHauteur)));

            }
        }
        return racine;
    }

 */

    public void chargerCarte(String chemin) {

        String fichier = LectureMonde.ChargerFichier(chemin);
        String[] partie = fichier.split("\\s+");
        largeur = LectureMonde.parseInt(partie[0]);
        hauteur = LectureMonde.parseInt(partie[1]);
        spawnX = LectureMonde.parseInt(partie[2]);
        spawnY = LectureMonde.parseInt(partie[3]);

        lesTuiles = new int[largeur][hauteur];
        for(int i=0;largeur>i;i++){
            for(int j=0;j<hauteur;j++) {
                lesTuiles[i][j] = LectureMonde.parseInt(partie[(i + j  * largeur) + 4]);
            }
        }


    }

    public Tuile getTuile(int largeur, int hauteur) {
        Tuile t = Tuile.lesTuiles[lesTuiles[largeur][hauteur]];
        if(t==null) {
            return Tuile.tuileHerbe;
        }
        return t;
    }

    public int[][] getLesTuiles() {
        return lesTuiles;
    }

    public void setLesTuiles(int[][] lesTuiles) {
        this.lesTuiles = lesTuiles;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }


}
