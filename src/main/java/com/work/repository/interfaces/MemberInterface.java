package com.work.repository.interfaces;

import com.work.entities.Member;
import com.work.repository.repositories.MemberRepository;

import java.sql.Connection;
import java.util.Optional;

public interface MemberInterface  {

     void signUpMember(String username,String email,String hashedPassword);
     boolean loginMember(String username,String hashedPassword);
}
