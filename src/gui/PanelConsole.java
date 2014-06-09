package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Hakim on 09/06/14.
 */
public class PanelConsole extends JPanel implements ReseauListener{
    private JTextArea text = new JTextArea();

    public PanelConsole() {
        setLayout(new FlowLayout());
        text.setPreferredSize(new Dimension(400, 700));
        text.setLineWrap(true);
        add(new JScrollPane(text));
    }

    @Override
    public void onEvent(String message) {
        text.append(message + "\n\n");
    }
}
