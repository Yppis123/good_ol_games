package model;

public class Game {
    private String naam;
    private float prijs;
    private String genre;
    private float gemGameScore;
    private boolean inUitverkoop;
    private int korting;

    public Game(String naam, float prijs, String genre, boolean inUitverkoop, float gemGameScore) {
        this.naam = naam;
        this.prijs = prijs;
        this.genre = genre;
        this.inUitverkoop = inUitverkoop;
        this.gemGameScore = gemGameScore;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getGenre() {
        return genre;
    }

    public float getGemGameScore() {
        return gemGameScore;
    }

    public float getVerschil(){
        return prijs - (prijs * korting);
    }

    public boolean getInUitverkoop() {
        return inUitverkoop;
    }
    public void setKorting(){
        this.korting = korting;
    }

    public float getHuidigePrijs() {
        return prijs;
    }
}