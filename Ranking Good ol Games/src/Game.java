import java.util.ArrayList;

public class Game {
    private String naam;
    //    private float originelePrijs; // nog niet zeker of we dit nodig hebben
    private float prijs;
    private String genre;
    private boolean inUitverkoop;
    private String gemGameScore;
    private ArrayList<Review> reviewLijst;


    public Game() {
        reviewLijst = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public float getPrijs() {
        return prijs;
    }

    public String getGemGameScore() {
        return gemGameScore;
    }

    public void wijzigPrijs(float korting) {
        prijs *= korting; // korting als kommagetal

        // als prijs is verlaagd, zet in uitverkoop
        inUitverkoop = korting < 1;
    }

    public void voegReviewToe(Review review) {
        reviewLijst.add(review);
    }
}

