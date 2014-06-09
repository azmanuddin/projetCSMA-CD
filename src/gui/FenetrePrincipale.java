package gui;

import ayam.AyamBetul;
import ayam.AyamListener;
import main.Simulation;
import model.Acteur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by Hakim on 09/06/14.
 */
public class FenetrePrincipale extends JFrame implements ActionListener {
    private Simulation simulation;
    private PanelControle controle = new PanelControle(this);
    private PanelConsole console = new PanelConsole();

    private PanelGui gui = new PanelGui();
    private AyamBetul ayam = new AyamBetul();


    public FenetrePrincipale(Simulation simulation) {
        super("Simulation CSMA/CD");
        this.simulation = simulation;
        simulation.getReseau().setListener(console);    //utk ambik maklumat reseau ke dalamconsole
        simulation.getReseau().setPendengar(ayam);


        setLayout(new BorderLayout());

        add(controle, BorderLayout.WEST);
        add(console, BorderLayout.CENTER);
        add(gui, BorderLayout.EAST);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);       //supprimer les donnes enregistré
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(controle.ajouterActeurButton)) {
            ajouterActeur();
            gui.add(new MyDraggableComponent(null));
        }

        else if(e.getSource().equals(controle.ajouterSupportButton)) {
            ajouterSupport();

        }

        else if(e.getSource().equals(controle.setDebitInterconnecteurButton)) {
            setDebitInterconnecteur();
        }

        else if(e.getSource().equals(controle.programmerEnvoieButton)) {
            programmerEnvoie();
        }

        else if(e.getSource().equals(controle.lancerSimulationButton)) {
            lancerSimulation();
        }
    }

    private void lancerSimulation() {
        JOptionPane.showMessageDialog(this, "Cette fonctionnalité n'est pas encore implémentée", "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    private void ajouterActeur() {
        String nomActeur = controle.nomActeurText.getText();
        if(!nomActeur.equals("")) {
            simulation.getReseau().ajouterActeur(nomActeur);
        }
        else {
            JOptionPane.showMessageDialog(this, "Le nom d'acteur ne peut pas être vide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void ajouterSupport() {
        String nomActeur = controle.nomActeurConnecteText.getText();
        String nomSupport = controle.nomSupportText.getText();
        String textDebit = controle.debitSupportText.getText();
        String textLongueur = controle.longueurText.getText();
        if(!textDebit.equals("") && !textLongueur.equals("")) {
            long debit = Long.valueOf(textDebit);
            long longueur = Long.valueOf(textLongueur);
            Acteur acteur = simulation.getReseau().getActeur(nomActeur);
            if( acteur != null) {
                if(nomSupport != null) {
                    simulation.getReseau().ajouterConnexion(acteur, nomSupport, debit, longueur);
                }
                else {
                    JOptionPane.showMessageDialog(this, "Le nom du support ne peut pas être vide", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Il n'existe pas d'acteur avec le nom donné", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Le débit et la longueur ne peuvent pas être vide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void setDebitInterconnecteur() {
        String textDebit = controle.debitInterconnecteurText.getText();
        if(!textDebit.equals("")) {
            long debit = Long.valueOf(textDebit);
            simulation.getReseau().setDebitInterconnecteur(debit);
        }
    }

    private void programmerEnvoie() {
        String nomActeurSource = controle.sourceText.getText();
        String nomActeurDestination = controle.destinationText.getText();
        String textTailleFichier = controle.tailleFichierText.getText();
        String textMoment = controle.momentText.getText();

        Acteur source = simulation.getReseau().getActeur(nomActeurSource);
        Acteur destination = simulation.getReseau().getActeur(nomActeurDestination);

        if(source != null && destination != null) {
            if(!textTailleFichier.equals("") && !textMoment.equals("")) {
                int tailleFichier = Integer.valueOf(textTailleFichier);
                double moment = Double.valueOf(textMoment);

                simulation.getReseau().programmerEnvoieDeFichier(source, destination, tailleFichier, moment);
            }
            else {
                JOptionPane.showMessageDialog(this, "Impossible d'envoyer un fichier de taille null", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        else {
            JOptionPane.showMessageDialog(this, "La source et la destination ne peuvent pas être vides", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

}