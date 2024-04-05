package menu;

import model.Game;

import java.util.ArrayList;

public class MenuKeuzeUitverkoop extends MenuKeuze {
    ArrayList<Game> uitverkooplijst = new ArrayList<Game>();

    public MenuKeuzeUitverkoop(int keuzeNummer, String keuzeOmschrijving) {
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit() {
        for (int i = 0; i < uitverkooplijst.size(); i++) {
            float kortingsPercentage = 0;
            String goedKoopsteGame = "";
            float goedKoopstePrijs = 0;
            float gemScore = 0;
            for (Game game : uitverkooplijst) {
                if (kortingsPercentage < game.getVerschil()) {
                    goedKoopsteGame = game.getNaam();
                    goedKoopstePrijs = game.getHuidigePrijs();
                    gemScore = game.getGemGameScore();
                }
            }
            System.out.println("Naam: " + goedKoopsteGame);
            System.out.println("Prijs: " + goedKoopstePrijs);
            System.out.println("Gemiddelde game score: " + gemScore);
            System.out.println();
        }
    }

}

