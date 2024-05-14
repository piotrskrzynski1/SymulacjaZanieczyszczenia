package org.example.OkienkoSymulacja;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PanelSymulacji extends JPanel {
    public JPanel kingPanel;

    public ImageIcon poz1image;

    public ImageIcon poz2image;

    public ImageIcon poz3image;

    Random random = new Random();

    int randomvalue1 = 0;
    int randomOffset1 = 0;
    int randomvalue2 = 0;
    int randomOffset2 = 0;
    int randomvalue3 = 0;
    int randomOffset3 = 0;


    PanelSymulacji() {
        kingPanel = new JPanel(new GridLayout(1,0));
        kingPanel.setOpaque(false);
        setLayout(new FlowLayout());
    }

    double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public void CalculateRandomOffset(){ //kalkuluje offset na osi x zeby przemiescic budynki
        if (poz1image != null && poz2image != null && poz3image != null) {
            int maxWidth = getWidth();
            int widthimg1 = (int)clamp(this.getWidth(),1,poz1image.getIconWidth());
            int widthimg2 = (int)clamp(this.getWidth(),1,poz2image.getIconWidth());
            int widthimg3 = (int)clamp(this.getWidth(),1,poz3image.getIconWidth());

            randomvalue1 = Math.max(1, (int) Math.ceil((double) maxWidth / widthimg1));
            randomvalue2 = Math.max(1, (int) Math.ceil((double) maxWidth / widthimg2));
            randomvalue3 = Math.max(1, (int) Math.ceil((double) maxWidth / widthimg3));

            randomOffset1 = random.nextInt(randomvalue1) * widthimg1;
            randomOffset2 = random.nextInt(randomvalue2) * widthimg2;
            randomOffset3 = random.nextInt(randomvalue3) * widthimg3;
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (poz1image != null && randomvalue1!=0){
            int heighwidthratioimg1 = poz1image.getIconHeight()/ poz1image.getIconWidth();
            int heighwidthratioimg2 = poz2image.getIconHeight()/ poz2image.getIconWidth();
            int heighwidthratioimg3 = poz3image.getIconHeight()/ poz3image.getIconWidth();
            int widthimg1 = (int)clamp(this.getWidth(),1,poz1image.getIconWidth());
            int widthimg2 = (int)clamp(this.getWidth(),1,poz2image.getIconWidth());
            int widthimg3 = (int)clamp(this.getWidth(),1,poz3image.getIconWidth());

            g.drawImage(poz1image.getImage(), (this.getWidth()/2-widthimg1/2), 400+(poz1image.getIconHeight()-(int)widthimg1*heighwidthratioimg1), (int)widthimg1,(int)widthimg1*heighwidthratioimg1 , this);
            g.drawImage(poz2image.getImage(), (this.getWidth()/2-widthimg2/2), 410+(poz1image.getIconHeight()-(int)widthimg2*heighwidthratioimg2), (int)widthimg2,(int)widthimg2*heighwidthratioimg2  , this);
            g.drawImage(poz3image.getImage(), (this.getWidth()/2-widthimg3/2), 425+(poz1image.getIconHeight()-(int)widthimg3*heighwidthratioimg3), (int)widthimg3,(int)widthimg3*heighwidthratioimg3  , this);
        }
    }

}
