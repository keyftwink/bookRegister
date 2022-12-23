package com.example.bookregister2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    public Connection databaseLink;

    public Connection getDBConnection(){

        String databaseName = "booksdb";
        String databaseUser = "root";
        String databasePassword = "LODSF4ihg2pj4gpoJSPhj3h3hdsf";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;

    }


}
