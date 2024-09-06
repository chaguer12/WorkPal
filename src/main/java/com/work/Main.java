package com.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String sql = "select * from users where id=2";
        String url = "jdbc:postgresql://localhost:5432/workpal";
        String db_user = "postgres";
        String password = "1360";
        Connection conn = DriverManager.getConnection(url,db_user,password);
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        result.next();
        System.out.println(result.getString("username"));
         }
}