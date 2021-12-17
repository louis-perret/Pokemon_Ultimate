package modele;

//Permet de gérer nos différentes fonctionnalités
public class Manager {

    private Attaqueur attaqueur;
    private Afficheur afficheur;
    private Deplaceur deplaceur;
    private ControleurNiveau controleurNiveau;
    private Pokemon pokemonCourant;
    private int compteur=0;

    //private CollectionPokemon collectionPokemon=null;
    //private Collisionneur collisionneur;

    /**
     * Constructeur
     * @param collectionPokemon
     */
    public Manager(CollectionPokemon collectionPokemon) {
        this.attaqueur = new AttaqueurPokemon();
        this.afficheur = new AfficheurPokemon();
        this.deplaceur = new DeplacerPokemon();
        this.controleurNiveau=new ControleurNiveau(collectionPokemon);
    }

    /**
     * Gère l'attaque d'un pokemon vers un autre
     * @param attaquant : pokemon qui attaque
     * @param attaque : pokemon qui est attaqué
     * @param m : l'attaque utilisée
     */
    public void attaquerPokemon(Pokemon attaquant, Pokemon attaque,Mouvement m){
        boolean battu=attaqueur.attaquer(attaquant,attaque,m);
        if(battu) { //S'il a gagné le combat
            controleurNiveau.gagnerExperience(attaquant, attaque); //On le fait gagner de l'expéricence
        }
    }

    /**
     * Gère le déplacement d'un pokemon
     * @param pokemon : pokemon qui se déplace
     * @param x : sa nouvelle position x
     * @param y : sa nouvelle position y
     */
    public void deplacerPokemon(Pokemon pokemon,double x,double y){
        //Penser à prendre en compte le collisionneur avant de déplacer
        deplaceur.deplacer(pokemon,x,y);
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }
}
