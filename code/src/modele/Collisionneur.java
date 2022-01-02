package modele;

import modele.tuiles.Tuile;
import vues.monde.Monde;

import static java.lang.Math.abs;

//Gère les collisions
public class Collisionneur {

    private double hauteurFenetre=256;
    private double largeurFenetre=320;

    public boolean isCollision(Position currentPosition, Position nextPosition, Monde monde){
        int nextX = (int)nextPosition.getPositionX();
        int nextY = (int)abs(nextPosition.getPositionY());
        if(nextX < 0 ) { return true; } //Pour passer outre la bordure de gauche
        if(nextY >= hauteurFenetre || nextX>=largeurFenetre) { //Pour pas dépasser les autres bordures
            return true;
        }
        Tuile t = monde.getTuile(nextX/32,nextY/32);
        boolean b = monde.getTuile(nextX/32,nextY/32).getTraversable();
        System.out.println(b + "," + t.getId());
        return !b;
    }
}
