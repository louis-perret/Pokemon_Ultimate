package modele;

//Gère l'attaque d'un pokemon vers un autre
public class AttaqueurPokemon implements Attaqueur{

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon attaquant
     * @param attaque : pokepon attaqué
     * @param m : l'attaque utilisée
     * @return True si le pokemon attaquant a gagné le combat
     */
    @Override
    public boolean attaquer(Pokemon attaquant, Pokemon attaque,Mouvement m) {
        int degat = attaquant.getAttaque()+m.getDegats();
        attaque.setPv(attaque.getPv()-degat);
        if(attaque.getPv()<=0){ //Si l'adversaire est ko
            return true;
        }

        return false;
    }
}
