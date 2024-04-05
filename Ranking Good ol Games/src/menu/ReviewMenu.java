package menu;

import model.Review;

import java.util.Scanner;

public class ReviewMenu {
    public Scanner scanner = new Scanner(System.in); // kan deze overerven uit de superklasse

    public void toonMenu() {
        System.out.println("1. Voeg review toe");
        System.out.println("2. Terug naar hoofdmenu");
        System.out.print("Maak uw keuze: ");
    }

    public void voerActiesUit() {
        int keuze = 0;
        while (keuze != 2) {
            toonMenu();
            keuze = scanner.nextInt(); // miss in try catch zetten
            switch (keuze) {
                case 1:
                    voegReviewToe();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Ongeldige keuze");
            }
        }
    }

    public void voegReviewToe() {
        // Vraag de gebruiker voor input voor de review
        System.out.println("Bedankt dat u een review wilt achterlaten! ");
        System.out.println("Geef cijfers (mag kommagetallen zijn) voor de volgende 3 criteria + een toelichting:");

        float scoreGameplay = checkScore("Gameplay");
        float scoreGraphics = checkScore("Graphics");
        float scoreStoryline = checkScore("Storyline");
        System.out.print("Toelichting: ");
        String toelichting = scanner.nextLine();

        // Maak nieuwe model.Review aan en berekenen de gemiddelde score
        Review review = new Review(scoreGameplay, scoreGraphics, scoreStoryline, toelichting);
        System.out.printf("Uw gemiddelde score is %.2f%nBedankt voor uw review!",review.getGemiddeldeScore());

        // Voeg nieuwe review toe aan de desbetreffende Game
        // this.Game.voegReviewToe(review); // dit werkt niet, want Game is niet gedefinieerd
    }

    public float checkScore(String criteria) {
        float answer;
        while (true) {
            System.out.print(criteria + ": ");
            // check of de input een float is en tussen 0 en 10 ligt
            if (scanner.hasNextFloat()) {
                answer = scanner.nextFloat();
                if (answer >= 0 && answer <= 10) {
                    return answer;
                }
            }
            System.out.println("Ongeldige invoer. Voer een getal tussen 0 en 10 in.");
            scanner.next();
        }
    }
}
