package modele.combat;

import modele.pokemon.CollectionPokemon;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

public class ControleurCombatV1 extends ControleurCombat{

    public ControleurCombatV1(CollectionPokemon pokedex){
        controleurNiveau=new ControleurNiveau(pokedex);
        attaqueur = new AttaqueurPokemon();
    }

    @Override
    public boolean effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie, Mouvement mEnnemi){
        if(allie.getVitesse() >= ennemi.getVitesse()){
            if(attaqueur.attaquer(allie,ennemi,mAllie));
                controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                return true;
        }
        else{
            if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                return true;
            }
        }
        return false;
    }
}
