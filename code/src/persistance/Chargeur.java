package persistance;

import modele.Manager;

/**
 * Classe qui gère le chargement d'un objet
 */
public abstract class Chargeur {

    protected String cheminFichier; //fichier source

    /**
     * Charge un objet Manager à partir du fichier cheminFichier
     * @return un Manager
     */
    public abstract Manager charger();
}
