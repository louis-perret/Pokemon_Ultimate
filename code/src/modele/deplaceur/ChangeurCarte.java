package modele.deplaceur;

import modele.monde.Carte;
import modele.pokemon.Position;

public interface ChangeurCarte {

    public int isChangement(Position positionActuel, Carte carte);
}
