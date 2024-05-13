package org.example;

import java.util.ArrayList;

public class Symulacja {
    private boolean initialized = false;
    public int iloscSektorow = 0; //sektory ustawiamy w jframe na poczatku

    ArrayList<Sektor> sektory = new ArrayList<Sektor>(); //sektory są od lewej do prawej

    Runtime time = Runtime.getRuntime(); //czas od rozpoczecia

    private int iloscAut = 0;
    private int iloscFabryk = 0;
    private int iloscDomow = 0;
    private int iloscBiurowcow = 0;
    private int iloscDrzew = 0;
    private float szansaNaDeszcz = 0; // miedzy 0% a 100% 100%=1  50%=0.5f   25%=0.25f
    private static int dlugoscsymulacji = 1000; //ilosc klatek do symulacji
    private static float dlugoscKlatki = 1.0f; //sekundy ile ma trwac animacja "miedzyklatkowa"

    public void InicjalizacjaSektorow(){
        if(!initialized) {
            for (int i = 0; i < iloscSektorow; i++) {
                sektory.add(new Sektor());
            }
        }
    }

    //gettery i settery zignorować bo to syf \/\/\/\/
    public int GetAuta(){
        return iloscAut;
    }
    public void SetAuta(int ilosc){
        this.iloscAut = ilosc;
    }
    public int GetFabryki(){
        return iloscFabryk;
    }
    public void SetFabryki(int ilosc){
        this.iloscFabryk = ilosc;
    }
    public int GetDomy(){
        return iloscDomow;
    }
    public void SetDomy(int ilosc){
        this.iloscDomow = ilosc;
    }
    public int GetBiurowce(){
        return iloscBiurowcow;
    }
    public void SetBiurowce(int ilosc){
        this.iloscBiurowcow = ilosc;
    }
    public int GetDrzewa(){
        return iloscDrzew;
    }
    public void SetDrzewa(int ilosc){
        this.iloscDrzew = ilosc;
    }
    public float GetSzansaNaDeszcz(){
        return szansaNaDeszcz;
    }
    public void SetSzansaNaDeszcz(float ilosc){
        this.szansaNaDeszcz = ilosc;
    }
    public int GetIloscSektorow(){
        return iloscSektorow;
    }
    public void SetIloscSektorow(int ilosc){
        this.iloscSektorow = ilosc;
    }
    public ArrayList<Sektor> GetSektory(){
        return sektory;
    }
    public int GetDlugoscSymulacji(){
        return dlugoscsymulacji;
    }
    public void SetDlugoscSymulacji(int ilosc){
        this.dlugoscsymulacji = ilosc;
    }
    public float GetDlugoscKlatki(){
        return dlugoscKlatki;
    }
    public void SetDlugoscKlatki(int ilosc){
        this.dlugoscKlatki = ilosc;
    }
}
