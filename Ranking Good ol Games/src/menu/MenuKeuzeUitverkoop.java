package menu;

import model.Game;
import model.Uitverkoop;

import java.util.ArrayList;

public class MenuKeuzeUitverkoop extends MenuKeuze {
    Uitverkoop uitverkoop;
    ArrayList<Game> uitverkooplijst = new ArrayList<>();

    public MenuKeuzeUitverkoop(int keuzeNummer, String keuzeOmschrijving) {
        super(keuzeNummer, keuzeOmschrijving);
        uitverkoop = new Uitverkoop();
    }

    public void voegGameToe(Game game) {
        uitverkooplijst.add(game);
    }

    @Override
    public void voerActieUit() {
        MenuKeuzeUitverkoop1 menuKeuzeUitverkoop1 = new MenuKeuzeUitverkoop1(1, "Toon uitverkooplijst");
        while(true)
        {
            System.out.println();
            System.out.println("Uitverkooplijst:");
            menuKeuzeUitverkoop1.toonMenuKeuze();
            System.out.println("2. Terug naar het hoofdmenu");
            System.out.print("Maak een keuze: ");
            int keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                menuKeuzeUitverkoop1.voerActieUit();
            } else if (keuze == 2) {
                System.out.println();
                return;
            } else {
                System.out.println("Voer een van de gewenste keuzes in.");
            }

        }
    }
}

