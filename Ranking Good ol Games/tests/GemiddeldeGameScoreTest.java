import model.Game;
import model.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemiddeldeGameScoreTest {

    // Voor deze tests kijken we naar hoe het gemiddelde van de game score wordt berekend na het toevoegen van reviews
    // aan de game. Dit wordt getest met verschillende aantallen reviews. Zonder reviews zou het de vooraf aangegeven
    // aantal voor gemGameScore moeten zijn. Met reviews zou het gemiddelde van de reviews moeten worden berekend. Dit
    // kunnen getallen zijn met vele decimalen en we gebruiken floats. Daarom wordt er een delta van 0.01 gebruikt.

    @Test
    public void testGemiddeldeGameScore_ZonderReviews() {
        // Arrange
        Game game = new Game("Super Contra", 5.7f, "Action", false, 7.6f);

        // Act
        float result = game.getGemGameScore();

        // Assert
        float expected = 7.6f;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testGemiddeldeGameScore_TweeReviews() {
        // Arrange
        Game game = new Game("Pacman", 20.5f, "Arcade", false, 4.5f);
        Review review1 = new Review(8.5f, 3.2f, 2.44f, "Leuk spel");
        Review review2 = new Review(4.5f, 8.2f, 7f, "Mooi spel");

        // Act
        game.voegReviewToe(review1);
        game.voegReviewToe(review2);
        float result = game.getGemGameScore();

        // Assert
        float expected = 5.64f;
        assertEquals(expected, result, 0.01);

    }

    @Test
    public void testGemiddeldeGameScore_DrieReviews() {
        // Arrange
        Game game = new Game("Pacman", 20.5f, "Arcade", false, 4.5f);
        Review review1 = new Review(8.5f, 3.2f, 2.44f, "Leuk spel");
        Review review2 = new Review(4.5f, 8.2f, 7f, "Mooi spel");
        Review review3 = new Review(8.5f, 9.2f, 9.99999f, "Geweldig spel");

        // Act
        game.voegReviewToe(review1);
        game.voegReviewToe(review2);
        game.voegReviewToe(review3);
        float result = game.getGemGameScore();

        // Assert
        float expected = 6.8377766667f;
        assertEquals(expected, result, 0.01);
    }
}