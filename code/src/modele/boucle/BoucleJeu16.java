package modele.boucle;

import javafx.application.Platform;
import modele.observateurs.Observateur;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Boucle de jeu utile pour le déplacement du pokemon choisi par l'utilisateur
 */
public class BoucleJeu16 extends BoucleJeu{

    /**
     * Constructeur
     */
    public BoucleJeu16(){
        super.observateurs=new LinkedList<>();
    }

    /**
     * Méthode exécuté par le thread. S'endort 16 milli-secondes avant de notifier son observateur
     */
    @Override
    public void run() {
        try{
            while(true) {
                Thread.sleep(16);
                notifier();
            }
        }
        catch (Exception e){
            System.out.println("Erreur dans la boucle : " + e.getMessage());
        }
    }

    /**
     * Notifie tous ses observateurs
     */
    @Override
    public void notifier() {
        //Instruction envoyée au thread principal
        Platform.runLater(() -> {
            for(Observateur o : super.observateurs){
                o.update();
            }
        });

    }
}
