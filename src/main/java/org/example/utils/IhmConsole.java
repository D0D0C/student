package org.example.utils;

import java.util.Scanner;



public class IhmConsole {
    static Scanner scanner = new Scanner(System.in);

    public static void afficherMenu() {
        int choix;

        do {
            System.out.println("=== Menu principal ===");
            System.out.println();
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher la totalité des étudients");
            System.out.println("3. Afficher les étudients d'une classe");
            System.out.println("4. Supprimer étudiant");
            System.out.println("Votre choix :");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    StudentManager.ajoutStudent();
                    break;
                case 2:
                    afficherStudent();
                    break;
                case 3:
                    afficherStudentClasse();
                    break;
                case 4:
                    supprimerStudent();
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un choix valide !!!!");
            }
        }
        while (choix != 0);
        scanner.close();


    }
}
