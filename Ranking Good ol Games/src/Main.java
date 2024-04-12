import menu.*;
import model.Multiplechoice;
import model.Vragenlijst;
import utils.DataSeeder;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DataSeeder dataseeder = DataSeeder.getInstance();

        Menu menu = dataseeder.getMenu();

        // Menu activeren
        menu.toonMenu();

        int invoer = 0;
        while(invoer != 9){
            try{
                invoer = scanner.nextInt();
                menu.voerKeuzeUit(invoer);
                menu.toonMenu();
            } catch (InputMismatchException e) {
                System.out.println("Voer een van de gewenste keuzes in.");
                scanner.next();
            }
        }
    }
}