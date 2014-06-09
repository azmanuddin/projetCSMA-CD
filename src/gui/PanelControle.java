package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Pack200;

/**
 * Created by Hakim on 09/06/14.
 */
public class PanelControle extends JPanel{

    private ActionListener listener;
    //region user interface components
    //region JLabel, JTextField et JButton pour l'ajout d'un acteur

    JLabel ajouterActeurLabel = new JLabel("Ajouter un acteur");
    JLabel nomActeurLabel = new JLabel("Nom de l'acteur");
    JTextField nomActeurText = new JTextField();
    JButton ajouterActeurButton = new JButton("Ajouter acteur");
    //endregion

    //region JLabel, JTextField et JButton pour l'ajout d'un support

    JLabel ajouterSupportLabel = new JLabel("Ajouter un support");
    JLabel nomSupportLabel = new JLabel("Nom du support");
    JTextField nomSupportText = new JTextField();
    JLabel nomActeurConnecteLabel = new JLabel("Nom de l'acteur connecté");
    JTextField nomActeurConnecteText = new JTextField();
    JLabel longueurLabel = new JLabel("Longueur du support");
    JTextField longueurText = new JTextField();
    JLabel debitSupportLabel = new JLabel("Débit du support");
    JTextField debitSupportText = new JTextField();
    JButton ajouterSupportButton = new JButton("Ajouter support");
    //endregion

    //region JLabel, JTextField et JButton pour définir le débit de l'interconnecteur

    JLabel definirDebitInterconnecteurLabel = new JLabel("Définir le débit de l'interconnecteur");
    JLabel debitInterconnecteurLabel = new JLabel("Débit interconnecteur");
    JTextField debitInterconnecteurText = new JTextField();
    JButton setDebitInterconnecteurButton = new JButton("Définir débit");
    //endregion

    //region JLabel, JTextField et JButton pour la programmation d'un envoie de fichier

    JLabel programmerEnvoieLabel = new JLabel("Programmer l'envoie d'un fichier");
    JLabel sourceLabel = new JLabel("Nom de l'acteur source");
    JTextField sourceText = new JTextField();
    JLabel destinationLabel = new JLabel("Nom de l'acteur destination");
    JTextField destinationText = new JTextField();
    JLabel tailleFichierLabel = new JLabel("Taille du fichier");
    JTextField tailleFichierText = new JTextField();
    JLabel momentLabel = new JLabel("Moment d'envoie");
    JTextField momentText = new JTextField();
    JButton programmerEnvoieButton = new JButton("Programmer l'envoie");
    //endregion
    //endregion

    public PanelControle(ActionListener listener){
        this.listener = listener;
        setLayout(new GridBagLayout());
        initialiserComposants();
    }

    private void initialiserComposants(){
        ajouterActeurButton.addActionListener(listener);
        ajouterSupportButton.addActionListener(listener);
        programmerEnvoieButton.addActionListener(listener);
        setDebitInterconnecteurButton.addActionListener(listener);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = 4;
        definirDebitInterconnecteurLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(definirDebitInterconnecteurLabel, gbc);

        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 2;
        add(debitInterconnecteurLabel, gbc);

        gbc.gridy = 1; gbc.gridx = 2; gbc.gridwidth = 2;
        debitInterconnecteurText.setColumns(15);
        add(debitInterconnecteurText, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 4;
        add(setDebitInterconnecteurButton, gbc);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 4; gbc.insets = new Insets(30, 0, 0, 0);
        ajouterActeurLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(ajouterActeurLabel, gbc);

        gbc.gridy = 5; gbc.gridx = 0; gbc.gridwidth = 2; gbc.insets = new Insets(0, 0, 0, 0);
        add(nomActeurLabel, gbc);

        gbc.gridy = 5; gbc.gridx = 2; gbc.gridwidth = 2;
        nomActeurText.setColumns(15);
        add(nomActeurText, gbc);

        gbc.gridy = 6; gbc.gridx = 0; gbc.gridwidth = 4;
        add(ajouterActeurButton, gbc);

        gbc.gridy = 8; gbc.gridx = 0; gbc.gridwidth = 4;  gbc.insets = new Insets(30, 0, 0, 0);
        ajouterSupportLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(ajouterSupportLabel, gbc);

        gbc.gridy = 9; gbc.gridx = 0; gbc.gridwidth = 2; gbc.insets = new Insets(0, 0, 0, 0);
        add(nomSupportLabel, gbc);

        gbc.gridy = 9; gbc.gridx = 2; gbc.gridwidth = 2;
        nomSupportText.setColumns(15);
        add(nomSupportText, gbc);

        gbc.gridy = 10; gbc.gridx = 0; gbc.gridwidth = 2;
        add(nomActeurConnecteLabel, gbc);

        gbc.gridy = 10; gbc.gridx = 2; gbc.gridwidth = 2;
        nomActeurConnecteText.setColumns(15);
        add(nomActeurConnecteText, gbc);

        gbc.gridy = 11; gbc.gridx = 0; gbc.gridwidth = 2;
        add(debitSupportLabel, gbc);

        gbc.gridy = 11; gbc.gridx = 2; gbc.gridwidth = 2;
        debitSupportText.setColumns(15);
        add(debitSupportText, gbc);

        gbc.gridy = 12; gbc.gridx = 0; gbc.gridwidth = 2;
        add(longueurLabel,gbc);

        gbc.gridy = 12; gbc.gridx = 2; gbc.gridwidth = 2;
        longueurText.setColumns(15);
        add(longueurText, gbc);

        gbc.gridy = 13; gbc.gridx = 0; gbc.gridwidth = 4;
        add(ajouterSupportButton, gbc);

        gbc.gridy = 15; gbc.gridx = 0; gbc.gridwidth = 4; gbc.insets = new Insets(30, 0, 0, 0);
        programmerEnvoieLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(programmerEnvoieLabel, gbc);

        gbc.gridy = 16; gbc.gridx = 0; gbc.gridwidth = 2; gbc.insets = new Insets(0, 0, 0, 0);
        add(sourceLabel, gbc);

        gbc.gridy = 16; gbc.gridx = 2; gbc.gridwidth = 2;
        sourceText.setColumns(15);
        add(sourceText, gbc);

        gbc.gridy = 17; gbc.gridx = 0; gbc.gridwidth = 2;
        add(destinationLabel, gbc);

        gbc.gridy = 17; gbc.gridx = 2; gbc.gridwidth = 2;
        destinationText.setColumns(15);
        add(destinationText, gbc);

        gbc.gridy = 18; gbc.gridx = 0; gbc.gridwidth = 2;
        add(tailleFichierLabel, gbc);

        gbc.gridy = 18; gbc.gridx = 2; gbc.gridwidth = 2;
        tailleFichierText.setColumns(15);
        add(tailleFichierText, gbc);

        gbc.gridy = 19; gbc.gridx = 0; gbc.gridwidth = 2;
        add(momentLabel, gbc);

        gbc.gridy = 19; gbc.gridx = 2; gbc.gridwidth = 2;
        momentText.setColumns(15);
        add(momentText, gbc);

        gbc.gridy = 20; gbc.gridx = 0; gbc.gridwidth = 4;
        add(programmerEnvoieButton, gbc);
    }
}
