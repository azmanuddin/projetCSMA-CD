package model;

import gui.ReseauListener;

import java.util.ArrayList;

/**
 * Created by akmal on 6/7/14.
 */



public class Acteur {
    private String nomAct;
    private int kOctets = 1024;
    private static final int tailleDonneesDeControle = 18;
    private double tempsEnvoie;
    private ArrayList<Trame> trames;
    private Support support;
    private ReseauListener listener;

    public Acteur(String nomAct) {
        this.nomAct = nomAct;
        trames = new ArrayList<Trame>();
        System.out.println("L'acteur " + nomAct + " a été créé");
    }

    /*
        Calcul le découpage d'un fichier en plusieurs trames à envoyer.
     */
    public int decouperFichier(int tailleFichier, Acteur destination) {

        tailleFichier = tailleFichier * kOctets;
        int nbTrames;

        if (tailleFichier > 1500) {
            int nbTramesPleins = tailleFichier / 1500;
            double tTrans;
            double tTransReste;
            nbTrames = nbTramesPleins;
            int reste = tailleFichier % 1500;

            int i;
            for (i = 1; i < (1 + nbTramesPleins); i++) {
                tTrans = ((1500 + tailleDonneesDeControle) * 8 / (double) support.getDebit());
                trames.add(new Trame(1500 + tailleDonneesDeControle, this, destination).setTempsTrans(tTrans).setId(i));

            }

            if (reste > 0) {
                nbTrames++;
                if (reste < 46) reste = 46;
                tTransReste = ((reste + tailleDonneesDeControle) * 8 / (double) support.getDebit());
                trames.add(new Trame(reste + tailleDonneesDeControle, this, destination).setTempsTrans(tTransReste).setId(i++));
            }

            listener.onEvent("L'acteur " + nomAct + " va envoyer " + nbTrames + " trames, dont " + nbTramesPleins
                            +" trames pleins à l'acteur " + destination.nomAct );
        }

        else {
            nbTrames = 1;
            if (tailleFichier < 46) tailleFichier = 46;
            double tTrans = ((tailleFichier + tailleDonneesDeControle) * 8 / (double) support.getDebit());
            trames.add(new Trame(tailleFichier + tailleDonneesDeControle, this, destination).setTempsTrans(tTrans).setId(1));
        }

        return nbTrames;
    }

    /*
        Envoie le nième trame sur le support. Retourne "true" s'il y a collision. Retourne "false" sinon
     */
    public boolean envoyerTrame(int n, double tempsEnvoie) {
        support.accepterTrame(trames.get(n).setTempsEnvoie(tempsEnvoie));
        return false;
    }
    /*
        Getters and setters
     */
    public ArrayList<Trame> getTrames() {
        return trames;
    }

    public String getNomAct() { return nomAct; }

    public void setTempsEnvoie(double tempsEnvoie) { this.tempsEnvoie = tempsEnvoie; }

    public void setSupport(Support support){ this.support = support; }

    public void setListener(ReseauListener listener) { this.listener = listener; }
}


