package model;

import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Support {

    public String nomSupport;
    private long debit;
    private long longueur;
    private ArrayList<Trame> trames;

    public Support(String nomSupport,long debit ,long longueur) {
        this.nomSupport = nomSupport;
        this.debit = debit;
        this.longueur = longueur;
        trames = new ArrayList<Trame>();
    }

    public int accepterTrame(Trame trame) {
        trames.add(trame);
        return trames.size();
    }


    public String getNomSupport() { return nomSupport; }

    public long getDebit() { return debit; }

    public long getLongueur() { return longueur; }
}
