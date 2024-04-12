package model;

import model.Game;
import utils.DataSeeder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Ranglijst {

    public ArrayList<String> genres = new ArrayList<>();


    public void vulGenresAan() {
        ArrayList<Game> games = DataSeeder.getInstance().getGameLijst();
        for (Game game : games) {
            if (!genres.contains(game.getGenre())) {
                genres.add(game.getGenre());
            }
        }
    }



    public void toonRanglijst(List<Game> games) {
        for (Game game : games) {
            System.out.printf("Naam: %s, Prijs: €%.2f, Genre: %s, Gemiddelde Score: %.1f\n",
                    game.getNaam(), game.getPrijs(), game.getGenre(), game.getGemGameScore());
        }
    }

    public void toonRanglijstOpGemGameScore() {
        ArrayList<Game> games = DataSeeder.getInstance().getGameLijst();

        games.sort(Comparator.comparing(Game::getGemGameScore).reversed());

        System.out.println("Ranglijst op basis van populariteit:");
        toonRanglijst(games);
    }

    public void toonRanglijstOpGenre(String genre) {
        ArrayList<Game> games = DataSeeder.getInstance().getGameLijst();

        List<Game> filteredGames = games.stream()
                .filter(game -> game.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Ranglijst op basis van genre (" + genre + "):");
        toonRanglijst(filteredGames);
    }


}