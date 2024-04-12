package menu;

import model.Ranglijst;
import utils.DataSeeder;

public class MenuKeuzeRanglijst2 extends MenuKeuze{

    public MenuKeuzeRanglijst2(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit() {
        Ranglijst ranglijst = new Ranglijst();
        System.out.println("Lijst met genres:");
        System.out.println(String.join(", ", DataSeeder.getInstance().getGenres()));
        System.out.print("Voer het genre in om te zoeken: ");
        String zoekGenre = scanner.nextLine();
        ranglijst.toonRanglijstOpGenre(zoekGenre);
    }

}

