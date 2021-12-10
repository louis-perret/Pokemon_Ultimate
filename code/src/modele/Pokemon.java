package modele;

import javafx.scene.image.Image;

public class Pokemon {
    private String nom;
    private Image image;
    private int pv;
    private int attaque;
    private int defense;
    private int vitesse;
    private Position position;
    private Type type;
    private Mouvement[] mouvements;

    private int niveau;
    private int experience;

    public Pokemon(String nom, Image image, int pv, int attaque, int defense, int vitesse, Position position,Type type,Mouvement[] tabMouvements) {
        this.nom = nom;
        this.image = image;
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.vitesse = vitesse;
        this.position = position;
        this.type = type;
        this.mouvements=tabMouvements;
        this.niveau=1;
        this.experience=0;
    }

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
        this.pv = pv;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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

    @Override
    public String toString(){
        String res = "Pokemon : " + this.getNom() + " de type " + this.getType()  + ". A comme technique : ";
        for (Mouvement m : mouvements){
            res  += m.getNom();
        }
        return res;
    }
}
