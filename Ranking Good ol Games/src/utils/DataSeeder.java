package utils;

import menu.*;
import model.Game;
import model.Medewerker;
import model.Ranglijst;

import java.util.ArrayList;

public class DataSeeder {

    private Menu menu;

    private ArrayList<Medewerker> medewerkers;
    private ArrayList<Game> gameLijst;
    private ArrayList<String> genres;
    private ArrayList<Game> uitverkoopLijst;

    private static DataSeeder instance = null;

    private DataSeeder() {
        gameLijst = new ArrayList<>();
        medewerkers = new ArrayList<>();
        genres = new ArrayList<>();
        uitverkoopLijst = new ArrayList<>();
        initialize();
    }


    public static DataSeeder getInstance() {

        if (instance == null) {
            instance = new DataSeeder();
        }

        return instance;
    }

    private void initialize() {
        menu = new Menu();

        MenuKeuzeUitverkoop menuKeuzeUitverkoop = new MenuKeuzeUitverkoop(1, "Toon het uitverkoop scherm           ▓▓          ▓▓    ");
        MenuKeuzeRanglijst menuKeuzeRanglijst = new MenuKeuzeRanglijst(2, "Toon de ranglijst scherm               ▓▓      ▓▓      ");
        MenuKeuzeReview menuKeuzeReview = new MenuKeuzeReview(3, "Maak een review aan                  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ");
        MenuKeuzeGameSpelen menuKeuzeGameSpelen = new MenuKeuzeGameSpelen(4, "Speel de game Galgje               ▓▓▓▓  ▓▓▓▓▓▓  ▓▓▓▓  ");
        MenuKeuzeLogin menuKeuzeLogin = new MenuKeuzeLogin(5, "Login als medewerker             ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        MenuKeuzeExit menuKeuzeExit = new MenuKeuzeExit(9, "Sluit de applicatie              ▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓");

        menu.voegMenuKeuzeToe(menuKeuzeUitverkoop);
        menu.voegMenuKeuzeToe(menuKeuzeRanglijst);
        menu.voegMenuKeuzeToe(menuKeuzeReview);
        menu.voegMenuKeuzeToe(menuKeuzeGameSpelen);
        menu.voegMenuKeuzeToe(menuKeuzeLogin);
        menu.voegMenuKeuzeToe(menuKeuzeExit);

        // Games toevoegen aan de ranglijst
        voegGameEnGenreToe("Pacman", 10.2f, "Action", true, 5.5f);
        voegGameEnGenreToe("Mario", 20f, "Platform", false, 4.3f);
        voegGameEnGenreToe("Tetris", 5f, "Puzzle", true, 7f);
        voegGameEnGenreToe("Sonic", 8.5f, "Platform", false, 6.3f);
        voegGameEnGenreToe("Super Contra", 9.2f, "Platform", true, 8.1f);
        voegGameEnGenreToe("Space Invaders", 7.5f, "RPG", false, 6.5f);

        Medewerker medewerker = new Medewerker("Jan", "4589");
        medewerkers.add(medewerker);


    }

    public void voegGameEnGenreToe(String naam, float prijs, String genre, boolean inUitverkoop, float gemGameScore) {
        gameLijst.add(new Game(naam, prijs, genre, inUitverkoop, gemGameScore));
        if (!genres.contains(genre)) {
            genres.add(genre);
        }
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public Menu getMenu() {
        return menu;
    }

    public ArrayList<Game> getGameLijst() {
        return gameLijst;
    }

    public ArrayList<Medewerker> getMedewerkers() {
        return medewerkers;
    }

    public void voegGameToeAanUitverkoop(Game game) {
        uitverkoopLijst.add(game);
    }

    public ArrayList<Game> getUitverkoopLijst() {
        return uitverkoopLijst;
    }
}
