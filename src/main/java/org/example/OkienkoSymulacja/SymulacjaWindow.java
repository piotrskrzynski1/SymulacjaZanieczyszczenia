package org.example.OkienkoSymulacja;

import org.example.Biurowiec;
import org.example.Dom;
import org.example.Fabryka;
import org.example.Sektor;
import org.example.Symulacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.border.Border;


public class SymulacjaWindow extends JFrame {

    public Symulacja symulacja;
    static Map<Integer,ArrayList<ImageIcon>> mapaObrazki = new HashMap<>();
    static {
        mapaObrazki.put(0, Biurowiec.obrazki);
        mapaObrazki.put(1, Dom.obrazki);
        mapaObrazki.put(2, Fabryka.obrazki);
    }
    public SymulacjaWindow(int auta,int domy, int fabryki, int biurowce, int drzewa, int sektory, int szansanadeszcz){

        Random random = new Random();

        // Generate a random integer between 1 and 3 (inclusive)


        //glowny panel
        SymulacjaMainPanel mainPanel = new SymulacjaMainPanel();

        //jframe
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(new Dimension(1024,640));
        setResizable(false);
        ImageIcon ikona = new ImageIcon("sprity/menu/komin.png");
        setIconImage(ikona.getImage());
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(getWidth(),getHeight()));


        setTitle("Ongoing Simulation");
        add(mainPanel);

        centerFrame(this);

        setVisible(true);

        //Symulacja
        symulacja = new Symulacja();
        symulacja.SetAuta(auta);
        symulacja.SetDomy(domy);
        symulacja.SetFabryki(fabryki);
        symulacja.SetBiurowce(biurowce);
        symulacja.SetDrzewa(drzewa);
        symulacja.SetIloscSektorow(sektory);
        symulacja.SetSzansaNaDeszcz(szansanadeszcz*0.01f);


        symulacja.InicjalizacjaSektorow();
        ArrayList<Sektor> sektorySymulacji = symulacja.GetSektory();

        //szybko tu wtrące sory
        mainPanel.sektory = symulacja.GetIloscSektorow();
        for(int i = 0; i < symulacja.GetIloscSektorow();i++){
            sektorySymulacji.get(i).panel = new PanelSymulacji();
            mainPanel.add(sektorySymulacji.get(i).panel);

            //ustawiam bordery i przestrzenie paneli (ustawiam je tak zeby rzadkiem obejmowaly caly ekran)
            sektorySymulacji.get(i).panel.setBounds((getWidth()/symulacja.GetIloscSektorow())*i,0,getWidth()/symulacja.GetIloscSektorow(),getHeight());
            //sektorySymulacji.get(i).panel.setBorder(BorderFactory.createBevelBorder(1)); //usun potem
            sektorySymulacji.get(i).panel.setOpaque(false); //przezroczysty panel jezeli false

            //ustawiam panele dla obrazkow budynkow
            int[] kolejnosc = sektorySymulacji.get(i).kolejnosc;
            sektorySymulacji.get(i).panel.poz1image = mapaObrazki.get(kolejnosc[0]).get(random.nextInt(mapaObrazki.get(kolejnosc[0]).size()));
            sektorySymulacji.get(i).panel.poz2image = mapaObrazki.get(kolejnosc[1]).get(random.nextInt(mapaObrazki.get(kolejnosc[1]).size()));
            sektorySymulacji.get(i).panel.poz3image = mapaObrazki.get(kolejnosc[2]).get(random.nextInt(mapaObrazki.get(kolejnosc[2]).size()));

            //kalkuluje offset zeby budynki byly troszke bardziej losowo rozlozone
            sektorySymulacji.get(i).panel.CalculateRandomOffset();

            //sektorySymulacji.get(i).panel.parentJLabel.setBounds(0,305,getWidth()/symulacja.GetIloscSektorow(),150);
            mainPanel.add(sektorySymulacji.get(i).panel);
        }


    }
    public static void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2)+25;
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2)+25;
        frame.setLocation(centerX, centerY);
    }


}
