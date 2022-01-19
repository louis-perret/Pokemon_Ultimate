package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

import java.util.Random;

/**
 * Classe gérant une sélection simple de l'attaque d'un pokemon
 */
public class IAPokemonSimple implements IAPokemon{


    /**
     * Choisie simplement l'attaque du pokemon ennemi
     * @param p : pokemon à qui choisir l'attaque
     * @return un objet Mouvement -> l'attaque choisie
     */
    @Override
    public Mouvement choisirAttaque(Pokemon p) {
        Random random = new Random(); //sélection via l'aléatoire
        return p.getMouvements()[random.nextInt(p.getMouvements().length)];
    }
}
