package modele.pokemon;

import java.util.List;
import java.util.Set;

public class Type {

    private NomType nom;
    private List<NomType> forces;
    private List<NomType> faiblesses;

    public Type(NomType nom, List<NomType> forces, List<NomType> faiblesses) {
        this.nom = nom;
        this.forces=forces;
        this.faiblesses=faiblesses;
    }

    public NomType getNom() {
        return nom;
    }

    public List<NomType> getForces() {
        return forces;
    }

    public List<NomType> getFaiblesses() {
        return faiblesses;
    }

    @Override
    public String toString(){
        String res = "" + getNom();
        return res;
    }
}
