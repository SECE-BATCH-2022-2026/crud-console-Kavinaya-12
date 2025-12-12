package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/student_erp";
            String user = "root";
            String pass = "root@123";
            con = DriverManager.getConnection(url, user, pass);
        } 
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return con;
    }
}
