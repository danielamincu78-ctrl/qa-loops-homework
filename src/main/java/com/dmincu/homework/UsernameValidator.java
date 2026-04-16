package com.dmincu.homework;

import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean valid;

        do {
            System.out.print("Introdu username: ");
            username = scanner.nextLine();

            valid = true; // presupunem că e valid la început

            //  Regula 1: lungime (min 6, max 12)
            if (username.length() < 6 || username.length() > 12) {
                System.out.println("Eroare: Username-ul trebuie să aibă între 6 și 12 caractere!");
                valid = false;
                continue;
            }

            boolean areCifra = false;

            //  Parcurgere caractere
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);

                //  Regula 2: fără spații (prioritară)
                if (c == ' ') {
                    System.out.println("Eroare: Username-ul nu trebuie să conțină spații!");
                    valid = false;
                    break; // oprim imediat
                }

                //  Regula 3: cel puțin o cifră
                if (Character.isDigit(c)) {
                    areCifra = true;
                }
            }

            // dacă am găsit spațiu, trecem la următoarea iterație
            if (!valid) {
                continue;
            }

            //  Verificare cifră
            if (!areCifra) {
                System.out.println("Eroare: Username-ul trebuie să conțină cel puțin o cifră!");
                valid = false;
            }

        } while (!valid);

        // Username valid
        System.out.println("Username acceptat: " + username);

        scanner.close();
    }
}

