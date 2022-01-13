package modele.boucle;

import modele.observateurs.Observateur;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class BoucleJeu16 extends BoucleJeu{

    public BoucleJeu16(List<Observateur> l){
        super.observateurs=new LinkedList<>();
        for(Observateur o : l ){
            super.addObservateur(o);
        }
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
        for(Observateur o : super.observateurs){
            o.update();
        }
    }
}
