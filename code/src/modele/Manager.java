package modele;

public class Manager {

    private Attaqueur attaqueur;
    private Afficheur afficheur;
    private Deplaceur deplaceur;
    //private Collisionneur collisionneur;

    public Manager() {
        this.attaqueur = new AttaqueurPokemon();
        this.afficheur = new AfficheurPokemon();
        this.deplaceur = new DeplacerPokemon();
    }


    public void attaquerPokemon(Pokemon attaquant, Pokemon attaque,Mouvement m){
        attaqueur.attaquer(attaquant,attaque,m);
    }

    public void deplacerPokemon(Pokemon pokemon,double x,double y){
        //Penser à prendre en compte le collisionneur avant de déplacer
        deplaceur.deplacer(pokemon,x,y);
    }
}
