package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {


//**********************Création de la connexion à la database***************************
    public static Connection getPostgreSQLConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/exo_student";
        String user = "postgres";
        String password = "0000";

        Connection connection = DriverManager.getConnection(url,user,password);

        return connection;
    }
}