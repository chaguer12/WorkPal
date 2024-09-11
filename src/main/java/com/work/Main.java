package com.work;

import com.work.config.DatabaseConnection;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if(conn != null) {
            System.out.println("connected successfully");

        }else{
            System.out.println("could not connect to database");
        }

    }
}