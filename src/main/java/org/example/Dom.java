package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Dom implements Zanieczyszczacze{

    public static final ArrayList<ImageIcon> obrazki = new ArrayList<ImageIcon>(Arrays.asList(
            new ImageIcon("Sprity/dom_1.png"),
            new ImageIcon("Sprity/dom_2.png")
    )
    );
    static float wspolczynnikZanieczyszczenia = 0.002f; //Zanieczyszczenie Na Sekunde
    @Override
    public float Zanieczyszczenie(){

        return wspolczynnikZanieczyszczenia;
    }

}