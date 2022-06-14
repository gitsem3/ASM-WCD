package com.example.t2009m1_asm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/assignment_wcd";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static Connection connection;
    public static Connection getConnection(){
        try {
            if(connection == null || connection.isClosed()){
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
                System.out.println("Connected :" + connection);
            }
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
        return connection;
    };

}
