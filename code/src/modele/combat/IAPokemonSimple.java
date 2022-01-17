package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

import java.util.Random;

public class IAPokemonSimple implements IAPokemon{


    @Override
    public Mouvement choisirAttaque(Pokemon p) {
        Random random = new Random();
        return p.getMouvements()[random.nextInt(p.getMouvements().length)];
    }
}
