import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */



public class Acteur {
    public String nomAct;
    public int kOctets=1024;
    public static final double tailleDonneesDeControle = 18.0;
    public ArrayList<Trame> trames;
    private ArrayList<Float> floats;




    public Acteur(String nomAct) {
        this.nomAct = nomAct;
        trames = new ArrayList<Trame>();
        floats = new ArrayList<Float>();
    }

    public String getNomAct() {
        return nomAct;
    }

    /*
        Calcul le découpage d'un fichier en plusieurs trames à envoyer.
     */
    public void envoyerFichier(int tailleFichier, Acteur destination ) {

        tailleFichier = tailleFichier * kOctets;

        if(tailleFichier > 1500) {
            int nbTramesPleins = tailleFichier/1500;
            double tTrans ;
            double tTransReste;
            int nbTrames = nbTramesPleins;
            int reste = tailleFichier%1500;

            int i;
            for (i = 1; i < (1+nbTramesPleins); i++) {
                tTrans = ((1500+tailleDonneesDeControle)*8/(double)10000000);
                trames.add(new Trame(1500 + tailleDonneesDeControle, this, destination).setTempsTrans(tTrans).setId(i));

            }

            if(reste > 0) {
                nbTrames++;
                if (reste < 46) reste = 46;
                tTransReste = ((reste+tailleDonneesDeControle)*8/(double)10000000);
                trames.add(new Trame(reste + tailleDonneesDeControle, this, destination).setTempsTrans(tTransReste).setId(i++));
            }
        }
    }

    public ArrayList<Trame> getTrames() {
        return trames;
    }

    public ArrayList<Float> getFloats() { return floats; }
}
