package org.example;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        int[] elpriser = new int[24];
        //Meny+val
        do {
            System.out.print("\nElpriser");
            System.out.print("\n=======");
            System.out.print("\n1. Inmatning");
            System.out.print("\n2. Min, Max och Medel");
            System.out.print("\n3. Sortera");
            System.out.print("\n4. Bästa Laddningstid (4h)");
            System.out.print("\ne. Avsluta");
            System.out.print("\nVälj ett alternativ: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1' -> inmatning(scanner, elpriser);
                case '2' -> minMaxMedel(elpriser);
                case '3' -> sortera(elpriser);
                case '4' -> bästaLaddningstid(elpriser);
                case 'e', 'E' -> {System.out.print("\nProgrammet Avslutas");
                return;}
            }

        } while (choice != 'e' && choice != 'E');

        scanner.close();
    }

    public static void inmatning(Scanner scanner, int[] elpriser) {
        //Skapar en array och fyller den baserat på input
        System.out.print("\nInmatning av elpriser (i öre per Kwh):\n");
        for (int i = 0; i < elpriser.length; i++) {
            System.out.print("Timme " + i + ": ");
            elpriser[i] = scanner.nextInt();
        }
    }

    public static void minMaxMedel(int[] elpriser) {
        //Kollar min max och medel i Arrayen
        int minPris = Arrays.stream(elpriser).min().getAsInt();
        int maxPris = Arrays.stream(elpriser).max().getAsInt();
        double medelPris = Arrays.stream(elpriser).average().getAsDouble();

        System.out.print("\nLägsta pris: " + minPris + " öre/kWh");
        System.out.print("\nHösta pris: " + maxPris + " öre/kWh");
        System.out.print("\nMedelpris: " + medelPris + " öre/kWh");
    }

    public static void sortera(int[] elpriser) {
        String[] tidpunkter = new String[elpriser.length];

        for (int i = 0; i < tidpunkter.length; i++) {
            tidpunkter[i] = String.format("%02d-%02d", i, (i + 1) % 24);
        }
        //Använder lambda uttryck för att sortera
        IntStream.range(0, elpriser.length)
                .boxed()
                .sorted((i, j) -> Integer.compare(elpriser[j], elpriser[i]))
                .forEach(i -> System.out.print("\n" + tidpunkter[i] + " " + elpriser[i] + " öre/kWh"));

    }

    public static void bästaLaddningstid(int[] elpriser) {
        int billigasteStartTimme = 0;
        int billigasteTotalPris = Integer.MAX_VALUE;

        //Räknar ut de 4 timmarna som blir billigaste att ladda oavbrutet
        for (int i = 0; i <= elpriser.length - 4; i++) {
            int totalPris = 0;
            for (int j = i; j < i + 4; j++) {
                totalPris += elpriser[j];
            }
            if (totalPris < billigasteTotalPris) {
                billigasteTotalPris = totalPris;
                billigasteStartTimme = i;
            }
        }

        System.out.println("Bästa laddningstid (4h) börjar kl " + billigasteStartTimme);
        System.out.println("Medelpris under laddningstiden: " + (billigasteTotalPris / 4) + " öre/kWh");
    }
}
