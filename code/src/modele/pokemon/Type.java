package modele.pokemon;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Classe qui identifie un type
 */
public class Type implements Serializable{

    private NomType nom; //son nom
    private List<NomType> forces; //ses forces
    private List<NomType> faiblesses; //ses faiblesses

    /**
     * Constructeur
     * @param nom : son nom
     * @param forces :ses forces
     * @param faiblesses : ses faiblesses
     */
    public Type(NomType nom, List<NomType> forces, List<NomType> faiblesses) {
        this.nom = nom;
        this.forces=forces;
        this.faiblesses=faiblesses;
    }

    //Getter et setter
    public NomType getNom() {
        return nom;
    }

    public List<NomType> getForces() {
        return forces;
    }

    public List<NomType> getFaiblesses() {
        return faiblesses;
    }

    /**
     * Retourne l'instance sous forme d'une chaîne de caractères
     * @return un string
     */
    @Override
    public String toString(){
        String res = "" + getNom();
        return res;
    }
}
