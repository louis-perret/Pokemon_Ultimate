package modele;

public class AttaqueurPokemon implements Attaqueur{

    @Override
    public void attaquer(Pokemon attaquant, Pokemon attaque,Mouvement m) {
        int degat = attaquant.getAttaque()+m.getDegats();
        attaque.setPv(attaque.getPv()-degat);
    }
}
