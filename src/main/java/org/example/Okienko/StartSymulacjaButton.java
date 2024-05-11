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
        addActionListener((e) -> {
            if(!simInProgress) {
                simInProgress = true;
                final SymulacjaWindow oknoSymulacji = new SymulacjaWindow();
                oknoSymulacji.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                            int result = JOptionPane.showConfirmDialog(StartSymulacjaButton.this, "Napewno zakonczyc symulacje?", "Exit", JOptionPane.YES_NO_OPTION);
                            if (result == JOptionPane.YES_OPTION) {
                                oknoSymulacji.dispose(); // zamyka okno i pozwala rozpoczac nowa symulacje
                                simInProgress = false;
                            }
                    }
                });
            }
        });
    }


}
