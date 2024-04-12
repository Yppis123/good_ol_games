package menu;

import model.Ranglijst;

public class MenuKeuzeRanglijst extends MenuKeuze{
    Ranglijst ranglijst;
    public MenuKeuzeRanglijst(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
        ranglijst = new Ranglijst();
    }

    public void voerActieUit() {
        MenuKeuzeRanglijst1 menuKeuzeRanglijst1 = new MenuKeuzeRanglijst1(1, "Toon ranglijst op basis van populariteit");
        MenuKeuzeRanglijst2 menuKeuzeRanglijst2 = new MenuKeuzeRanglijst2(2, "Toon ranglijst op basis van genre");

        while (true) {
            System.out.printf("%nRanglijst:%n%n");
            menuKeuzeRanglijst1.toonMenuKeuze();
            menuKeuzeRanglijst2.toonMenuKeuze();
            System.out.println("9. Terug naar het hoofdmenu");
            System.out.print("Maak een keuze: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (keuze) {
                case 1:
                    menuKeuzeRanglijst1.voerActieUit();
                    continue;
                case 2:
                    menuKeuzeRanglijst2.voerActieUit();
                    continue;
                case 9:
                    System.out.println();
                    return;
            }
        }
    }
}
