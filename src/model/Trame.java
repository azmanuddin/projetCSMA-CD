package model;

/**
 * Created by akmal on 6/7/14.
 */
public class Trame {
    private double taille;
    private int id;
    private double tempsTrans;
    private double tempsEnvoie;
    private int nbTentatives;
    private Acteur source;
    private Acteur destination;

    public Trame(double taille, Acteur source, Acteur destination) {
        this.taille = taille;
        this.source = source;
        this.destination = destination;
        this.nbTentatives = 0;
    }

    public Trame setId(int id) {
        this.id = id;
        return this;
    }

    public Trame setTempsTrans( double tempsTrans) {
        this.tempsTrans = tempsTrans;
        return this;
    }

    /*
        Cette méthode doit être appllée avant d'envoyer une trame sur un support.
        Lorsqu'on set le tempsEnvoie, on incrémente aussi le nbTentative;
     */
    public Trame setTempsEnvoie( double tempsEnvoie) {
        this.tempsEnvoie = tempsEnvoie;
        nbTentatives ++;
        return this;
    }

    public int getId() {
        return id;
    }

    public  double getTempsTrans() {
        return tempsTrans;
    }

    public double getTaille() {
        return taille;
    }

    public int getNbTentatives() { return nbTentatives; }
}
