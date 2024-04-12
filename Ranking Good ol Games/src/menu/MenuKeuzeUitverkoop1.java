package menu;

import model.Game;
import model.Uitverkoop;
import utils.DataSeeder;

import java.util.ArrayList;

public class MenuKeuzeUitverkoop1 extends MenuKeuze{

    public MenuKeuzeUitverkoop1(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }


    @Override
    public void voerActieUit(){
        // vraag de uitverkooplijst op en toon deze
        Uitverkoop uitverkoop = new Uitverkoop();
        uitverkoop.toonUitverkooplijst();
    }
}
