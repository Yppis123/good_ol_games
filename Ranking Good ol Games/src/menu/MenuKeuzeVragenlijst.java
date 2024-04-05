package menu;

public class MenuKeuzeVragenlijst extends MenuKeuze {

    public MenuKeuzeVragenlijst(int keuze, String titel) {
        super(keuze, titel);
    }

    @Override
    public void voerActieUit() {
        boolean invullen = controleerInvoer();
        if (invullen) {
            System.out.println("Vragenlijst wordt ingevuld...");
        } else {
            System.out.println("Vragenlijst wordt niet ingevuld.");
        }
    }

    public boolean controleerInvoer() {
        boolean invullen = false;
        System.out.println("Wilt u een vragenlijst invullen? (J/N)");
        String antwoord = scanner.nextLine();
        while (!antwoord.equals("J") && !antwoord.equals("N")) {
            if (antwoord.equals("J")) {
                System.out.println("Vragenlijst wordt ingevuld...");
                invullen = true;
                break;
            } else if (antwoord.equals("N")){
                System.out.println("Vragenlijst wordt niet ingevuld.");
                break;
            }
            System.out.println("Ongeldige invoer. Voer J of N in.");
            antwoord = scanner.nextLine();
        }
        return invullen;
    }


}
