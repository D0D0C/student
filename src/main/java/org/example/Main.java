package org.example;

import org.example.utils.DatabaseManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);

        try {
//***************** Appel de la méthode de Database manager pour se connecter à la database****************
            Connection connection = DatabaseManager.getPostgreSQLConnection();

//****************** Test pour vérifier la connexion à la database *********************
            if(connection != null){
                System.out.println("La connexion est ok");
            }else {
                System.out.println("connexion echoué");
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}