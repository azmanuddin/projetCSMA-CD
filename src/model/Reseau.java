package model;

import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Reseau {

    private ArrayList<Acteur> acteurs;
    private Interconnecteur interconnecteur;
    private ArrayList<Support> supports;

    /*
        Constructeurs
     */

    public Reseau(int nbActeur) {
        interconnecteur = new Interconnecteur();
        acteurs = new ArrayList<Acteur>();
    }

    /*
        Méthodes publiques
     */
    public void setDebitInterconnecteur(long debit) {
        interconnecteur.setDebit(debit);
    }

    public Acteur ajouterActeur(String nom) {
        Acteur acteur = new Acteur(nom);
        acteurs.add(acteur);
        return acteur;
    }

    public void ajouterConnexion(Acteur acteur, String nomSupport, long debit, long longueur) {
        Support support = new Support(nomSupport, debit, longueur);
        acteurs.get(acteurs.indexOf(acteur)).setSupport(support);
        interconnecteur.ajouterSupport(support);

        System.out.println("\nUne connexion est établie entre l'acteur "
                           + acteur.getNomAct() + " et l'interconnecteur "
                           + "par le support " + nomSupport + " de débit "
                           + debit + " et de longueur " + longueur);
    }

    /*
        Programme l'envoie d'un fichier d'une taille donnée depuis un acteur source vers un acteur destination
        à un moment donné.
     */
    public void programmerEnvoieDeFichier(Acteur source, Acteur destination, int tailleFichier, double moment) {
        source.decouperFichier(tailleFichier, destination);
        source.setTempsEnvoie(moment);
        System.out.println("Envoie de fichier de taille " + tailleFichier + " depuis "+ source.getNomAct()
                         + " à " + destination.getNomAct() + " à t = " + moment +"\n" );
    }

    public void commencerEnvoieDeFichier() {

    }

    /*
        Getters et Setters
     */

    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    public Acteur getActeur(String nomActeurDestination) {
        for(Acteur acteur : acteurs) {
            if(acteur.getNomAct().equals(nomActeurDestination)) {
                return acteur;
            }
        }

        return null;
    }
}
