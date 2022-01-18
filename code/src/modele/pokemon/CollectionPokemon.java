package modele.pokemon;

import java.util.*;

//Permet de stocker tous les pokemons du jeu
public class CollectionPokemon {

    private Map<Integer, List<Pokemon>> pokedex; //On stocke les pokemons suivant leur niveau

    /**
     * Constructeur
     * @param niveau1 : Collection des pokemons de niveau 1
     * @param niveau2 : Collection des pokemons de niveau 2
     * @param niveau3 : Collection des pokemons de niveau 3
     */
    public CollectionPokemon(List<Pokemon> niveau1,List<Pokemon> niveau2,List<Pokemon> niveau3){
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
        List<Pokemon> ens = pokedex.get(niveau);
        Pokemon pokemonRecherche=null;
        for(Pokemon p : ens){
            if(p.getNom().equals((nom))){
                pokemonRecherche=p;
            }
        }
        return pokemonRecherche;
    }

    /**
     * Retourne une liste des pokemon starter
     * @return une liste de pokemon
     */
    public List<Pokemon> getStarterLvl1(){
        List<Pokemon> niv1 = pokedex.get(1); //On récupère la liste des pokemon de niveau 1
        List<Pokemon> listeStarterNiv1 = new ArrayList<Pokemon>();
        for (Pokemon p : niv1){
            if(p.getStarter()){ //Si c'est un starter
                listeStarterNiv1.add(p); //On l'ajoute à la liste
            }
        }
        return listeStarterNiv1;
    }


    /**
     * Renvoie une liste de n pokemon par rapport au numéro de la vague
     * @param numeroVague : numéro de la vague (correspond au niveau des pokemon ennemis)
     * @param nbPokemonByVague : nombre de pokemon à renvoyer
     * @param courant : pokemon de l'utilisateur
     * @return Une liste de n pokemon à affronter
     */
    public List<Pokemon> getListePokemon(int numeroVague, int nbPokemonByVague,Pokemon courant) {
        List<Pokemon> listePokemon = new ArrayList<>();
        Random random = new Random();
        Pokemon p;
        while(listePokemon.size()<nbPokemonByVague){
            p=pokedex.get(numeroVague).get(random.nextInt(pokedex.get(numeroVague).size()));
            if(!listePokemon.contains(p) && !courant.equals(p)) { //Si le pokemon n'a pas déjà été pris ou si ce n'est pas le pokemon choisi par le joueur
                listePokemon.add(p.cloner()); //On l'ajoute à la liste
            }
        }
        return listePokemon;
    }

    /**
     * Affiche l'instance sous forme de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res="";
        Set<Map.Entry<Integer,List<Pokemon>>> ens = pokedex.entrySet();
        for(Map.Entry<Integer,List<Pokemon>> dico : ens){
            res+= "Niveau " + dico.getKey() + " : ";
            for(Pokemon p : dico.getValue()){
                res+= p.getNom() + ", ";
            }
            res+= "\n";
        }
        return res;
    }

}
