package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Permet de stocker tous les pokemons du jeu
public class CollectionPokemon {

    private Map<Integer, Set<Pokemon>> pokedex; //On stocke les pokemons suivant leur niveau

    /**
     * Constructeur
     * @param niveau1 : Collection des pokemons de niveau 1
     * @param niveau2 : Collection des pokemons de niveau 2
     * @param niveau3 : Collection des pokemons de niveau 3
     */
    public CollectionPokemon(Set<Pokemon> niveau1,Set<Pokemon> niveau2,Set<Pokemon> niveau3){
        pokedex= new HashMap<>();
        pokedex.put(1,niveau1);
        pokedex.put(2,niveau2);
        pokedex.put(3,niveau3);
    }

    /**
     * Récupérer un pokemon en fonction de son nom de son niveau
     * @param nom : nom du pokemon à récupérer
     * @param niveau : niveau du pokemon à récupérer
     * @return un pokemon
     */
    public Pokemon getPokemon(String nom,int niveau){
        Set<Pokemon> ens = pokedex.get(niveau);
        Pokemon pokemonRecherche=null;
        for(Pokemon p : ens){
            if(p.getNom().equals((nom))){
                pokemonRecherche=p;
            }
        }
        return pokemonRecherche;
    }
    

    /**
     * Affiche l'instance sous forme de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res="";
        Set<Map.Entry<Integer,Set<Pokemon>>> ens = pokedex.entrySet();
        for(Map.Entry<Integer,Set<Pokemon>> dico : ens){
            res+= "Niveau " + dico.getKey() + " : ";
            for(Pokemon p : dico.getValue()){
                res+= p.getNom() + ", ";
            }
            res+= "\n";
        }
        return res;
    }
}
