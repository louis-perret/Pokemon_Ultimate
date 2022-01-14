package modele.combat;

import modele.pokemon.CollectionPokemon;
import modele.pokemon.Pokemon;

//Permet de controler le gain d'expérience, le niveau et l'évolution d'un pokemon
public class ControleurNiveau {

    private CollectionPokemon collectionPokemon;

    /**
     * Constructeur
     * @param collectionPokemon
     */
    public ControleurNiveau(CollectionPokemon collectionPokemon) {
        this.collectionPokemon = collectionPokemon;
    }

    /**
     * Augmente l'expérience du pokemon p en fonction du niveau du pokemon ennemi
     * @param p : pokemon qui gagné de l'expérience
     * @param ennemi : le pokemon ennemo
     */
    public void gagnerExperience(Pokemon p, Pokemon ennemi){
        int xpGagne=0;
        int niveauEnnemi=ennemi.getNiveau();

        if(niveauEnnemi==1){
            xpGagne=15;
        }
        else{
            if(niveauEnnemi==2){
                xpGagne=20;
            }
            else{
                xpGagne=25;
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
     * @param p : Pokemon a faire évolué
     * @param experienceRestante : son expérience restante à rajouter après
     */
    public void evoluer(Pokemon p,int experienceRestante){
        Pokemon pEVolue=collectionPokemon.getPokemon(p.getEvolution(),p.getNiveau()+1); //Récupère l'évolution du pokemon
        //Modifie chacun de ses attributs par ceux de son évolution
        p.setNom(pEVolue.getNom());
        p.setNiveau(pEVolue.getNiveau());
        p.setPv(pEVolue.getPv());
        p.setEvolution(pEVolue.getEvolution());
        p.setAttaque(pEVolue.getAttaque());
        p.setDefense(pEVolue.getDefense());
        p.setVitesse(pEVolue.getVitesse());
        p.setImage(pEVolue.getImage());
        p.setMouvements(pEVolue.getMouvements());
        p.setExperience(experienceRestante);
    }
}
