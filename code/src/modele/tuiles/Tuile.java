package modele.tuiles;

import javafx.scene.image.Image;

public abstract class Tuile {

    public static final int TuileHauteur = 32;
    public static final int TuileLargeur = 32;

    private int id;
    private String image;
    public static Tuile[] lesTuiles = new Tuile[30];
    public static Tuile tuileHerbe = new TuileHerbe(0);
    public static Tuile tuileMur = new TuileMur(1);

    public Tuile(int id, String image){
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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