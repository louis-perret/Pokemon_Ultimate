package modele.tuiles;

import modele.chargement.Stub;

public class TuilePortail_bas_droite extends Tuile {
    public TuilePortail_bas_droite(int id){
        super(id, Stub.Portail_bas_droite);
    }
    @Override
    public boolean isTraversable(){
        return false;
    }
}
