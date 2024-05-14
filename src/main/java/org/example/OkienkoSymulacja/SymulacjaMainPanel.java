package org.example.OkienkoSymulacja;

import javax.swing.*;
import java.awt.*;

public class SymulacjaMainPanel extends JPanel {
    Image tlo;
    public int sektory;
    SymulacjaMainPanel(){
        tlo = new ImageIcon("sprity/tlosymulacji.gif").getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        if(sektory == 0){return;}
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        if (tlo!=null){
            g2d.drawImage(tlo,0,0,getWidth(),getHeight(),this);
        }
    }
}
