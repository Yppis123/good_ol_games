package model;

import model.Game;
import utils.DataSeeder;

import java.util.ArrayList;


public class Uitverkoop {
    public void toonUitverkooplijst() {
        ArrayList<Game> uitverkooplijst = DataSeeder.getInstance().getUitverkoopLijst();
        float vorigePercentage = 0;
            for (Game game : uitverkooplijst) {
                System.out.println("Naam: " + game.getNaam());
                System.out.printf("Prijs: €%.2f%n", game.getPrijs());
                System.out.println("Korting: " + game.getKortingsPercentage() + "%");
                System.out.println("Gemiddelde game score: " + game.getGemGameScore());
                System.out.println();
            }

    }
}