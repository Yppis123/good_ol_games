package menu;

import model.Multiplechoice;
import model.Vragenlijst;

public class MenuKeuzeVragen1 extends MenuKeuze{

    public MenuKeuzeVragen1(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit(){
        Vragenlijst.steldvragen();
        Multiplechoice.vragenlijstAantonen();
    }

}
