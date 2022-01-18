package modele.pokemon;

import modele.pokemon.etat.*;

import java.io.Serializable;

/**
 * Classe qui identifie un pokemon
 */
public class Pokemon implements Serializable {
    private String nom; //son nom
    private String image; //son image
    private int pv; //ses points de vies
    private int attaque; //ses points d'attaque
    private int defense; //ses points de défense
    private int vitesse; //ses points de vitesse
    private transient Position position; //ses coordonées
    private Type type; //son type
    private Mouvement[] mouvements; //contient ses 4 attaques

    private int niveau; //son niveau (1 au minimum)
    private int experience; //son expérience (0 au minimum)
    private String evolution; //contient le nom de son évolution
    private Boolean isStarter; //true si c'est un starter, false sinon
    private transient Etat etat; //état d'un pokemon


    /**
     * Constructeur de la classe
     * @param nom : son nom
     * @param image : son image
     * @param pv : ses points de vies
     * @param attaque : ses points d'attaque
     * @param defense : ses points de défence
     * @param vitesse : ses points de vitesse
     * @param position : ses coordonées
     * @param type : son type
     * @param tabMouvements : ses attaques
     * @param niveau : son niveau
     * @param experience : son expérience
     * @param evolution : le nom de son évolution
     */
    public Pokemon(String nom, String image, int pv, int attaque, int defense, int vitesse, Position position, Type type, Mouvement[] tabMouvements, int niveau, int experience, String evolution,Boolean isStarter) {
        this.nom = nom;
        this.image = image;
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.position = position;
        this.type = type;
        this.mouvements=tabMouvements;
        this.niveau=niveau;
        this.experience=experience;
        this.evolution=evolution;
        this.isStarter = isStarter;
        this.etat=null;
    }

    /**
     * Clone le pokemon (Patron Prototype)
     * @return un Pokemon
     */
    public Pokemon cloner(){
        return new Pokemon(getNom(),getImage(),getPv(),getAttaque(),getDefense(),getVitesse(),getPosition(),getType(),getMouvements(),getNiveau(),getExperience(),getEvolution(),getStarter());
    }

    /**
     * Applique les effets de son états (Patron Etat)
     */
    public void appliquerEtat(){
        if(etat != null){ //s'il a un état
            etat.comportement(this); //on applique son comportement
        }
    }

    /* Getter et Setter */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        if(pv<=0){ //S'il n'a plus de points de vie
            this.pv=0;
        }
        else{
            this.pv=pv;
        }
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Mouvement[] getMouvements() {
        return mouvements;
    }

    public void setMouvements(Mouvement[] mouvements) {
        this.mouvements = mouvements;
    }

    /**
     * Retourne sa technique par rapport à son nom
     * @param nom : nom de l'attaque
     * @return un Mouvement
     */
    public Mouvement getMouvement(String nom){
        for (Mouvement m : mouvements){
            if(m.getNom().equals(nom)){
                return m;
            }
        }
        return null; //pas trouvé
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public Boolean getStarter() {return isStarter;}

    public void setStarter(Boolean starter) {isStarter = starter;}

    public Etat getEtat(){
        return etat;
    }
    public void setEtat(Etat etat){
        this.etat=etat;
    }

    /**
     * Renvoie true si deux instances sont identiques (ici d'après leur nom)
     * @param o : objet à comparer
     * @return un booleen
     */
    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(this==o) return true;
        if(this.getClass()!=o.getClass()) return false;

        Pokemon p=(Pokemon)o;
        if(nom.equals(p.getNom())) return true;
        return false;
    }

    /**
     * Renvoie un hashCode unique pour une instance
     * @return un int
     */
    @Override
    public int hashCode(){
        int premier=13;
        int result=1;

        result=premier*result + nom.hashCode();
        return result;
    }

    /**
     * Renvoie l'instance sous forme de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res = "Pokemon : " + this.getNom() + " de type " + this.getType()  + ". A comme technique : ";
        for (Mouvement m : mouvements){
            res  += m.getNom();
        }
        return res;
    }
}
