import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Support {

    public String nomSupport;
    private long debit;
    private long longueur;
    private ArrayList<Acteur> acteurs = new ArrayList<Acteur>();

    public Support(String nomSupport) {
        this.nomSupport = nomSupport;
    }


    public String getNomSupport() {
        return nomSupport;
    }

    public void ajouterActeur(Acteur acteur){
        acteurs.add(acteur);
    }
}
