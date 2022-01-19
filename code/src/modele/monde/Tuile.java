package modele.monde;

import java.io.Serializable;

/**
 * Classe qui défiinit une tuile
 */
public class Tuile implements Serializable {

    public transient static final int tuileHauteur = 32;
    public transient static final int tuileLargeur = 32;

    private int id;
    private String image;
    private Boolean isTraversable;
    private int evenement;

    public Tuile(int id, String image, Boolean isTraversable, int evenement){

        this.id = id;
        this.image = image;
        this.isTraversable = isTraversable;
        this.evenement = evenement;
    }

    //Getter et setter
    public Boolean getTraversable() {
        return isTraversable;
    }

    public void setTraversable(Boolean traversable) {
        isTraversable = traversable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEvenement() {
        return evenement;
    }

    public void setEvenement(int evenement) {
        this.evenement = evenement;
    }

    /**
     * Renvoie l'objet sous forle de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res = "";
        res+=getId();
        return res;
    }
}
