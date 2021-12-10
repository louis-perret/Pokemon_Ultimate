package modele.tuiles;

public class TuileMur extends Tuile{
    public TuileMur(int id){
        super(id, "Mur.png");
    }
    @Override
    public boolean isTraversable(){
        return false;
    }

}
