package modele;

public class ControleurNiveau {

    public void gagnerExperience(Pokemon p,Pokemon ennemi){
        int xpGagne=0;
        int niveauEnnemi=ennemi.getNiveau();

        if(niveauEnnemi==1){
            xpGagne=15;
        }
        else{
            if(niveauEnnemi==2){
                xpGagne=20;
            }
            else{
                xpGagne=25;
            }
        }

        p.setExperience(p.getExperience()+xpGagne);
        if(p.getExperience()>=100){
            p.setNiveau(p.getNiveau()+1);
        }
    }
}
