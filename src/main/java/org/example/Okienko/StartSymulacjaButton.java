package org.example.Okienko;

import org.example.OkienkoSymulacja.SymulacjaWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StartSymulacjaButton extends JButton {
    boolean simInProgress = false;
    StartSymulacjaButton(){
        this.setText("Rozpocznij Symulacje");
        this.setPreferredSize(new Dimension(getWidth(),75));
        this.setFocusable(false);
    }


}
