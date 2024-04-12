package utils;

import model.Medewerker;
import utils.DataSeeder;

import java.util.ArrayList;
import java.util.Scanner;

public class Security {

    public boolean inloggen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Inloggen:");
        boolean isIngelogd = false;
        while (!isIngelogd) {
            System.out.println("Voer uw gebruikersnaam in: ");
            String gebruikersnaam = scanner.nextLine();
            System.out.println("Voer uw wachtwoord in: ");
            String wachtwoord = scanner.nextLine();
            System.out.println();
            for (Medewerker medewerker : DataSeeder.getInstance().getMedewerkers()) {
                if (medewerker.getGebruikersnaam().equals(gebruikersnaam) && medewerker.getWachtwoord().equals(wachtwoord)) {
                    System.out.println("U bent ingelogd.");
                    isIngelogd = true;
                    return isIngelogd;
                }
            }
        }
        return isIngelogd;
    }

}
