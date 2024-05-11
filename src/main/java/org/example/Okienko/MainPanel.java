package org.example.Okienko;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    Image tlo;
    MainPanel(){

        this.setPreferredSize(new Dimension(900,506));
        this.setLayout(new BorderLayout());
        //tytul
        JLabel Tekstmenu = new JLabel();
        Tekstmenu.setText("Menu symulacji");
        Tekstmenu.setHorizontalAlignment(JLabel.CENTER);
        Tekstmenu.setForeground(Color.white);
        Tekstmenu.setFont(new Font("Impact",Font.BOLD,50));
        this.add(Tekstmenu,BorderLayout.NORTH);
        //panel opcji
        JPanel opcje = new JPanel() {  //sory że tak dziwnie ale nie chce mi sie osobnej klasy robic xd
            @Override
            protected void paintComponent(Graphics g) {
                // Fill with a transparent color
                g.setColor(new Color(27, 27, 27, 50)); // zmieniam tlo na przezroczyste
                g.fillRect(25, 0, getWidth()-50, getHeight()-25);
                super.paintComponent(g);
            }
        };
        opcje.setOpaque(false);
        opcje.setLayout(new FlowLayout());
        //opcja pojazdow
        PanelIndivSlider sliderAut = new PanelIndivSlider(0,10000,"Liczba aut: ",false);
        //opcja domów
        PanelIndivSlider sliderDomow = new PanelIndivSlider(0,10000,"Liczba domow: ",false);
        //opcja fabryk
        PanelIndivSlider sliderFabryk = new PanelIndivSlider(0,10000,"Liczba fabryk: ",false);
        //opcja biurowców
        PanelIndivSlider sliderBiurowcow = new PanelIndivSlider(0,10000,"Liczba biurowcow: ",false);
        //opcja drzew
        PanelIndivSlider sliderDrzew = new PanelIndivSlider(0,10000,"Liczba drzew: ",false);
        //opcja szansy na deszcz
        PanelIndivSlider sliderSzansanadeszcz = new PanelIndivSlider(0,100,"Szansa na deszcz: ",true);
        //guzik rozpoczecia
        StartSymulacjaButton startButton = new StartSymulacjaButton();

        opcje.add(sliderAut);
        opcje.add(sliderDomow);
        opcje.add(sliderFabryk);
        opcje.add(sliderBiurowcow);
        opcje.add(sliderDrzew);
        opcje.add(sliderSzansanadeszcz);
        this.add(startButton,BorderLayout.SOUTH);


        //dodaje panel opcji
        this.add(opcje);
        //tlo
        tlo = new ImageIcon("menu.jpg").getImage();
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        if (tlo!=null) {
            g2d.drawImage(tlo, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
