package modele.tuiles;

import modele.chargement.Stub;

public class TuilePortail_bas_gauche extends Tuile{
    public TuilePortail_bas_gauche(int id){
        super(id, Stub.Portail_bas_gauche);
    }
    @Override
    public boolean isTraversable(){
        return false;
    }

}
