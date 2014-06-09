package main;

import gui.FenetrePrincipale;
import model.Reseau;

/**
 * Created by Hakim on 09/06/14.
 */
public class Simulation {
    private Reseau reseau = new Reseau();

    public static void main(String args[]) {
        Simulation simulation = new Simulation();
        new FenetrePrincipale(simulation);
    }

    public Reseau getReseau() {
        return reseau;
    }
}
