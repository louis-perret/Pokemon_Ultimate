package modele.observateurs;

import java.util.List;

public abstract class Sujet {

    protected List<Observateur> observateurs;

    public List<Observateur> getObservateurs() {
        return observateurs;
    }

    public void addObservateur(Observateur o){
        observateurs.add(o);
    }

    public void notifier(){

    }
}
