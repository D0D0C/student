package org.example.utils;

import java.util.Scanner;



public class IhmConsole {
    static Scanner scanner = new Scanner(System.in);

    public void afficherMenu() {

        int choix;

        do {
            choix = scanner.nextInt();
            scanner.nextLine();


            switch (choix) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    getAllStudent();
                    break;
                case 3:
                    getAllStudentByClasse();
                    break;
                case 4:
                    StudentManager.supprimerStudent();
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


        public void
    }
}
