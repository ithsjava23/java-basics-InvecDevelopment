package org.example;
import java.util.Scanner;
import java.util.Arrays;
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
                case '2' -> {
                }
                case '3' -> {
                }
                case '4' -> {
                }
                case 'e', 'E' -> System.out.print("\nProgrammet Avslutas");
                default -> System.out.print("\nError");
            }

        }            while (choice != 'e' && choice != 'E');

        scanner.close();
    }
    public static void inmatning(Scanner scanner, int [] elpriser) {
        System.out.print("\nInmatning av elpriser (i öre per Kwh):\n");
        for (int i = 0; i < elpriser.length; i++) {
            System.out.print("Timme " + i + ": ");
            elpriser[i] = scanner.nextInt();
        }
    }
}
