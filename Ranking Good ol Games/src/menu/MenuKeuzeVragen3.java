package menu;

import model.Multiplechoice;

public class MenuKeuzeVragen3 extends MenuKeuze{

    public MenuKeuzeVragen3(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit(){
        Multiplechoice.nieuwenMultiplechoice();
    }

}