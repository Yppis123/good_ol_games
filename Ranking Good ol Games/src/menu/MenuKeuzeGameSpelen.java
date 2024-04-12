package menu;


import model.Galgje;

public class MenuKeuzeGameSpelen extends MenuKeuze {

    public MenuKeuzeGameSpelen(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit(){
        Galgje galgje = new Galgje();
        galgje.speelGame();
    }

}
