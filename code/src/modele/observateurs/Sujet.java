package modele.observateurs;

import java.util.List;

/**
 * Classe pour la mise en place du patron observateur
 */
public abstract class Sujet {

    protected List<Observateur> observateurs; //la liste de ses observateurs

    /**
     * Ajoute un observateur dans sa liste d'observateur
     * @param o : observateur à ajouter
     */
    public void addObservateur(Observateur o){
        observateurs.add(o);
    }

    /**
     * Notifie tous ses observateurs
     */
    public void notifier(){

    }

    //Getter
    public List<Observateur> getObservateurs() {
        return observateurs;
    }
}
