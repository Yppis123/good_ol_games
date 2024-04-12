package menu;

import model.Ranglijst;
import utils.DataSeeder;


public class MenuKeuzeRanglijst1 extends MenuKeuze {

    public MenuKeuzeRanglijst1(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit() {
        Ranglijst ranglijst = new Ranglijst();
        ranglijst.toonRanglijstOpGemGameScore();
    }

}
