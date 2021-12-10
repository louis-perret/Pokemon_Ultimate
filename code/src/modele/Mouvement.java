package Modele;

public class Mouvement {
    private int degats;
    private String nom;
    private Type type;

    public Mouvement(int degats, String nom, Type type) {
        this.degats = degats;
        this.nom = nom;
        this.type = type;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
