package modele.tuiles;

import javafx.scene.image.Image;
import modele.chargement.Stub;

//Identifie une tuile
public class Tuile {

    public static final int TuileHauteur = 32;
    public static final int TuileLargeur = 32;

    private int id;
    private Image image;
    private Boolean isTraversable;
    public static Tuile[] lesTuiles = new Tuile[30];
    public static Tuile tuileHerbe = new Tuile(0, Stub.Herbe,true);
    public static Tuile tuilePbg = new Tuile(1,Stub.Portail_bas_gauche,false);
    public static Tuile tuilePbd = new Tuile(2,Stub.Portail_bas_droite,false);
    public static Tuile tuilePhg = new Tuile(3,Stub.Portail_haut_gauche,false);
    public static Tuile tuilePhd = new Tuile(4,Stub.Portail_haut_droite,false);
    public static Tuile tuileBrique = new Tuile(5,Stub.Brique,false);


    public Tuile(int id, Image image, Boolean isTraversable){
        this.id = id;
        this.image = image;
        this.isTraversable = isTraversable;
        lesTuiles[id] = this;
    }

    public Boolean getTraversable() {
        return isTraversable;
    }

    public void setTraversable(Boolean traversable) {
        isTraversable = traversable;
    }

    /*
        public boolean isTraversable() {
            return true;
        }
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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