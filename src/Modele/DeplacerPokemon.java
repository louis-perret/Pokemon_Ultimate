package Modele;

public class DeplacerPokemon implements Deplaceur{
    public void deplacer(Pokemon p, double x, double y){
        p.getPosition().setPositionX(x);
        p.getPosition().setPositionY(y);

    }
}
