package chargement;

import modele.Manager;

public abstract class Sauveur {

    protected String cheminFichier;

    public abstract void sauver(Manager manager);
}
