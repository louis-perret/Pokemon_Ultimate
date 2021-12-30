package vues.monde;

import javafx.scene.Group;
import modele.LectureMonde;
import modele.Position;
import modele.tuiles.Tuile;
import vues.afficheur.AfficheurTuile;

//Contient nos différentes cartes
public class Monde {
    private Group racine = new Group();
    private int[][] lesTuiles;
    private int hauteur, largeur, spawnX, spawnY;

    public Monde(String chemin){
        chargerMonde(chemin);
    }

    public Group affichage(){
        AfficheurTuile at = new AfficheurTuile();
        for(int i=0;largeur>i;i++){
            for(int j=0;j<hauteur;j++) {
                //at.affiche(getTuile(i,j),new Position(largeur*Tuile.TuileLargeur,hauteur*Tuile.TuileHauteur));
                racine.getChildren().addAll(at.affiche(getTuile(i,j),new Position(i*Tuile.TuileLargeur,
                        j*Tuile.TuileHauteur)));

            }
        }
        return racine;
    }

    public void chargerMonde(String chemin) {
        /*
        hauteur = 20;
        largeur = 30;
        lesTuiles = new int[largeur][hauteur];
        for(int i=0;largeur>i;i++){
            for(int j=0;j<hauteur;j++) {
                lesTuiles[i][j] = 0;
            }
        }

         */
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
}
