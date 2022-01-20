package chargement;

import modele.Manager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Classe qui gère la sauvegarde d'un objet dans un fichier binaire
 */
public class SauveurBinaire extends Sauveur{

    /**
     * Constructeur
     * @param cheminFichier : chemin du fichier source
     */
    public SauveurBinaire(String cheminFichier){
        this.cheminFichier=cheminFichier;
    }

    /**
     * Sauvegarde un objet Manager dans le fichier cheminFichier
     * @param manager : objet à sérialiser
     */
    @Override
    public boolean sauver(Manager manager) {
        if(manager==null){
            throw new IllegalArgumentException("Objet vide, impossible de l'enregistrer");
        }
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            writer.writeObject(manager); //on écrit l'objet
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
