package modele.pokemon.etat;

import modele.pokemon.Pokemon;

import static java.lang.Math.ceil;

public class Inflammé extends Etat{

    private static float coefficient=1/8F; //Dégâts de l'inflammation

    /**
     * Constructeur
     * @param nom : son nom
     * @param image : chemin vers son image
     */
    public Inflammé(String nom, String image){
        this.nom=nom;
        this.image=image;
    }

    /**
     * Comportement associé à l'état, ici réduit les pv de 1/8 à chaque tour de combat
     * @param p : Pokemon sur lequel sera appliqué ce comportement
     */
    @Override
    public void comportement(Pokemon p) {
        p.setPv((int) (p.getPv()-ceil(p.getPv()*coefficient)));
    }
}
