package org.javapa;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JTextField tType;
    JTextField tName;
    JButton b;
    JLabel l;
    JButton instantiateButton;
    JLabel type;
    JLabel name;

    public void init(){
        this.setLayout(new FlowLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = ((int) screenSize.getWidth());
        int height = (int)screenSize.getHeight();
        setPreferredSize(new Dimension(width/2, height/10));

        tType = new JTextField(20);
        tName = new JTextField(20);
        type = new JLabel("Class");
        name = new JLabel("Name");
        instantiateButton = new JButton("Instantiate");
        add(name);
        add(tName);
        add(type);
        add(tType);
        add(instantiateButton);
        instantiateButton.addActionListener(this::instantiate);
    }

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void instantiate(ActionEvent e) {
        try {
            String name = this.tName.getText();
            String type = this.tType.getText();

            Class definition = Class.forName(type);
            Component component = (Component) definition.newInstance();
            component.setPreferredSize(new Dimension(100, 50));

            if (component instanceof JLabel) {
                l = (JLabel) component;
                l.setText(name);
                this.frame.dPanel.add(l);
            }
            else if (component instanceof JButton) {
                b = (JButton) component;
                b.setText(name);
                this.frame.dPanel.add(b);
            } else {
                this.frame.dPanel.add(component);
            }
            this.repaint();
            this.revalidate();

            this.frame.dPanel.revalidate();
            this.frame.dPanel.repaint();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException ex) {
            System.out.println(ex);
        }
    }
}
