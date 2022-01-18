package chargement;

import modele.Manager;

public abstract class Chargeur {

    protected String cheminFichier;

    public abstract Manager charger();
}
