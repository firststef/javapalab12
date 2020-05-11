package org.javapa;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel cPanel;
    DesignPanel dPanel;

    public MainFrame() {
        super("Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cPanel = new ControlPanel(this);
        dPanel = new DesignPanel(this);
        add(cPanel, BorderLayout.NORTH);
        add(dPanel, BorderLayout.CENTER);
        pack();
    }
}
