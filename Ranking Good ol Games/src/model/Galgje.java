package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Galgje {

    ArrayList<String> woordenLijst = new ArrayList<>();

    public int aantalLevens = 7;
    public int aantalLevens2 = 7;

    public void speelGame() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        woordenLijst.add("games");
        woordenLijst.add("spelen");
        woordenLijst.add("playstation");
        woordenLijst.add("galgje");
        woordenLijst.add("mario");
        woordenLijst.add("programmeren");
        woordenLijst.add("nintendo");
        woordenLijst.add("arcade");
        woordenLijst.add("pacman");
        woordenLijst.add("spaceship");

        String teRadenWoord = woordenLijst.get(random.nextInt(woordenLijst.size()));
        StringBuilder geradenWoord = new StringBuilder(teRadenWoord.length());
        for (int i = 0; i < teRadenWoord.length(); i++) {
            geradenWoord.append('_');
        }

        System.out.printf("%nWe gaan galgje spelen!%n");
        System.out.printf("Er is een woord die je moet raden, je hebt %d levens. Voer alleen kleine letters in!%n", aantalLevens);
        System.out.printf("Als je levens op zijn of het woord correct is geraden, stopt het spel. Succes!%n%n");

        boolean woordGeraden = false;
        while (aantalLevens > 0 && !woordGeraden) {
            System.out.println("Geraden woord: " + geradenWoord);
            System.out.println("Aantal levens: " + toonAantalLevens());
            System.out.print("Raad een letter: ");
            char gok = scanner.next().charAt(0);

            boolean goedGeraden = false;
            for (int i = 0; i < teRadenWoord.length(); i++) {
                if (teRadenWoord.charAt(i) == gok) {
                    geradenWoord.setCharAt(i, teRadenWoord.charAt(i));
                    goedGeraden = true;
                }
            }
            if (!goedGeraden) {
                aantalLevens--;
                System.out.printf("Helaas, de letter zit niet in het woord.%n%n");
            } else {
                System.out.printf("Goed geraden!%n%n");
            }

            if (geradenWoord.toString().equalsIgnoreCase(teRadenWoord)) {
                woordGeraden = true;
            }
        }

        if (woordGeraden) {
            System.out.printf("Gefeliciteerd, je hebt het woord geraden: %s%n%n",teRadenWoord);
        } else {
            System.out.printf("Helaas, je hebt alle levens opgebruikt. Het woord was: %s%n%n",teRadenWoord);
        }

    }

    public String toonAantalLevens() {
        int aantalLegeHarten = aantalLevens2 - aantalLevens;
        String levens = "";
        for (int i = 0; i < aantalLevens; i++) {

            levens += "♥ ";
        }
        for (int i = 0; i < aantalLegeHarten; i++) {
            levens += "♡ ";
        }
        return levens;
    }
}