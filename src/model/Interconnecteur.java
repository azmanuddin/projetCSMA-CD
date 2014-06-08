package model;

import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Interconnecteur {

    private long debit;
    private ArrayList<Support> supports = new ArrayList<Support>();

    public void ajouterSupport(Support support) {
        supports.add(support);
    }

    public void setDebit(long debit) {
        this.debit = debit;
        System.out.println("Le débit de l'interlocuteur est maintenant " + debit);
    }
}
