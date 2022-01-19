package modele.deplaceur;

import modele.monde.Carte;
import modele.pokemon.Position;

import static java.lang.Math.abs;

public class ChangeurCarteV1 implements ChangeurCarte {


    private int hauteurFenetre;
    private int largeurFenetre;
    private int hauteurTuile; //Taille du pas

    public ChangeurCarteV1() {
        setHauteurFenetre(640);
        setLargeurFenetre(640);
        setHauteurTuile(32);
    }

    @Override
    public int isChangement(Position positionActuel, Carte carte) {
        int X = (int) positionActuel.getPositionX();
        int Y = (int) positionActuel.getPositionY();

        //Le y sur la fenêtre commence à 0 au milieu de la fenêtre, il fallait gérer cette partie
        int posTuilX = X / getHauteurTuile(), posTuilY = Y;
        if (posTuilY < 0) { //Si c'est négatif
            posTuilY = (abs(getHauteurFenetre() - getHauteurTuile()) + posTuilY) / getHauteurTuile(); //On fait partir le y du début du tableau
        } else { //Si c'est positif
            posTuilY = (carte.getHauteur() / 2) + (posTuilY / getHauteurTuile()); //on fait partir le y du milieu du tableau
        }
        return carte.getTuile(posTuilX, posTuilY).getEvenement(); //Renvoie true s'il y a collision    }
    }

    public int getHauteurFenetre() {
        return hauteurFenetre;
    }

    public void setHauteurFenetre(int hauteurFenetre) {
        this.hauteurFenetre = hauteurFenetre;
    }

    public int getLargeurFenetre() {
        return largeurFenetre;
    }

    public void setLargeurFenetre(int largeurFenetre) {
        this.largeurFenetre = largeurFenetre;
    }

    public int getHauteurTuile() {
        return hauteurTuile;
    }

    public void setHauteurTuile(int hauteurTuile) {
        this.hauteurTuile = hauteurTuile;
    }
}
