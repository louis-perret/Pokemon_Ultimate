package modele.pokemon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.pokemon.Type;
import modele.pokemon.etat.Etat;

import java.io.Serializable;
import java.util.Random;

/**
 * Classe qui définit les attaques d'un pokemon
 */
public class Mouvement implements Serializable {
    private int degats; //ses points de dégâts
    private String nomPrive; //son nom

    private transient StringProperty nom = new SimpleStringProperty(); //son nom
    public String getNom(){ return nom.get(); }
    public void setNom(String nom) {
        this.nom.set(nom);
        nomPrive=nom;
    }
    public StringProperty nomProperty() { return nom;}

    private Type type; //son type
    private Etat etat; //l'état qu'il peut infliger au pokemon ennemi

    /**
     * Constructeur
     * @param degats : points de dégâts
     * @param nom : nom
     * @param type : type
     * @param etat : quel état peut affliger cette attaque
     */
    public Mouvement(int degats, String nom, Type type, Etat etat){
        this.degats=degats;
        setNom(nom);
        this.type=type;
        this.etat=etat;
    }

    /**
     * Comportement de l'attaque sur un pokemon. Peut modifier l'état d'un pokemon
     * @param ennemi : pokemon sur lequel sera appliaué ce comportement
     */
    public void comportement(Pokemon ennemi){
        if(ennemi.getEtat() == null) { //un pokemon ne peut pas avoir qu'un état à la fois jusqu'à sa guérison, donc si null -> le pokemon ennemi peut subir un changement d'état
            if (etat != null) { //si null -> l'attaque n'affectera pas l'état de l'adversaire
                Random random = new Random();
                if (random.nextInt(4) == 0) {
                    ennemi.setEtat(etat); //une chance sur 4 de modifier l'état de l'adversaire
                }
            }
        }
    }

    /**
     *  Initialisation de la propriété après la serialisation
     */

    public void initialisationProprietesOnDeserialized(){
        nom=new SimpleStringProperty();
        setNom(nomPrive);
    }

    /* Getter et setter */
    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString(){
        String res = "";
        res += nom + " de type " + type.getNom() + " fais comme dégâts : " + degats;
        return res;
    }
}
