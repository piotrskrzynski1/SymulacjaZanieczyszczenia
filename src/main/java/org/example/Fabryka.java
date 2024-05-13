package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Fabryka implements Zanieczyszczacze {

    public static final ArrayList<ImageIcon> obrazki = new ArrayList<ImageIcon>(Arrays.asList(
            new ImageIcon("Sprity/fabryka_1.png")
    )
    );
    private float liczbaMaszyn = generateRandomNumber(10,150);
    private static float wspolczynnikZanieczyszczenia = 0.1f;
    @Override
    public float Zanieczyszczenie(){
        return wspolczynnikZanieczyszczenia*liczbaMaszyn;
    }

    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
