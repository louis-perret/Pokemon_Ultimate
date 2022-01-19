package chargement;

import modele.Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ChargeurBinaire extends Chargeur{

    public ChargeurBinaire(String cheminFichier){
        this.cheminFichier = cheminFichier;
    }


    @Override
    public Manager charger() {
        Manager type=null;
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(cheminFichier))) {
            type=(Manager) reader.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return type;
    }
}
