import java.util.ArrayList;


public class Uitverkoop {
    ArrayList<Game> uitverkooplijst = new ArrayList<Game>();

    public void toonUitverkoop() {
        for (int i = 0; i < uitverkooplijst.size(); i++) {
            System.out.println("Naam: " + uitverkooplijst.get(i).getNaam());
            System.out.println("Prijs: " + uitverkooplijst.get(i).getPrijs());
            System.out.println("Gemiddelde game score: " + uitverkooplijst.get(i).getGemGameScore());
            System.out.println();
        }
    }
}