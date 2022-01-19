package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

/**
 * Interface fonctionnelle pour gérer la sélection de l'attaque d'un pokemon
 */
public interface IAPokemon {

    /**
     * Choisie l'attaque du pokemon ennemi
     * @param p : pokemon à qui choisir l'attaque
     * @return un objet Mouvement -> l'attaque choisie
     */
    public Mouvement choisirAttaque(Pokemon p);
}
