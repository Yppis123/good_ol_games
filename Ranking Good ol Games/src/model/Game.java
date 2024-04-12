package model;

import utils.DataSeeder;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String naam;
    private float originelePrijs;
    private float prijs;
    private String genre;
    private float gemGameScore;
    private boolean inUitverkoop;
    private int korting;
    private ArrayList <Review> reviewLijst;

    public Game(String naam, float prijs, String genre, boolean inUitverkoop, float gemGameScore) {
        this.naam = naam;
        this.originelePrijs = prijs;
        this.prijs = prijs;
        this.genre = genre;
        this.inUitverkoop = inUitverkoop;
        this.gemGameScore = gemGameScore;
        reviewLijst = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public float getPrijs() {
        return prijs;
    }

    public String getGenre() {
        return genre;
    }

    public float getGemGameScore() {
        return gemGameScore;
    }

    public float getKortingsPercentage(){
        float procent = originelePrijs/100;
        return (100 - prijs/procent);
    }

    public void setPrijs(float prijs){
        this.prijs = prijs;
        if (prijs < originelePrijs) {
            this.inUitverkoop = true;
            DataSeeder.getInstance().voegGameToeAanUitverkoop(this);
        }
    }

    public void vraagReview() {
        Scanner scanner = new Scanner(System.in);

        // Vraag de gebruiker voor input voor de review
        System.out.println("Bedankt dat u een review wilt achterlaten! ");
        System.out.println("Geef cijfers (mag kommagetallen zijn) voor de volgende 3 criteria + een toelichting:");

        float scoreGameplay = checkScore("Gameplay");
        float scoreGraphics = checkScore("Graphics");
        float scoreStoryline = checkScore("Storyline");
        System.out.print("Toelichting: ");
        String toelichting = scanner.nextLine();

        // Maak nieuwe Review aan en berekenen de gemiddelde score
        Review review = new Review(scoreGameplay, scoreGraphics, scoreStoryline, toelichting);
        voegReviewToe(review);
    }

    public void voegReviewToe(Review review){
        reviewLijst.add(review);
        System.out.printf("Uw gemiddelde score is %.2f%nBedankt voor uw review!%n%n",review.getGemiddeldeScore());
        berekenNieuweGemiddelde(review);
    }

    private void berekenNieuweGemiddelde(Review review){
        float totaal = ((reviewLijst.size()-1)*getGemGameScore());
        totaal += review.getGemiddeldeScore();
        gemGameScore = totaal/reviewLijst.size();
    }

    public float checkScore(String criteria) {
        Scanner scanner = new Scanner(System.in);
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