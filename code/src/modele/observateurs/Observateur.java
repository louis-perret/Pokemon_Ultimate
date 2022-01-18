package modele.observateurs;

/**
 * Classe pour la mise en place du patron Observateur
 */
public interface Observateur {

    /**
     * Effectuera un traitement lorsqu'il sera notifié par le sujet qu'il observe
     */
    void update();
}
