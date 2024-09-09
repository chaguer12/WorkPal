package com.work.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection  {
        private static final String url = "jdbc:postgresql://localhost:5432/workpal";
        private static final String db_user = "postgres";
        private static final String password = "1360";
        private static Connection conn = null;

        public static Connection connect() {
                try {
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection(url, db_user, password);
                        System.out.println("Connected to PostgreSQL database");

                }catch(SQLException e) {
                        System.out.println("sql "+e.getMessage());

                } catch (ClassNotFoundException e) {
                        System.out.println("class "+e.getMessage());
                }
                return conn;



        }
        public static Connection getConnection() {
                if(conn == null){
                        connect();
                        return conn;

                }else{
                        return conn;
                }
        }



}




