package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Biurowiec implements Zanieczyszczacze{

    public static final ArrayList<ImageIcon> obrazki = new ArrayList<ImageIcon>(Arrays.asList(
            new ImageIcon("Sprity/biurowiec_1.png"),
            new ImageIcon("Sprity/biurowiec_1.png"),
            new ImageIcon("Sprity/biurowiec_1.png")
        )
    );

    private int pracownicy = generateRandomNumber(30,500);
    private static float wspolczynnikZanieczyszczeniaPerPerson = 0.0005f;
    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    private int GetPracownicy() {
        return pracownicy;
    }
    private void SetPracownicy(int ile){
        this.pracownicy = ile;
    }

    @Override
    public float Zanieczyszczenie(){
        return pracownicy*wspolczynnikZanieczyszczeniaPerPerson;
    }
}
