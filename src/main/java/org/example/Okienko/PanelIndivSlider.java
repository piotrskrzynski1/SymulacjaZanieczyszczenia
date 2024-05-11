package org.example.Okienko;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class PanelIndivSlider extends JPanel {
    PanelIndivSlider(int valuebegin,int valueend,String tekst, boolean procent) {
        JSlider sliderCar = new JSlider(valuebegin,valueend);
        JLabel sliderCarText = new JLabel();
        Font font = new Font("IMPACT", Font.PLAIN, 13); // Example font
        sliderCarText.setFont(font);
        sliderCarText.setText(tekst + sliderCar.getValue() + (procent ? "%" : ""));
        sliderCar.addChangeListener((e)->{
            int value = sliderCar.getValue();
            sliderCarText.setText(tekst + value + (procent ? "%" : ""));
        });
        sliderCarText.setForeground(Color.black);
        sliderCarText.setBounds(sliderCar.getX(),sliderCar.getY()-25,getWidth(),getHeight());
        sliderCarText.setVerticalAlignment(JLabel.CENTER);
        sliderCarText.setVerticalTextPosition(JLabel.BOTTOM);
        this.setLayout(new BorderLayout());
        add(sliderCar,BorderLayout.CENTER);
        add(sliderCarText,BorderLayout.SOUTH);

    }

}
