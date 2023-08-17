package org.example.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student {

        Scanner scanner= new Scanner(System.in);
        private int id;
        private String first_name;
        private String last_name;
        private int classNumber;
        private Date dateDegree;

        private static String request;
        private static Connection connection;

        private static PreparedStatement statement;

    public Student(String first_name, String last_name, int classNumber, Date dateDegree) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.classNumber = classNumber;
        this.dateDegree = dateDegree;
    }

    public Student(int id, String first_name, String last_name, int classNumber, Date dateDegree) {
        this(first_name, last_name, classNumber, dateDegree);
        this.id = id;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public Date getDateDegree() {
        return dateDegree;
    }

    public void setDateDegree(Date dateDegree) {
        this.dateDegree = dateDegree;
    }
    @Override
    public String toString() {
        return first_name + last_name + "numéro de classe : " + classNumber + "date du diplome : " + dateDegree;
    }
public boolean save() throws SQLException {
        String request = "INSERT INTO student (first_name, last_name, classNumber, dateDegree) VALUES (?,?,?,?)";
        connection = DatabaseManager.getPostgreSQLConnection();

        //Construction de la requete à la BDD
        //"preparestatement signifie" requete en cours de prépraption, il faut entrer les "?".
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        // préparé mais pas encore executée car ???, une fois prete à demarrer on la parametre avec les ?

        statement.setString(1,getFirst_name());
        statement.setString(2,getLast_name());
        statement.setDate(3,new java.sql.Date(getDateDegree().getTime()));
        statement.setInt(4,getClassNumber());

        //On appuie sur le start pour executer la requete
        int nbRows = statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys(); //Renvoie le resultat de l'id car généré automatiquement par la BDD

        if(resultSet.next()){
           setId(resultSet.getInt(1));
        }

        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return nbRows > 0; //renvoie du boolean en début
        }
        public static List<Student> getAll() throws SQLException{ // get all, selectionne tout
            List<Student> student = new ArrayList<>();
            request = "SELECT * FROM student";
            connection = DatabaseManager.getPostgreSQLConnection();
            statement = connection.prepareStatement(request);
        // on créee la connexion avec la BDD juste avant et ensuite grace à cette connexion ouverte on peut réaliser une requete
            ResultSet resultSet = statement.executeQuery(); // Tableau de résultat de la requete

            while (resultSet.next()){ //parcours le tableau ligne par ligne (boucle)
                Student s = new Student(resultSet.getInt("id"),resultSet.getString("first_name"),resultSet.getString("last_name"), resultSet.getInt("classNumber"), resultSet.getDate("dateDegree"));
                student.add(s);
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return student;

    }
    public boolean delete () throws SQLException {
        request = "DELETE FROM student where id = ?";
        connection = DatabaseManager.getPostgreSQLConnection();
        statement = connection.prepareStatement(request);
        statement.setInt(1, getId());
        int nbRows = statement.executeUpdate();

        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nbRows > 0;

        public static List<Student> getByClass(int classNumber) throws SQLException {
            List<Student> students = new ArrayList<>();
            request ="SELECT * FROM student where class_number = ?";
            connection = DatabaseManager.getPostgreSQLConnection();
            statement = connection.prepareStatement(request);
            statement.setInt(1,classNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student s = new Student(resultSet.getInt("id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getDate("date_degree"),resultSet.getInt("class_number"));
                students.add(s);
            }

            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                return students;

        }
    }
}









