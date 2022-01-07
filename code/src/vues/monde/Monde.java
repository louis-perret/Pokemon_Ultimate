package vues.monde;

import javafx.scene.Group;
import modele.LectureMonde;
import modele.Position;
import modele.tuiles.Tuile;
import vues.afficheur.AfficheurTuile;

import java.util.ArrayList;
import java.util.List;

//Contient nos différentes cartes
public class Monde {

    List<Carte> lesCartes = new ArrayList<Carte>();

    public Monde() {
        lesCartes.add(new Carte("Ressources/cartes/Lobby.txt"));
        lesCartes.add(new Carte("Ressources/cartes/Arène.txt"));

    }

    public List<Carte> getLesCartes() {
        return lesCartes;
    }

    public void setLesCartes(List<Carte> lesCartes) {
        this.lesCartes = lesCartes;
    }
}
