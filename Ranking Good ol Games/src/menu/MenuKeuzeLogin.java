package menu;

import model.Game;
import utils.Security;
import utils.DataSeeder;

import java.util.ArrayList;

public class MenuKeuzeLogin extends MenuKeuze {

    public MenuKeuzeLogin(int keuzeNummer, String keuzeOmschrijving) {
        super(keuzeNummer, keuzeOmschrijving);
    }

    @Override
    public void voerActieUit() {
        Security security = new Security();
        if (security.inloggen()) {
            innerMenu();
        }
    }

    private void innerMenu() {
        MenuKeuzeVragen2 menuKeuzeVragen2 = new MenuKeuzeVragen2(2, "Open vraag toevoegen");
        MenuKeuzeVragen3 menuKeuzeVragen3 = new MenuKeuzeVragen3(3, "Meerkeuze vraag toevoegen");
        while (true) {
            System.out.printf("%nWelkom bij het medewerkersmenu:%n");
            System.out.println("1. Pas de prijs aan van een game");
            menuKeuzeVragen2.toonMenuKeuze();
            menuKeuzeVragen3.toonMenuKeuze();
            System.out.println("9. Log uit");
            System.out.println("Maak uw keuze: ");
            String keuze = scanner.nextLine();
            System.out.println();
            switch (keuze) {
                case "1":
                    ArrayList<Game> games = DataSeeder.getInstance().getGameLijst();
                    for (Game game : games) {
                        System.out.printf("%s: %.2f%n", game.getNaam(), game.getPrijs());
                    }
                    System.out.println("Pas de prijs aan van een game");
                    System.out.println("Wat is de naam van de game?");
                    String gameNaam = scanner.nextLine();
                    for (Game game : games) {
                        if (game.getNaam().equals(gameNaam)) {
                            System.out.printf("De huidige prijs van %s is %.2f%n", game.getNaam(), game.getPrijs());
                        }
                    }
                    System.out.println("Wat is de nieuwe prijs?");
                    float nieuwePrijs = scanner.nextFloat();
                    for (Game game : games) {
                        if (game.getNaam().equals(gameNaam)) {
                            game.setPrijs(nieuwePrijs);
                            System.out.println("De prijs van " + gameNaam + " is aangepast naar " + nieuwePrijs);
                        }
                    }
                    break;

                case "2":
                    menuKeuzeVragen2.voerActieUit();
                    break;
                case "3":
                    menuKeuzeVragen3.voerActieUit();
                    break;
                case "9":
                    System.out.println("U bent uitgelogd.");
                    System.out.println();
                    return;
                default:
                    System.out.println("Voer een van de gewenste keuzes in.");
            }
        }
    }
}
