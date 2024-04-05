import menu.*;
import model.Game;
import model.Ranglijst;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Games toevoegen aan de ranglijst
        Ranglijst ranglijst = new Ranglijst();
        ranglijst.voegGameToe(new Game("Pacman", 10.2f, "Action", true, 5.5f));
        ranglijst.voegGameToe(new Game("Mario", 20f, "Platform", false, 4.3f));
        ranglijst.voegGameToe(new Game("Tetris", 5f,"Puzzle", true,7f));
        ranglijst.voegGameToe(new Game("Sonic", 8.5f, "Platform", false, 6.3f));
        ranglijst.voegGameToe(new Game("Super Contra", 9.2f, "Platform", true, 8.1f));

//        // moet in MenuKeuzeRanglijst
//        ranglijst.toonRanglijst();
//        ranglijst.toonRanglijstOpGemGameScore();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Voer het genre in om te zoeken: ");
//        String zoekGenre = scanner.nextLine();
//
//        ranglijst.toonRanglijstOpGenre(zoekGenre);


        // Menu configureren
        MenuKeuzeUitverkoop menuKeuzeUitverkoop = new MenuKeuzeUitverkoop(1, "Toon het uitverkoop scherm");
        MenuKeuzeRanglijst menuKeuzeRanglijst = new MenuKeuzeRanglijst(2, "Toon de ranglijst scherm");
        MenuKeuzeReview menuKeuzeReview = new MenuKeuzeReview(3, "Maak een review aan");
        MenuKeuzeExit menuKeuzeExit = new MenuKeuzeExit(7, "Sluit de applicatie");

        Menu menu = new Menu();
        menu.menuKeuzes.add(menuKeuzeUitverkoop);
        menu.menuKeuzes.add(menuKeuzeRanglijst);
        menu.menuKeuzes.add(menuKeuzeReview);
        menu.menuKeuzes.add(menuKeuzeExit);

        // Menu activeren
        menu.toonMenu();
        int invoer = scanner.nextInt();
        while(invoer != 7){
            try{
                menu.voerKeuzeUit(invoer);
                menu.toonMenu();
                invoer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Voer een van de gewenste keuzes in!");
                scanner.next();
            }
        }
        menuKeuzeExit.voerActieUit();
    }
}