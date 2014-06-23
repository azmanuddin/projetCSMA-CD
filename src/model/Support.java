package model;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Support {

    public JComboBox nomSupport;
    private long debit;
    private long longueur;
    private ArrayList<Trame> trames;

    public Support(JComboBox nomSupport,long debit ,long longueur) {
        this.nomSupport = nomSupport;
        this.debit = debit;
        this.longueur = longueur;
        trames = new ArrayList<Trame>();
    }


    public int accepterTrame(Trame trame) {
        trames.add(trame);
        return trames.size();
    }


    public JComboBox getNomSupport() {return nomSupport;}

    public long getDebit() { return debit; }

    public long getLongueur() { return longueur; }
}
