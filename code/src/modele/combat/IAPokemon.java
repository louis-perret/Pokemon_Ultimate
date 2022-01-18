package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

public interface IAPokemon {

    public Mouvement choisirAttaque(Pokemon p);
}
