package modele.tuiles;

import javafx.scene.image.Image;

public abstract class Tuile {

    public static final int TuileHauteur = 32;
    public static final int TuileLargeur = 32;

    private int id;
    private Image image;
    public static Tuile[] lesTuiles = new Tuile[30];
    public static Tuile tuileHerbe = new TuileHerbe(0);
    public static Tuile tuilePbg = new TuilePortail_bas_gauche(1);
    public static Tuile tuilePbd = new TuilePortail_bas_droite(2);
    public static Tuile tuilePhg = new TuilePortail_haut_gauche(3);
    public static Tuile tuilePhd = new TuilePortail_haut_droite(4);


    public Tuile(int id, Image image){
        this.id = id;
        this.image = image;
        lesTuiles[id] = this;
    }


    public boolean isTraversable() {
        return true;
    }

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