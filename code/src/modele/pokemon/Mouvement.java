package modele.pokemon;

//Identifie les attaques
public class Mouvement {
    private int degats; //ses points de dégâts
    private String nom; //son nom
    private Type type; //son type

    /**
     * Constructeur
     * @param degats ses points de dégats
     * @param nom son nom
     * @param type son type
     */
    public Mouvement(int degats, String nom, Type type) {
        this.degats = degats;
        this.nom = nom;
        this.type = type;
    }

    /* Getter et setter */
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
