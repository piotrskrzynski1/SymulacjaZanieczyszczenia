package org.example.Okienko;

import org.example.OkienkoSymulacja.SymulacjaWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        //opcja sektorow
        PanelIndivSlider sliderSektorow = new PanelIndivSlider(1,35,"Liczba sektorow: ", false,2);
        //opcja pojazdow
        PanelIndivSlider sliderAut = new PanelIndivSlider(0,500000,"Liczba aut: ",false,1);
        //opcja domów
        PanelIndivSlider sliderDomow = new PanelIndivSlider(0,500000,"Liczba domow: ",false,1);
        //opcja fabryk
        PanelIndivSlider sliderFabryk = new PanelIndivSlider(0,100,"Liczba fabryk: ",false,1);
        //opcja biurowców
        PanelIndivSlider sliderBiurowcow = new PanelIndivSlider(0,5000,"Liczba biurowcow: ",false,1);
        //opcja drzew
        PanelIndivSlider sliderDrzew = new PanelIndivSlider(0,100000,"Liczba drzew: ",false,1);
        //opcja szansy na deszcz
        PanelIndivSlider sliderSzansanadeszcz = new PanelIndivSlider(0,100,"Szansa na deszcz: ",true,1);
        //guzik rozpoczecia
        StartSymulacjaButton startButton = new StartSymulacjaButton();
        //eventlistener ktory rozpoczyna symulacje po nacisnieciu guzika i przekazuje info
        startButton.addActionListener((e) -> {
            if(!startButton.simInProgress) {
                startButton.simInProgress = true;
                //STARTUJEMY SYMULACJE
                final SymulacjaWindow oknoSymulacji = new SymulacjaWindow(sliderAut.GetValue(),sliderDomow.GetValue(),sliderFabryk.GetValue(),sliderBiurowcow.GetValue(),sliderDrzew.GetValue(),sliderSektorow.GetValue(),sliderSzansanadeszcz.GetValue());
                oknoSymulacji.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        int result = JOptionPane.showConfirmDialog(startButton, "Napewno zakonczyc symulacje?", "Exit", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            oknoSymulacji.dispose(); // zamyka okno i pozwala rozpoczac nowa symulacje
                            startButton.simInProgress = false;
                        }
                    }
                });
            }
        });

        opcje.add(sliderSektorow);
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
        tlo = new ImageIcon("sprity/menu/menu.jpg").getImage();
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
