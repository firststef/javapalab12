package org.javapa;

import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    static int width, height;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = ((int) screenSize.getWidth());
        height = (int)screenSize.getHeight();
        setPreferredSize(new Dimension(width/2, height - height/10));
    }
}
