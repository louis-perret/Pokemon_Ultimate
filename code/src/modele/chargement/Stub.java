package modele.chargement;

import javafx.scene.image.Image;

import java.net.URL;

public class Stub {

    //public static Image Herbe;
    //public static Image Portail_bas_gauche;
    public static Image Herbe = new Image("Tuiles/Herbe.png");
    public static Image Portail_bas_gauche = new Image("Tuiles/portail_bas_gauche.png");
    public static Image Portail_haut_gauche = new Image("Tuiles/portail_haut_gauche.png");
    public static Image Portail_bas_droite = new Image("Tuiles/portail_bas_droite.png");
    public static Image Portail_haut_droite = new Image("Tuiles/portail_haut_droite.png");


    public void ChargeImages() {
        URL url = getClass().getResource("Tuiles/Herbe.png");
        Image Herbe = new Image(url.toExternalForm());
        URL urlPbg = getClass().getResource("Tuiles/portail_bas_gauche.png");
        Image Portail_bas_gauche = new Image(urlPbg.toExternalForm());
    }

}
