package model;

import java.io.*;
import java.util.*;


public class Multiplechoice {
    static String nmvraag;
    static Scanner cin = new Scanner(System.in);

    // vul de nieuwe meer keuzen vraag in
    public static void nieuwenMultiplechoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BV: De vraag, (1) antwoord. (2) antwoord.,2\nJe kan meer dan 2 antwoorden invoeren, dit doe je door een '.' achter de vorige antwoord te zetten.\nNa de ., kan je zeggen of je een conditionele vraag wil hebben. Dit doe je door de cijfer aan te geven van het antwoord.\nNieuwe vraag:");
        nmvraag = scanner.nextLine();
        nieuwenMultiplechoiceToevoegen();
    }

    // voegt een nieuwe meer keuze vraag toe aan het bestand vragen
    public static void nieuwenMultiplechoiceToevoegen() {
        try {
            PrintWriter Vragen = new PrintWriter(new BufferedWriter(new FileWriter("src/model/Multiplechoice.txt", true)));
            Vragen.write(nmvraag);
            Vragen.write(System.getProperty("line.separator"));
            Vragen.flush();
            Vragen.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Initializaions and Instantiations

    public static void vragenlijstAantonen() {
        double score = 0;

        // Store questions and answers in 2 dimensional array
        String[][] QandA = readQuestionsFromFile("src/model/Multiplechoice.txt");
        int numberOfQuestions = QandA.length;

        String[] Answers = new String[numberOfQuestions];


        // loop through each string in the array and compare it to answers
        for (int x = 0; x < numberOfQuestions; x++) {
            System.out.println("" + (x + 1) + ". " + QandA[x][0]);
            String[] choices = QandA[x][1].split("\\n"); // Split choices by new line
            for (String choice : choices) {
                System.out.println(QandA[x][1].replace(".", "\n")); // Replace "\n" with new line
            }
            System.out.print("Jouw keuze: ");

            String str = QandA[x][1];
            int aantalOpties = str.split("\\.", -1).length - 1;

            try {
                int choice = cin.nextInt();
                if (choice >= 1 && choice <= aantalOpties) {
                    Answers[x] = String.valueOf(choice);
                } else {
                    System.out.println("Verkeerde keuze. Kies een getal tussen 1 en " + aantalOpties);
                    x--;
                    continue;
                }

            } catch (InputMismatchException e) {
                System.out.println("Ongewenste invoer. Voer een getal in.");
                cin.next();
                x--;
                continue;
            }

            Answers[x].toLowerCase();

            if (QandA[x][2].equals(Answers[x])) {
                score++;
                System.out.println();
                System.out.println("Verklaar je antwoord");
                Answers[x] += " Verklaar je antwoord: ";
                cin.nextLine();
                Answers[x] += String.valueOf(cin.nextLine());
            }

            System.out.print("\n");
        }


        System.out.println("Vragenlijst is ingevuld");

        try {
            PrintWriter MAntwoord = new PrintWriter(new BufferedWriter(new FileWriter("src/model/VenA.txt", true)));
            for (int i = 0; i < QandA.length; i++) {
                MAntwoord.write(QandA[i][0]);
                MAntwoord.write(System.getProperty("line.separator"));
                MAntwoord.write(QandA[i][1]);
                MAntwoord.write(System.getProperty("line.separator"));
                MAntwoord.write(Answers[i]);
                MAntwoord.write(System.getProperty("line.separator"));
                MAntwoord.write(System.getProperty("line.separator"));
            }
            MAntwoord.flush();
            MAntwoord.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[][] readQuestionsFromFile(String filename) {
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            int lines = 0;
            while (fileScanner.hasNextLine()) {
                lines++;
                fileScanner.nextLine();
            }

            String[][] questionsAndAnswers = new String[lines][3];

            fileScanner = new Scanner(new File(filename));
            int index = 0;
            while (fileScanner.hasNextLine() && index < questionsAndAnswers.length) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    questionsAndAnswers[index] = parts;
                    index++;
                }
            }

            fileScanner.close();
            return questionsAndAnswers;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return new String[0][0];
        }
    }

}