package com.work.services;

import com.work.config.DatabaseConnection;
import com.work.repository.interfaces.MemberInterface;
import com.work.repository.repositories.MemberRepository;

import java.sql.Connection;

public class MemberService {

    private final Connection conn = DatabaseConnection.getConnection();
    private final MemberInterface memberRepository  = new MemberRepository(conn);

    public  boolean signUpMember(String username,String email,String hashedPassword){
        memberRepository.signUpMember(username,email,hashedPassword);
        return true;
    }

    public boolean loginMember(String username,String password) throws Exception{
        String hashed_password = PasswordService.hashPassword(password);
        if(memberRepository.loginMember(username,hashed_password)){
            System.out.println("====\tLogin Successful");
            return true;
        }else {
            System.out.println("====\tUsername or Password incorrect => Login Failed");
            return false;
        }
    }

}
