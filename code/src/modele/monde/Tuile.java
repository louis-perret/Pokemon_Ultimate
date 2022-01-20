package modele.monde;

import java.io.Serializable;

/**
 * Classe qui définit une tuile
 */
public class Tuile implements Serializable {

    public transient static final int tuileHauteur = 32;
    public transient static final int tuileLargeur = 32;

    private int id; //son id
    private String image; //son image
    private Boolean isTraversable; //true si on peut se déplacer dessus
    private int evenement; //son évènement associé

    /**
     * Constructeur
     * @param id: identifiant unique de la tuile
     * @param image: Image de la tuile
     * @param isTraversable: La tuile est-elle travesable
     * @param evenement: Evenement attaché à une tuile
     */

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

    public static int getTuileHauteur(){
        return tuileHauteur;
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
