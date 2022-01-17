package modele.combat;

import modele.pokemon.CollectionPokemon;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

public class ControleurCombatV1 extends ControleurCombat{

    public ControleurCombatV1(CollectionPokemon pokedex){
        iaPokemon=new IAPokemonSimple();
        controleurNiveau=new ControleurNiveau(pokedex);
        attaqueur = new AttaqueurPokemon();
    }

    @Override
    public int effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie){
        Mouvement mEnnemi = iaPokemon.choisirAttaque(ennemi);
        System.out.println(ennemi.getNom() + " utilise " + mEnnemi.getNom());
        if(allie.getVitesse() >= ennemi.getVitesse()){
            System.out.println(allie.getNom() + " attaque en premier.");
            if(attaqueur.attaquer(allie,ennemi,mAllie)) {
                controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                return 1; //le pokemon ennemi est ko
            }
            else{
                if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                    return 2; //le pokemon du joueur est ko
                }
            }
        }
        else{
            System.out.println(ennemi.getNom() + " attaque en premier.");
            if(attaqueur.attaquer(ennemi,allie,mEnnemi)) {
                return 2; //le pokemon du joueur est ko
            }
            else{
                if(attaqueur.attaquer(allie,ennemi,mAllie)) {
                    controleurNiveau.gagnerExperience(allie, ennemi); //On lui fait gagner de l'expérience
                    return 1; //le pokemon ennemi est ko
                }
            }
        }
        return 0; //aucun pokemon n'est ko
    }
}
