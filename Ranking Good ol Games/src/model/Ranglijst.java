package model;

import model.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Ranglijst {
    private List<Game> games = new ArrayList<>();

    public void voegGameToe(Game game) {
        games.add(game);
    }
    public void toonRanglijst() {
        System.out.println("model.Ranglijst:");
        for (Game game : games) {
            System.out.println("Naam: " + game.getNaam() + ", Prijs: $" + game.getPrijs() +
                    ", Genre: " + game.getGenre() + ", Gemiddelde Score: " + game.getGemGameScore());
        }
    }
    public void toonRanglijstOpGemGameScore() {
        games.sort(Comparator.comparing(Game::getGemGameScore).reversed());

        System.out.println("model.Ranglijst op basis van populariteit:");
        for (Game game : games) {
            System.out.println("Naam: " + game.getNaam() + ", Prijs: $" + game.getPrijs() +
                    ", Genre: " + game.getGenre() + ", Gemiddelde Score: " + game.getGemGameScore());
        }
    }
    public void toonRanglijstOpGenre(String genre) {
        List<Game> filteredGames = games.stream()
                .filter(game -> game.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());

        System.out.println("model.Ranglijst op basis van genre (" + genre + "):");
        for (Game game : filteredGames) {
            System.out.println("Naam: " + game.getNaam() + ", Prijs: $" + game.getPrijs() +
                    ", Genre: " + game.getGenre() + ", Gemiddelde Score: " + game.getGemGameScore());
        }
    }


}