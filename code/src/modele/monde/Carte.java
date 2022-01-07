package modele.monde;

import java.util.Map;

public class Carte {

    private int[][] lesTuiles;
    private int hauteur, largeur, spawnX, spawnY;

    private Map<Integer,Tuile> dicoTuiles; //Contient tous les types de tuiles


    public Carte(String chemin,Map<Integer,Tuile> dicoTuiles){
        chargerCarte(chemin);
        this.dicoTuiles=dicoTuiles;
    }

    /**
     * Charge la carte d'après son fichier assigné
     * @param chemin : chemin du fichier à charger
     */
    public void chargerCarte(String chemin) {

        String fichier = LectureMonde.ChargerFichier(chemin);
        String[] partie = fichier.split("\\s+");
        largeur = LectureMonde.parseInt(partie[0]);
        hauteur = LectureMonde.parseInt(partie[1]);
        spawnX = LectureMonde.parseInt(partie[2]);
        spawnY = LectureMonde.parseInt(partie[3]);

        lesTuiles = new int[hauteur][largeur];
        for(int j=0;hauteur>j;j++){
            for(int i=0;i<largeur;i++) {
                lesTuiles[j][i] = LectureMonde.parseInt(partie[(i + j  * largeur) + 4]);
            }
        }
    }

    /**
     * Récupère suivant une tuile suivant sa position x,y
     * @param x
     * @param y
     * @return
     */
    public Tuile getTuile(int x, int y) {
        Tuile t=dicoTuiles.get(lesTuiles[y][x]);
        return t;
    }


    //Getter et setter
    public int[][] getLesTuiles() {
        return lesTuiles;
    }

    public void setLesTuiles(int[][] lesTuiles) {
        this.lesTuiles = lesTuiles;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }

    /**
     * Renvoie l'objet sous forle de chaîne de caractères
     * @return un string
     */
    @Override
    public String toString() {
        String res="";
        for (int j = 0; hauteur > j; j++) {
            for (int i = 0; i < largeur; i++) {
                res+=lesTuiles[j][i];
            }
            res+="\n";
        }

        res+="\n";
        return res;
    }
}
