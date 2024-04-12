package menu;

public class MenuKeuzeReview extends MenuKeuze{
    public MenuKeuzeReview(int keuzeNummer, String keuzeOmschrijving){
        super(keuzeNummer, keuzeOmschrijving);
    }


    public void voerActieUit(){
        MenuKeuzeReview1 menuKeuzeReview1 = new MenuKeuzeReview1(1, "Voeg review toe");

        int keuze = 0;
        while (keuze != 2) {
            menuKeuzeReview1.toonMenuKeuze();
            System.out.println("2. Terug naar hoofdmenu");
            System.out.print("Maak uw keuze: ");
            keuze = scanner.nextInt(); // miss in try catch zetten
            switch (keuze) {
                case 1:
                    menuKeuzeReview1.voerActieUit();
                    continue;
                case 2:
                    break;
                default:
                    System.out.println("Ongeldige keuze");
                }
            }

    }
}
