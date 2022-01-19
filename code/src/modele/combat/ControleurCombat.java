package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

/**
 * Interface fonctionnelle gérant le control d'un combat
 */
public abstract class ControleurCombat {

    protected IAPokemon iaPokemon; //ia du pokemon ennemi
    protected ControleurNiveau controleurNiveau; //pour contrôler le gain d'expérience et la montée d'un niveau
    protected Attaqueur attaqueur; //pour contrôler l'attaquer

    /**
     * Effectue un tour de combat
     * @param allie : pokemon du joueur
     * @param ennemi : pokemon ennemi
     * @param mAllie : attaque utilisée par le joueur
     * @return un int signifiant s'il y a eu un pokemon ko
     */
    public int effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie){
        return 0;
    }
}
