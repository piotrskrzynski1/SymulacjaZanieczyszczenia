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
import javax.swing.JOptionPane;
import javax.swing.border.Border;


public class SymulacjaWindow extends JFrame {

    static Map<Integer,Class<?>> mapa = new HashMap<>();
    static {
        mapa.put(0, Biurowiec.class);
        mapa.put(1, Dom.class);
        mapa.put(2, Fabryka.class);
    }
    public SymulacjaWindow(int auta,int domy, int fabryki, int biurowce, int drzewa, int sektory, int szansanadeszcz){

        //glowny panel
        SymulacjaMainPanel mainPanel = new SymulacjaMainPanel();
        //jframe
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(new Dimension(900,506));
        setResizable(true);
        ImageIcon ikona = new ImageIcon("sprity/menu/komin.png");
        setIconImage(ikona.getImage());
        mainPanel.setLayout(null);


        setTitle("Ongoing Simulation");
        add(mainPanel);

        centerFrame(this);

        setVisible(true);

        //Symulacja
        Symulacja symulacja = new Symulacja();
        symulacja.SetAuta(auta);
        symulacja.SetDomy(domy);
        symulacja.SetFabryki(fabryki);
        symulacja.SetBiurowce(biurowce);
        symulacja.SetDrzewa(drzewa);
        symulacja.SetIloscSektorow(sektory);
        symulacja.SetSzansaNaDeszcz(szansanadeszcz*0.01f);


        symulacja.InicjalizacjaSektorow();
        ArrayList<Sektor> sektorySymulacji = symulacja.GetSektory();
        for(int i = 0; i < symulacja.GetIloscSektorow();i++){
            sektorySymulacji.get(0).panel = new PanelSymulacji();
            mainPanel.add(sektorySymulacji.get(0).panel);
            //ustawiam bordery i przestrzenie paneli (ustawiam je tak zeby rzadkiem obejmowaly caly ekran)
            sektorySymulacji.get(0).panel.setBounds((getWidth()/symulacja.GetIloscSektorow())*i,0,getWidth()/symulacja.GetIloscSektorow(),getHeight());
            sektorySymulacji.get(0).panel.setBorder(BorderFactory.createBevelBorder(1)); //usun potem
            sektorySymulacji.get(0).panel.setOpaque(false); //przezroczysty panel jezeli false
            //ustawiam panele dla obrazkow budynkow
            int[] kolejnosc = sektorySymulacji.get(0).kolejnosc;
        }


    }
    public static void centerFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2)+25;
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2)+25;
        frame.setLocation(centerX, centerY);
    }

}
