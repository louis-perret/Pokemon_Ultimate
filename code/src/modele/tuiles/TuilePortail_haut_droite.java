package modele.tuiles;

import modele.chargement.Stub;

public class TuilePortail_haut_droite extends Tuile{

    public TuilePortail_haut_droite(int id) {
        super(id, Stub.Portail_haut_droite);
    }

    @Override
    public boolean isTraversable(){
        return false;
    }
}
