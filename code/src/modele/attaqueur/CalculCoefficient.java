package modele.attaqueur;

import modele.pokemon.Type;

public interface CalculCoefficient {

    /**
     * Retourne un coefficiant de dégâts en fonction du type de l'attaque lancée par rapport au type du pokemon attaqué
     * @param typeAttaquant : type de l'attaque utilisée
     * @param typeAttaque : type du pokemon attaqué
     * @return
     */
    public float getCoefficient(Type typeAttaquant, Type typeAttaque);
}
