package modele.monde;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectureMonde {

    public static String chargerFichier(String chemin) {
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(chemin));
            String ligne;
            while((ligne = br.readLine()) != null){
                builder.append(ligne + "\n");

            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static int parseInt(String nombre) {
        try{
            return Integer.parseInt(nombre);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
