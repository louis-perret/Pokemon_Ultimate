package Modele;

public class BoucleJeu implements Runnable{

    private boolean tourne = true;
    private Thread thread;

    public BoucleJeu(){
        //Constructeur
    }
    private void init(){
        //appel pour l'affichage d'iamges ici
    }

    private void Base(){
        // bouger la définition du canvas, graphicscontext, ... du jeu ici
    }

    public synchronized void debut(){
        if (tourne)
            return;
        tourne = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void fin(){
        if (!tourne)
            return;
        tourne = false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void tick(){

    }

    @Override
    public void run() {     //Boucle qui tick une fois par sec (normalement)
        init();

        int fps = 60;
        double tempsTick = 1000000000 / fps;
        double delta = 0;
        long actuel;
        long ancien = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while(tourne){
            actuel = System.nanoTime();
            delta += (actuel - ancien) / tempsTick;
            timer += actuel - ancien;
            ancien = actuel;
            if (delta >= 1){
                tick();
                Base();
                ticks++;
                delta--;
            }
            if (timer >=1000000000){
                System.out.println("Tick");
                ticks =0;
                timer =0;
            }
        }
        fin();
    }
    //BOUCLE DE JEU  A FAIRE PLUS TARD
}
