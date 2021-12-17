package observateurs;

import modele.Manager;

public class ObservateurBoucle implements Observateur {

    private Manager manager;

    public ObservateurBoucle(Manager m){
        this.manager=m;
    }

    @Override
    public void update() {
        manager.setCompteur(manager.getCompteur()+1);
    }
}
