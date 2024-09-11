package com.work.repository.repositories;

import com.work.entities.Member;
import com.work.repository.interfaces.MemberInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository implements MemberInterface {
    private  Connection conn;

    public  MemberRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean isUsernameUnique(String username){
        String sql = "select * from memebers where username=?";
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
    public void signUpMember(String username,String email,String hashedPassword){
        String query = "INSERT INTO MEMBERS (username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,email);
            stmt.setString(3,hashedPassword);
            stmt.executeQuery();

        }catch (SQLException e) {
            System.out.println("Couldn't insert into database: " + e.getMessage());
        }
    }
}
