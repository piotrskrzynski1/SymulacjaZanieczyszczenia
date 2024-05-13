package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Pojazd implements Zanieczyszczacze {

    public static final ArrayList<ImageIcon> obrazki = new ArrayList<ImageIcon>(Arrays.asList(
            new ImageIcon("Sprity/samochod_1.png"),
            new ImageIcon("Sprity/samochod_2.png"),
            new ImageIcon("Sprity/samochod_3.png"),
            new ImageIcon("Sprity/samochod_4.png")
    )
    );
    private static float wspolczynnikZanieczyszczenia = 0.001f;
    //pojazd porusza
    @Override
    public float Zanieczyszczenie(){
        return wspolczynnikZanieczyszczenia;
    }
}
