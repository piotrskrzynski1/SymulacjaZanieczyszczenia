package org.example;

public class Dom implements Zanieczyszczacze{
    float ZNS = 20f; //Zanieczyszczenie Na Sekunde
    float iloscObiektow; //ile ma byc na mapie (1 obiekt sklada sie np z 50 domow,pojazdow itp)
    int aktualnySektor; //aktualny sektor, sektory ustawiamy w symulacji
    @Override
    public void Zanieczyszczenie(){
        System.out.println("siema");
    }

}