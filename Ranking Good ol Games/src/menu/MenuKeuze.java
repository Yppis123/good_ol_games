package menu;

import java.util.Scanner;

public abstract class MenuKeuze {

    Scanner scanner = new Scanner(System.in);

    private int keuzeNummer;
    private String keuzeOmschrijving;

    MenuKeuze(int keuzeNummer, String keuzeOmschrijving){
        this.keuzeNummer = keuzeNummer;
        this.keuzeOmschrijving = keuzeOmschrijving;
    }

    public int getKeuzeNummer(){
        return keuzeNummer;
    }

    public void toonMenuKeuze() {
        System.out.println(keuzeNummer + ". " + keuzeOmschrijving);
    }

    public void voerActieUit() {

    }


}