/**
 * Created by akmal on 6/7/14.
 */
public class TestActeur {

    public static void main(String args[]) {

        Acteur a = new Acteur("A");
        Support s1 = new Support("Cable1",12500,123);
        Interconnecteur c1 = new Interconnecteur("Commutateur1",45000000);

        a.setSupport(s1);
        c1.ajouterSupport(s1);

        a.envoyerFichier(2,null);

        System.out.println(a.getTrames().size());

        for (Trame t : a.getTrames()) {
            System.out.println(a.getNomAct() + t.getId() + " " + t.getTaille() + "octet(s)" + " avec le temps de transmission de "
            + t.getTempsTrans() + "s");
        }

        System.out.println(a.getNomAct() + " est connecté avec " + s1.getNomSupport() + " étant connecté avec " + c1.getNomConnecteur());


        //endoks

        System.out.println("Nom cable = "+ s1.getNomSupport()+"  Debit = "+s1.getDebit()+ "  Longeur = "+s1.getLongueur()+"metere");


        System.out.println(a.getRandomNum());
    }
}
