package com.work.repository.repositories;

import com.work.entities.enums.Role;
import com.work.repository.interfaces.MemberInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository implements MemberInterface {
    private static Connection conn;

    public  MemberRepository(Connection conn) {
        this.conn = conn;
    }


    public static boolean isUsernameUnique(String username){
        String sql = "select * from members where username=?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println("Couldn't find username in database");
        }
        return false;
    }
    @Override
    public void signUpMember(String username, String email, String hashedPassword){
        String query = "INSERT INTO MEMBERS (username, email, password,role) VALUES (?, ?, ?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,email);
            stmt.setString(3,hashedPassword);
            stmt.setString(4, String.valueOf(Role.MEMBER));
            stmt.executeQuery();

        }catch (SQLException e) {
            System.out.println("Couldn't insert into database: " + e.getMessage());
        }

    }
}
