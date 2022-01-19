package chargement;

import modele.Manager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SauveurBinaire extends Sauveur{

    public SauveurBinaire(String cheminFichier){
        this.cheminFichier=cheminFichier;
    }

    @Override
    public void sauver(Manager manager) {
        if(manager==null){
            throw new IllegalArgumentException("Objet vide, impossible de l'enregistrer");
        }
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            writer.writeObject(manager);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}
