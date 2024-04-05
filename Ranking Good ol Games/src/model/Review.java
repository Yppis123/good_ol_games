package model;

public class Review {

    private float scoreGameplay;
    private float scoreGraphics;
    private float scoreStoryline;
    private float gemiddeldeScore;
    private String toelichting;

    public Review(float scoreGameplay, float scoreGraphics, float scoreStoryline, String toelichting){
        this.scoreGameplay = scoreGameplay;
        this.scoreGraphics = scoreGraphics;
        this.scoreStoryline = scoreStoryline;
        this.toelichting = toelichting;
        berekenGemiddeldeScore();
    }

    public void berekenGemiddeldeScore(){
        float totaleScore = scoreGameplay + scoreGraphics + scoreStoryline;
        gemiddeldeScore = totaleScore/3;
    }

    public float getGemiddeldeScore() {
        return gemiddeldeScore;
    }
}