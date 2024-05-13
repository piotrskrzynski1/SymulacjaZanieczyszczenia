package org.example.Okienko;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class PanelIndivSlider extends JPanel {
    private final JSlider slider;
    PanelIndivSlider(int valuebegin,int valueend,String tekst, boolean procent, int minimumJump) {
        slider = new JSlider(valuebegin,valueend);
        slider.setMajorTickSpacing(minimumJump);
        slider.setSnapToTicks(true);
        slider.setExtent(minimumJump);
        JLabel sliderText = new JLabel();
        Font font = new Font("IMPACT", Font.PLAIN, 13); // Example font
        sliderText.setFont(font);
        sliderText.setText(tekst + slider.getValue() + (procent ? "%" : ""));
        slider.addChangeListener((e)->{
            int value = slider.getValue();
            sliderText.setText(tekst + value + (procent ? "%" : ""));
        });
        sliderText.setForeground(Color.black);
        sliderText.setBounds(slider.getX(),slider.getY()-25,getWidth(),getHeight());
        sliderText.setVerticalAlignment(JLabel.CENTER);
        sliderText.setVerticalTextPosition(JLabel.BOTTOM);
        this.setLayout(new BorderLayout());
        add(slider,BorderLayout.CENTER);
        add(sliderText,BorderLayout.SOUTH);

    }

    public int GetValue(){
        return this.slider.getValue();
    }

}
