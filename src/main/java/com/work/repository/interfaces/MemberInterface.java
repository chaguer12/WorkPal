package com.work.repository.interfaces;

import com.work.repository.repositories.MemberRepository;

import java.sql.Connection;

public interface MemberInterface  {

    boolean isUsernameUnique(String username);
    void signUpMember(String username,String email,String hashedPassword);
}
