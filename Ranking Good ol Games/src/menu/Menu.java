package menu;

import java.util.ArrayList;

public class Menu {
    public ArrayList <MenuKeuze> menuKeuzes = new ArrayList<>();
    public void toonMenu(){
        SpaceInvader.toonSpaceInvader();
        for(MenuKeuze mk : menuKeuzes){
            mk.toonMenuKeuze();
        }
        System.out.print("Maak een keuze: ");
    }

    public void voerKeuzeUit(int invoer){
        for(MenuKeuze mk : menuKeuzes){
            if(invoer == mk.getKeuzeNummer()){
                mk.voerActieUit();
                break;
            }
        }
    }
}