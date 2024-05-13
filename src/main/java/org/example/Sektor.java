package org.example;

import org.example.OkienkoSymulacja.PanelSymulacji;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sektor {


    private static List<Integer> values = Arrays.asList(0, 1, 2);

    public int[] kolejnosc = new int[3];
    //- //0 = biurowiec
    //  //1 = dom
    //  //2 = fabryka
    // losujemy kolejnosc czyli czy domy beda najwyzej czy biurowce czy fabryki i potem schodzimy w dol (wprowadzamy roznorodnosc)

    public PanelSymulacji panel;

    Sektor(){
        Collections.shuffle(values);
        for (int i = 0; i < kolejnosc.length; i++){
            kolejnosc[i] = values.get(i);
        }
    }
    static final float[] pozycjeY = {
            782,
            810,
            854
    }; //pozycje ktore pomagaja ustawic obrazki, wartosci potem ustalam

    private float zanieczyszczenie = 0; //mierzone w mikro gram/metr^3



    public float GetZanieczyszczenie(){
        return zanieczyszczenie;
    }

    public void DodajZanieczyszczenie(float liczba) {
        zanieczyszczenie += liczba;
    }
    public String GetZanieczyszczenieStan(){
        if(zanieczyszczenie <= 13)
        {
            return "BARDZO DOBRY";
        }
        else if(zanieczyszczenie > 13f && zanieczyszczenie <= 35f)
        {
            return "DOBRY";
        }
        else if(zanieczyszczenie > 35f && zanieczyszczenie <= 55f)
        {
            return "UMIARKOWANY";
        }
        else if(zanieczyszczenie > 55f && zanieczyszczenie <= 75f)
        {
            return "DOSTATECZNY";
        }
        else if(zanieczyszczenie > 75f && zanieczyszczenie <= 110f)
        {
            return "ZLY";
        }
        else if(zanieczyszczenie > 110f)
        {
            return "BARDZO ZLY";
        } else return "ERROR";
    }
}
