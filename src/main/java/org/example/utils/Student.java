package org.example.utils;

import java.util.Scanner;

public class Student {

        Scanner scanner= new Scanner(System.in);
        String first_name;
        String last_name;
        int classNumber;
        int dateDegree;

    public Student() {
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

    public int getdateDegree() {
        return dateDegree;
    }

    public void setdateDegree(int dateDegree) {
        dateDegree = dateDegree;
    }
    @Override
    public String toString() {
        return first_name + last_name + "numéro de classe : " + classNumber + "date du diplome : " + dateDegree;
    }}

