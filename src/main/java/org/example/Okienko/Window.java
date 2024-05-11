package org.example.Okienko;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        //glowny panel
        MainPanel mainPanel = new MainPanel();
        //jframe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(900,506));
        setResizable(false);
        ImageIcon ikona = new ImageIcon("komin.png");
        setIconImage(ikona.getImage());


        setTitle("Symulacja Zanieczyszczenia Powietrza");
        add(mainPanel);

        centerFrame(this);

        setVisible(true);
    }
    public static void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);
    }
}
