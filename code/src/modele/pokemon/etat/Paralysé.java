package modele.pokemon.etat;

import modele.pokemon.Pokemon;

public class Paralysé extends Etat{

    private boolean vitesseReduit=false; //permet de savoir si l'effet a déjà été appliqué

    /**
     * Constructeur
     * @param nom : son nom
     * @param image : chemin vers son image
     */
    public Paralysé(String nom,String image){
        this.nom=nom;
        this.image=image;
    }

    /**
     * Comportement associé à l'état
     * @param p : Pokemon sur lequel sera appliqué ce comportement
     */
    @Override
    public void comportement(Pokemon p) {
        if(!vitesseReduit){ //On réduit la vitesse de moitié qu'une seule fois
            vitesseReduit=true; //Pour dire qu'on a appliqué le comportement
            p.setVitesse(p.getVitesse()/2);
        }
    }
}
