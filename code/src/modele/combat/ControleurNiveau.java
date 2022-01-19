package modele.combat;

import modele.pokemon.CollectionPokemon;
import modele.pokemon.Pokemon;

/**
 * Permet de controler le gain d'expérience, le niveau et l'évolution d'un pokemon
 */
public class ControleurNiveau {

    private CollectionPokemon collectionPokemon; //la collection de tous les pokemon

    /**
     * Constructeur
     * @param collectionPokemon : collection de tous les pokmon
     */
    public ControleurNiveau(CollectionPokemon collectionPokemon) {
        this.collectionPokemon = collectionPokemon;
    }

    /**
     * Augmente l'expérience du pokemon p en fonction du niveau du pokemon ennemi
     * @param p : pokemon qui gagne de l'expérience
     * @param ennemi : le pokemon ennemi
     */
    public void gagnerExperience(Pokemon p, Pokemon ennemi){
        int xpGagne=0;
        int niveauEnnemi=ennemi.getNiveau();

        if(niveauEnnemi==1){
            xpGagne=30;
        }
        else{
            if(niveauEnnemi==2){
                xpGagne=40;
            }
            else{
                xpGagne=50;
            }
        }

        p.setExperience(p.getExperience()+xpGagne);
        if(p.getExperience()>=100){ //S'il a atteint son expérience maximum
            if(p.getNiveau()<3) { //S'il est pas au niveau maximum
                xpGagne = p.getExperience() % 100;
                evoluer(p, xpGagne); //On le fait évoluer
            }
            else{
                p.setExperience(100); //Sinon on plafonne son expérience au maximum
            }
        }
    }

    /**
     * Faire évoluer un pokemon
     * @param p : Pokemon a faire évoluer
     * @param experienceRestante : son expérience restante à rajouter après
     */
    public void evoluer(Pokemon p,int experienceRestante){
        Pokemon pEvolue=collectionPokemon.getPokemon(p.getEvolution(),p.getNiveau()+1); //Récupère l'évolution du pokemon
        //Modifie chacun de ses attributs par ceux de son évolution
        p.setNom(pEvolue.getNom());
        p.setNiveau(pEvolue.getNiveau());
        p.setPv(pEvolue.getPv());
        p.setEvolution(pEvolue.getEvolution());
        p.setAttaque(pEvolue.getAttaque());
        p.setDefense(pEvolue.getDefense());
        p.setVitesse(pEvolue.getVitesse());
        p.setImage(pEvolue.getImage());
        p.setImageCombat(pEvolue.getImageCombat());
        p.setMouvements(pEvolue.getMouvements());
        p.setExperience(experienceRestante);
    }
}
