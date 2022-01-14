package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

//Interface pour nos attaqueurs
public interface Attaqueur {

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon attaquant
     * @param attaque : pokepon attaqué
     * @param m : l'attaque utilisée
     * @return True si le pokemon attaquant a gagné le combat
     */
    public boolean attaquer(Pokemon attaquant, Pokemon attaque, Mouvement m);
}
