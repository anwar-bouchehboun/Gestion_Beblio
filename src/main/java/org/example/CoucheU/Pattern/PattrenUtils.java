package org.example.CoucheU.Pattern;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PattrenUtils {

    private static Scanner scanner = new Scanner(System.in);


    public static int getIntInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (Pattern.matches("\\d+", input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("L'entrée ne peut pas être vide.");
            }
        }
    }


    public static int getDocumentType() {
        while (true) {
            System.out.println("Quel type de document voulez-vous ajouter ? (1. Livre, 2. Magazine)");
            String input = scanner.nextLine().trim();
            if (Pattern.matches("[12]", input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Type de document invalide. Veuillez entrer 1 ou 2.");
            }
        }
    }
}
