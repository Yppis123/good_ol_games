package menu;

import model.Game;
import utils.DataSeeder;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuKeuzeReview1 extends MenuKeuze{

    public MenuKeuzeReview1(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }


    public void voerActieUit(){
        Scanner scanner = new Scanner(System.in);
        ArrayList <Game> gameLijst = DataSeeder.getInstance().getGameLijst();
        System.out.println();
        System.out.println("Hieronder staan alle Games waar u een review voor kunt schrijven");
        for(Game game : gameLijst){
            System.out.printf("%s, ", game.getNaam());
        }
        System.out.printf("%nTyp een Game naam in: ");
        String invoer = scanner.nextLine();
        //er moet nog gekeken waar de gegegvens worden opgeslagen, eigenlijk moet de methode hieronder in game worden toegevoegd
        for(Game game : gameLijst){
            if(invoer.equals(game.getNaam())){
                game.vraagReview();
            }
        }
        System.out.println("Wil je nog een enquete invullen? (ja/nee)");
        String antwoord = scanner.nextLine();
        if (antwoord.equals("ja")){
            MenuKeuzeVragen1 vragen1 = new MenuKeuzeVragen1(1, "Vragenlijst invullen");
            vragen1.voerActieUit();
        }
    }
}
