package gui;

import model.Acteur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.*;

/**
 * Created by azman on 09/06/2014.
 */
public class PanelGui extends JPanel{

    /*private JTextArea text = new JTextArea();

    public PanelGui() {
        setLayout(new FlowLayout());
        text.setPreferredSize(new Dimension(400, 700));
        text.setLineWrap(true);
        add(new JScrollPane(text));
    }*/

    public PanelGui(){

        //private ActionListener listener;

        //JPanel p = new JPanel();

        // by doing this, we prevent Swing from resizing
        // our nice component
        setLayout(null);
        //this.setLayout(null);

        ImageIcon icon = null;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/router.jpg"));
            icon = new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can't find the file!");
        }



        MyDraggableComponent acteur = new MyDraggableComponent(icon);
        add(acteur);

        setPreferredSize(new Dimension(400, 700));

        //p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
