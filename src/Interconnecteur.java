import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Interconnecteur {

    public String nomConnecteur;
    private long debit;
    private ArrayList<Support> supports = new ArrayList<Support>();

    public Interconnecteur(String nomConnecteur) {
        this.nomConnecteur = nomConnecteur;
    }

    public Interconnecteur(String nomConnecteur, long debit) {
        this.nomConnecteur = nomConnecteur;
        this.debit = debit;
    }

    public String getNomConnecteur() {
        return nomConnecteur;
    }

    public void ajouterSupport(Support support) {
        supports.add(support);
    }
}
