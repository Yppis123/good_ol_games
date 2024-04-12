package menu;

import java.util.ArrayList;

public class Menu {
    ArrayList<MenuKeuze> menuKeuzes;

    public Menu() {
        menuKeuzes = new ArrayList<>();
    }

    public void toonMenu(){
        for (MenuKeuze mk : menuKeuzes) {
            mk.toonMenuKeuze();
        }
        System.out.println("                                    ▓▓  ▓▓          ▓▓  ▓▓");
        System.out.println("Maak een keuze:                           ▓▓▓▓  ▓▓▓▓      ");
    }

    public void voerKeuzeUit(int invoer) {
        for (MenuKeuze mk : menuKeuzes) {
            if (invoer == mk.getKeuzeNummer()) {
                mk.voerActieUit();
                break;
            }
        }
    }

    public void voegMenuKeuzeToe(MenuKeuze menuKeuze) {
        menuKeuzes.add(menuKeuze);
    }
}