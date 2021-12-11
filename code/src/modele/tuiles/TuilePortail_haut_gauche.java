package modele.tuiles;

import modele.chargement.Stub;

public class TuilePortail_haut_gauche extends Tuile{
    public TuilePortail_haut_gauche(int id){
        super(id, Stub.Portail_haut_gauche);
    }
    @Override
    public boolean isTraversable(){
        return false;
    }

}