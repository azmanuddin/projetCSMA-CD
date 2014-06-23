package model;

import ayam.AyamListener;
import gui.ReseauListener;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */
public class Reseau {

    private ArrayList<Acteur> acteurs;
    private Interconnecteur interconnecteur;
    private ArrayList<Support> supports;

    private ReseauListener listener;
    private AyamListener pendengar;

    /*
        Constructeurs
     */

    public Reseau() {
        interconnecteur = new Interconnecteur();
        acteurs = new ArrayList<Acteur>();
    }

    /*
        Méthodes publiques
     */
    public void setDebitInterconnecteur(long debit) {
        interconnecteur.setDebit(debit);
        listener.onEvent("Le débit de l'interconnecteur est " + debit);
    }

    public Acteur ajouterActeur(String nom) {
        Acteur acteur = new Acteur(nom);
        acteurs.add(acteur);
        acteur.setListener(listener);
        listener.onEvent("L'acteur " + nom + " a été créé");
        return acteur;
    }

    public void ajouterConnexion(Acteur acteur, JComboBox nomSupport, long debit, long longueur) {
        Support support = new Support(nomSupport, debit, longueur);
        acteurs.get(acteurs.indexOf(acteur)).setSupport(support);
        interconnecteur.ajouterSupport(support);

        String message = "Une connexion est établie entre l'acteur "
                        + acteur.getNomAct() + " et l'interconnecteur "
                        + "par le support " + nomSupport + " de débit "
                        + debit + " et de longueur " + longueur;
        System.out.println(message);

        listener.onEvent(message);
        pendengar.berkokok();
    }

    /*
        Programme l'envoie d'un fichier d'une taille donnée depuis un acteur source vers un acteur destination
        à un moment donné.
     */
    public void programmerEnvoieDeFichier(Acteur source, Acteur destination, int tailleFichier, double moment) {
        source.decouperFichier(tailleFichier, destination);
        source.setTempsEnvoie(moment);
        String message =  "Envoie de fichier de taille " + tailleFichier + "Koctet(s) depuis l'acteur "+ source.getNomAct()
                        + " à l'acteur " + destination.getNomAct() + " à t = " + moment +" a été programmé";
        System.out.println(message);
        for (Trame t : source.getTrames()) {
            String message2 = source.getNomAct() + t.getId() + " " + t.getTaille() + "octet(s)" + " avec le temps de transmission de "
                    + t.getTempsTrans() + "s";
            System.out.println(message2);
            listener.onEvent(message2);
        }

        listener.onEvent(message);

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

    public void setListener(ReseauListener listener) {
        this.listener = listener;
    }

    public void setPendengar(AyamListener pendengar) {
        this.pendengar = pendengar;
    }
}
