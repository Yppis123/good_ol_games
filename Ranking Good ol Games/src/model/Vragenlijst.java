package model;

import java.io.*;
import java.util.*;


public class Vragenlijst {
    static String nvraag;
    static ArrayList<String> vl = new ArrayList<String>();
    static ArrayList<String> antworden = new ArrayList<String>();

    // vul de nieuwe vraag in
    public static void nieuwenvraag(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nieuwe vraag:");
        nvraag = scanner.nextLine();
        nieuwenvraagToevoegen();
    }

    // voegt een nieuwe vraag toe aan het bestand vragen
    public static void nieuwenvraagToevoegen() {
        try {
            PrintWriter Vragen = new PrintWriter(new BufferedWriter(new FileWriter("src/model/Vragen.txt", true)));
            Vragen.write(nvraag);
            Vragen.write(System.getProperty( "line.separator" ));
            Vragen.flush();
            Vragen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //leest hele vragenlijst file en stopt het in de ArrayList VL
    public static void lezenvragen(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("src/model/Vragen.txt"));
            String line = reader.readLine();
            while (line != null){
                //System.out.println(line);
                vl.add(line);
                line = reader.readLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        }

    }

    // steld vragen en laad de gebruiker antworden
    public static void steldvragen(){
        Scanner scanner = new Scanner(System.in);
        lezenvragen();

        for(int i = 0; i < vl.size(); i++){
            System.out.println(vl.get(i));
            String inputgebruiker = scanner.nextLine();
            antworden.add(inputgebruiker);
        }
        try {
            PrintWriter Antwoord = new PrintWriter(new BufferedWriter(new FileWriter("src/model/VenA.txt", true)));
            for(int i = 0; i < vl.size(); i++){
                Antwoord.write(vl.get(i));
                Antwoord.write(System.getProperty( "line.separator" ));
                Antwoord.write(antworden.get(i));
                Antwoord.write(System.getProperty( "line.separator" ));
                Antwoord.write(System.getProperty( "line.separator" ));
            }
            Antwoord.flush();
            Antwoord.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // om te testen
    //public static void main(String[] args){
    //nieuwenvraag();
    //steldvragen();
    //}

}
