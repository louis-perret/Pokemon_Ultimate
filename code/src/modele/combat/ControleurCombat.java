package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

public abstract class ControleurCombat {

    protected ControleurNiveau controleurNiveau;
    protected Attaqueur attaqueur;

    public boolean effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie, Mouvement mEnnemi){
        return true;
    }
}
