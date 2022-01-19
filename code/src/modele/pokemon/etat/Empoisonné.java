package modele.pokemon.etat;

import modele.pokemon.Pokemon;

import java.io.Serializable;

import static java.lang.Math.ceil;

/**
 * Classe qui définit le statut empoisonné d'un pokemon
 */
public class Empoisonné extends Etat implements Serializable {

    private transient static float coefficient=1/4F; //Dégâts de l'empoisenement

    /**
     * Constructeur
     * @param nom : son nom
     * @param image : chemin vers son image
     */
    public Empoisonné(String nom, String image){
        this.nom=nom;
        this.image=image;
    }

    /**
     * Comportement associé à l'état, ici réduit les pv de 1/4 à chaque de combat
     * @param p : Pokemon sur lequel sera appliqué ce comportement
     */
    @Override
    public void comportement(Pokemon p){
        p.setPv((int) (p.getPv()-ceil(p.getPv()*coefficient)));
    }
}
