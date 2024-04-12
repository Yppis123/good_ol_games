import model.Review;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemiddeldeScoreTest {

//Met deze testen wordt gekeken of de juiste GemiddeldeScore uit een review voortkomt. Dit is essentieel omdat hiermee uiteindelijk een GemiddeldeGameScore uit voorkomt wat bepalend is voor een prijsverhoging of verlaging. Zo heb ik een slechte, gemiddelde en top review gegeven om te kijken of alle resultaten kloppen met mijn verwachte antwoorden.

    @Test
    public void testGemiddeldeScoreInReview1(){

        // Arrange
        Review review = new Review(5.5F, 8, 6, "Een leuke spel");

        // Act
        review.berekenGemiddeldeScore();

        // Assert
        assertEquals(6.5, review.getGemiddeldeScore());
    }
    @Test
    public void testGemiddeldeScoreInReview2(){

        // Arrange
        Review review = new Review(8, 8, 8, "Top spel, altijd leuk om te spelen");

        // Act
        review.berekenGemiddeldeScore();

        // Assert
        assertEquals(8, review.getGemiddeldeScore());
    }
    @Test
    public void testGemiddeldeScoreInReview3(){

        // Arrange
        Review review = new Review(3, 2, 4, "Geen leuke spel, slechte graphics!");

        // Act
        review.berekenGemiddeldeScore();

        // Assert
        assertEquals(3, review.getGemiddeldeScore());
    }


}