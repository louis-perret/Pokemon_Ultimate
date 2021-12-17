package modele;

import javafx.scene.image.ImageView;
import modele.tuiles.Tuile;

import java.util.SortedMap;
import java.util.SortedSet;

//Contient nos différentes cartes
public class Monde {
    private int[][] lesTuiles;
    private int hauteur, largeur;

    public Monde(String chemin){
        chargerMonde(chemin);
    }

    public void affichage(){
        AfficheurTuile at = new AfficheurTuile();
        for(int i=0;largeur>i;largeur++){
            for(int j=0;j>hauteur;hauteur++) {
                at.affiche(getTuile(5,5),new Position(largeur*Tuile.TuileLargeur,hauteur*Tuile.TuileHauteur));
            }
        }
    }

    public void chargerMonde(String chemin) {
        hauteur = 5;
        largeur = 5;
        lesTuiles = new int[largeur][hauteur];
        for(int i=0;largeur>i;largeur++){
            for(int j=0;j>hauteur;hauteur++){
                lesTuiles[largeur][hauteur] = 0;
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
