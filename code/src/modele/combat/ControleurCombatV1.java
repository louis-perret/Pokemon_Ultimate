package modele.combat;

import modele.pokemon.CollectionPokemon;
import modele.pokemon.Mouvement;
import modele.pokemon.Pokemon;

/**
 * Classe gérant le control d'un combat
 */
public class ControleurCombatV1 extends ControleurCombat{

    /**
     * Constructeur
     * @param pokedex : La collection de pokemon utile au contrôleur niveau
     */
    public ControleurCombatV1(CollectionPokemon pokedex){
        iaPokemon=new IAPokemonSimple();
        controleurNiveau=new ControleurNiveau(pokedex);
        attaqueur = new AttaqueurPokemon();
    }

    /**
     * Effectue un tour de combat
     * @param allie : pokemon du joueur
     * @param ennemi : pokemon ennemi
     * @param mAllie : attaque utilisée par le joueur
     * @return un int signifiant s'il y a eu un pokemon ko
     */
    @Override
    public int effectuerCombat(Pokemon allie, Pokemon ennemi, Mouvement mAllie){
        Mouvement mEnnemi = iaPokemon.choisirAttaque(ennemi);
        if(allie.getVitesse() >= ennemi.getVitesse()){ //si le pokemon du joueur est plus rapide
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
        else{ //si le pokemon ennemi est plus rapide
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
        //On applique le comportement des états du pokemon si aucun n'est ko
        allie.appliquerEtat();
        ennemi.appliquerEtat();
        return 0; //aucun pokemon n'est ko
    }
}
