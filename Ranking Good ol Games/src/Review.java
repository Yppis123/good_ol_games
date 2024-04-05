public class Review {

    private float scoreGameplay;
    private float scoreGraphics;
    private float scoreStoryline;
    private float gemiddeldeScore;
    private String toelichting;

    public Review(){

    }

    public void berekenGemiddeldeScore(float scoreGameplay, float scoreGraphics, float scoreStoryline){
        float totaleScore = scoreGameplay + scoreGraphics + scoreStoryline;
        int totaleAantalCriteria = 3;
        gemiddeldeScore = totaleScore/totaleAantalCriteria;
    }


}