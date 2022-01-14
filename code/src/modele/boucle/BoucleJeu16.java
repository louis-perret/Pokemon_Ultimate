package modele.boucle;

import javafx.application.Platform;
import modele.observateurs.Observateur;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class BoucleJeu16 extends BoucleJeu{

    public BoucleJeu16(){
        super.observateurs=new LinkedList<>();
    }

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

    @Override
    public void notifier() {
        Platform.runLater(() -> {
            for(Observateur o : super.observateurs){
                o.update();
            }
        });

    }
}
