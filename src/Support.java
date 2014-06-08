import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Support {

    public String nomSupport;
    private long debit;
    private long longueur;
    //private ArrayList<Acteur> acteurs = new ArrayList<Acteur>();

    public Support(String nomSupport,long debit ,long longueur) {
        this.nomSupport = nomSupport;
        this.debit = debit;
        this.longueur = longueur;
    }


    public String getNomSupport() {

        return nomSupport;
    }

    public long getDebit() {
        return debit;
    }

    public long getLongueur() {
        return longueur;
    }

    /*public void ajouterActeur(Acteur acteur){
        acteurs.add(acteur);
    }*/
}
