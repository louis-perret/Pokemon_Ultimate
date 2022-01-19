package modele.combat;

import modele.pokemon.Type;

/**
 * Gère le calcul des coefficients entre les types
 */
public class CalculCoefficientV1 implements CalculCoefficient{

    /**
     * Retourne un coefficiant de dégâts en fonction du type de l'attaque lancée par rapport au type du pokemon attaqué
     * @param typeAttaquant : type de l'attaque utilisée
     * @param typeAttaque : type du pokemon attaqué
     * @return un int
     */
    @Override
    public float getCoefficient(Type typeAttaquant, Type typeAttaque) {
        if(typeAttaquant.getForces().contains(typeAttaque.getNom())){ //Si le pokemon à un avantage de type
            return 1.50F; //on augmente les dégats de 50%
        }
        if(typeAttaquant.getFaiblesses().contains(typeAttaque.getNom())){  //Si le pokemon à un désavantage de type
            return 0.50F; //on diminue les dégâts de 50%
        }
        return 1F; //S'il est neutre, on ne fait rien
    }
}
