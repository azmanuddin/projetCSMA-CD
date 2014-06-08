/**
 * Created by akmal on 6/7/14.
 */
public class Trame {
    private double taille;
    private int id;
    private double tempsTrans;
    private Acteur source;
    private Acteur destination;

    public Trame(double taille, Acteur source, Acteur destination) {
        this.taille = taille;
        this.source = source;
        this.destination = destination;
    }

    public Trame setId(int id) {
        this.id = id;
        return this;
    }

    public Trame setTempsTrans( double tempsTrans) {
        this.tempsTrans = tempsTrans;
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
}
