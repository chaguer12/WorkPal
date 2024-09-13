package com.work.repository.repositories;

import com.work.entities.Manager;
import com.work.entities.enums.Role;
import com.work.repository.interfaces.ManagerInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ManagerRepository implements ManagerInterface {
    private static Connection conn;
    @Override
    public void signUpManager(String username,String email,String hashedPassword) {
        String query = "insert into managers(username,email,password,role) values(?,?,?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,email);
            stmt.setString(3,hashedPassword);
            stmt.setString(4, Role.MANAGER.toString());
            stmt.executeUpdate();


    }catch(Exception e){
            System.out.println("coudl't insert into managers: "+e.getMessage() );
        }
    }
}
