package org.example;

public class Sektor {
    private float zanieczyszczenie = 0; //mierzone w mikro gram/metr^3

    public float GetZanieczyszczenie(){
        return zanieczyszczenie;
    }

    public void DodajZanieczyszczenie(float liczba) { zanieczyszczenie += liczba;}
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
