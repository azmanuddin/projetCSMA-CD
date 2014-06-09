package gui;

/**
 * Created by azman on 09/06/2014.
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MyDraggableComponent
        extends JLabel {

    private volatile int screenX = 0;
    private volatile int screenY = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;

    public MyDraggableComponent(Icon icon) {
        setBounds(0, 0, 100, 100);
        setOpaque(false);

        if(icon == null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("images/acteur.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            icon = new ImageIcon(img);
        }

        setIcon(icon);

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) { }

            @Override
            public void mousePressed(MouseEvent e) {
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();

                myX = getX();
                myY = getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }

        });
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getXOnScreen() - screenX;
                int deltaY = e.getYOnScreen() - screenY;

                setLocation(myX + deltaX, myY + deltaY);
            }

            @Override
            public void mouseMoved(MouseEvent e) { }

        });
    }

}