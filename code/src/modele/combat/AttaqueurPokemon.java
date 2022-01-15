package modele.combat;

import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

import static java.lang.Math.ceil;

//Gère l'attaque d'un pokemon vers un autre
public class AttaqueurPokemon implements Attaqueur {

    private CalculCoefficient calculCoefficient= new CalculCoefficientV1();
    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon attaquant
     * @param attaque : pokepon attaqué
     * @param m : l'attaque utilisée
     * @return True si le pokemon attaquant a gagné le combat
     */
    @Override
    public boolean attaquer(Pokemon attaquant, Pokemon attaque, Mouvement m) {
        //calculé en prenant en compte l'attaque de l'attaquant, les dégats de l'attaque, puis le type de l'attaque utilisée ainsi que la défence de l'attaqué
        int degat = (int)ceil((attaquant.getAttaque()/100.0+1)*m.getDegats()*calculCoefficient.getCoefficient(m.getType(),attaque
                .getType())*(1-attaque.getDefense()/100.0));
        attaque.setPv(attaque.getPv()-degat);
        if(attaque.getPv()<=0){ //Si l'adversaire est ko
            return true;
        }
        return false;
    }
}
