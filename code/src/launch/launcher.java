package launch;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import modele.boucle.BoucleJeu;
import modele.boucle.BoucleJeu16;
import modele.chargement.Stub;
import observateurs.Observateur;
import observateurs.ObservateurBoucle;
import modele.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vues.afficheur.AfficheurPokemon;
import vues.afficheur.AfficheurTuile;
import vues.monde.Monde;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

//import static Modele.Type.plante;

public class launcher extends Application {

    private static Manager manager = new Stub().charger();

    public static Manager getManager() {
        return manager;
    }

    public static void setManager(Manager m) {
        launcher.manager = m;
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("../FXML/Fenetre.fxml");

        URL bulbURL= getClass().getResource("../Sprite/Sprite_bulbi/bulbasaur-sprite.png");
        Image bulbasaurimg = new Image(bulbURL.toExternalForm());

        URL bulbfURL= getClass().getResource("../Sprite/Sprite_bulbi/bulb_1.png");
        Image bulbasaurfimg = new Image(bulbfURL.toExternalForm());

        URL charmURL= getClass().getResource("../Sprite/Sprite_salam/charmender-sprite.png");
        Image charmimg = new Image(charmURL.toExternalForm());

        URL squirURL= getClass().getResource("../Sprite/Sprite_carap/squirtle-sprite.png");
        Image squirimg = new Image(squirURL.toExternalForm());

        FXMLLoader fxmlloader = new FXMLLoader(url);
        //Canvas racine = (Canvas) fxmlloader.load(); //On charge la fenêtre
        Group racine = new Group();
        Canvas canvas = new Canvas(1000,800);
        VBox content = new VBox();                                  //SCENE DE JEU
        Scene scene = new Scene(content,500,500);
        //Scene scene3 = new Scene(racine);
        //GraphicsContext gc = canvas.getGraphicsContext2D(); //Récupère le contexte graphic du canvas
        content.getChildren().add( canvas ); //On ajoute le canvas dans la  Vbox
        racine.getChildren().add(canvas);

        //stage.setScene(scene3);
        stage.setTitle("C'est la fenêtre du jeu!");



        Position position = new Position(64,64);
        Type type = Type.plante;
        Mouvement m1 = new Mouvement(10,"flammèche",Type.feu);
        Mouvement m2 = new Mouvement(10,"fouet-liane",Type.plante);
        Mouvement[] tabMouvements=new Mouvement[]{m2};
        Pokemon pokemon = new Pokemon("Bulbizarre",bulbasaurfimg,50,10,10,10,position,type,tabMouvements,1,0,null);
        tabMouvements[0]=m1;
        Pokemon p2 = new Pokemon("Salamèche",bulbasaurimg,10,10,10,10,position, Type.feu,tabMouvements,1,0,null);
        AfficheurPokemon affich = new AfficheurPokemon();
        AfficheurTuile affichT = new AfficheurTuile();
        DeplacerPokemon dp = new DeplacerPokemon();


        System.out.println(pokemon.toString());
/*
        Monde monde = new Monde("Ressources/Monde.txt");
        racine = monde.affichage();
*/
        //racine.getChildren().addAll(affich.affiche(pokemon, pokemon.getPosition())
        //        /*affichT.affiche(Tuile.tuileHerbe ,new Position(0,0))*/ );


        //Test du déplacement
        Parent parent = FXMLLoader.load(this.getClass().getResource("../FXML/Fenetre.fxml"));
        Scene scene1 = new Scene(parent);

        //Scene sceneJeu = new Scene(racine);

        //On ajoute un filtre d'évènement pour le déplacement du pokemon
        scene1.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            Pokemon p = manager.getPokemonCourant();
            Position positionPokemon = p.getPosition();
            switch (keyEvent.getCode()){
                case Z :
                    manager.deplacerPokemon(p, new Position(positionPokemon.getPositionX(),positionPokemon.getPositionY()-32),stage.getHeight(),stage.getWidth());
                    System.out.println("en haut : " + manager.getPokemonCourant().getPosition());
                    break;
                case D :
                    manager.deplacerPokemon(p, new Position(positionPokemon.getPositionX()+32,positionPokemon.getPositionY()),stage.getHeight(),stage.getWidth());
                    System.out.println("à droite" + manager.getPokemonCourant().getPosition());
                    break;
                case S :
                    manager.deplacerPokemon(p, new Position(positionPokemon.getPositionX(),positionPokemon.getPositionY()+32),stage.getHeight(),stage.getWidth());
                    System.out.println("en bas" + manager.getPokemonCourant().getPosition());
                    break;
                case Q :
                    manager.deplacerPokemon(p, new Position(positionPokemon.getPositionX()-32,positionPokemon.getPositionY()),stage.getHeight(),stage.getWidth());
                    System.out.println("à gauche" + manager.getPokemonCourant().getPosition());
                    break;
            }
        });

        stage.setScene(scene1);


        manager.setCompteur(0);
        manager.setPokemonCourant(pokemon);
        List<Observateur> listeOb = new LinkedList<>();
        Observateur o = new ObservateurBoucle(manager);
        listeOb.add(o);
        BoucleJeu b = new BoucleJeu16(listeOb);
        Thread thread = new Thread(b);
        thread.start();
        stage.show();
        /* Appel des tests */
        //Test.testAttaque();
        //Test.testDeplacer();
        //TestBoucle.testBoucleJeu();
    }
}
