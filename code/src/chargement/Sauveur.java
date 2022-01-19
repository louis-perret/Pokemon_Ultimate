package chargement;

import modele.Manager;

/**
 * Classe qui gère la sauvegarde d'un objet
 */
public abstract class Sauveur {

    protected String cheminFichier; //fichier source

    /**
     * Sauvegarde un objet Manager dans le fichier cheminFichier
     * @param manager : objet à sérialiser
     */
    public abstract void sauver(Manager manager);
}
