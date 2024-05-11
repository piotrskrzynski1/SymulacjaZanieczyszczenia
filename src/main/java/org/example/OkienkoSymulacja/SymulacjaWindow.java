package org.example.OkienkoSymulacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class SymulacjaWindow extends JFrame {
    public SymulacjaWindow(){
        //glowny panel
        SymulacjaMainPanel mainPanel = new SymulacjaMainPanel();
        //jframe
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(new Dimension(900,506));
        setResizable(false);
        ImageIcon ikona = new ImageIcon("komin.png");
        setIconImage(ikona.getImage());


        setTitle("Ongoing Simulation");
        add(mainPanel);

        centerFrame(this);

        setVisible(true);
    }
    public static void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2)+25;
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2)+25;
        frame.setLocation(centerX, centerY);
    }

}
