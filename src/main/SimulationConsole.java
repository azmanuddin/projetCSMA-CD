package main;

import model.Acteur;
import model.Reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by azman on 08/06/2014.
 */
public class SimulationConsole {
    private Reseau reseau;
    private int nbActeur;

    public SimulationConsole(int nbActeur) {
        this.nbActeur = nbActeur;
        reseau = new Reseau();
    }

    public static void main(String args[]) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            System.out.println("entrer le nombre d'acteurs");
            SimulationConsole simulation = new SimulationConsole(Integer.valueOf(br.readLine()));

            System.out.println("entrer le débit de l'interconnecteur");
            int debit = Integer.valueOf(br.readLine());
            simulation.reseau.setDebitInterconnecteur(debit);

            for(int i = 0; i < simulation.nbActeur; i++) {
                System.out.println("entrer le nom de l'acteur " + (i+1) + " : ");
                String nom = br.readLine();
                Acteur acteur = simulation.reseau.ajouterActeur(nom);

                System.out.println("entrer le nom du support entre " + nom + " et l'interconnecteur" );
                String nomSupport = br.readLine();
                System.out.println("   entrer le débit  du support " + nomSupport  );
                int debitSupport = Integer.valueOf(br.readLine());
                System.out.println("   entrer la longueur du support " + nomSupport  );
                int longueurSupport = Integer.valueOf(br.readLine());

                simulation.reseau.ajouterConnexion(acteur, nomSupport, debit, longueurSupport);
            }

            for(Acteur acteur : simulation.reseau.getActeurs()) {
                System.out.println("Quelle est la taille du fichier que l'acteur " + acteur.getNomAct() + " veut envoyer? " );
                int tailleFichier = Integer.valueOf(br.readLine());
                System.out.println("A qui l'acteur " + acteur.getNomAct() + " veut envoyer son ficier? " );
                String nomActeurDestination = br.readLine();
                Acteur acteurDestination = simulation.reseau.getActeur(nomActeurDestination);
                System.out.println("A quelle moment l'acteur " + acteur.getNomAct() + " envoie son ficier? " );
                double moment = Integer.valueOf(br.readLine());

                simulation.reseau.programmerEnvoieDeFichier(acteur, acteurDestination, tailleFichier, moment );

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
