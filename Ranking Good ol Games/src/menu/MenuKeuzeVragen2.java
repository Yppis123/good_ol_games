package menu;

import model.Vragenlijst;

public class MenuKeuzeVragen2 extends MenuKeuze{

    public MenuKeuzeVragen2(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit(){
        Vragenlijst.nieuwenvraag();
    }

}
