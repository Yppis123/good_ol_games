package menu;

public class MenuKeuzeExit extends MenuKeuze{

    public MenuKeuzeExit(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }


    public void voerActieUit(){
        System.out.println("Het systeem is succesvol afgesloten!");
        System.exit(0);
    }

}
