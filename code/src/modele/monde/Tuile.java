package modele.monde;

import javafx.scene.image.Image;
import modele.chargement.Stub;

/**
 * Classe qui défiinit une tuile
 */
public class Tuile {

    public static final int tuileHauteur = 32;
    public static final int tuileLargeur = 32;

    private int id; //type de tuile
    private String image; //son image
    private Boolean isTraversable; //true si on peut marcher dessus

    /**
     * Constructeur
     * @param id : id de la tuile
     * @param image : chemin de son image
     * @param isTraversable : bool
     */
    public Tuile(int id, String image, Boolean isTraversable){
        this.id = id;
        this.image = image;
        this.isTraversable = isTraversable;
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
//BINDING

/*
private StringProperty toto = new SimpleStringProperty();
public String getToto{return toto.get();}
public void setToto(String valeur){toto.set(valeur);}
public ReadOnlyStringProperty totoProperty(){return toto;}
objet.preopriete().bind(objet2.property());
<Button text="${objet.prop}"/>
 */