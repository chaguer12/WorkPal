package com.work.GUI;

import com.work.repository.interfaces.MemberInterface;
import com.work.repository.repositories.MemberRepository;
import com.work.services.MemberService;
import com.work.services.PasswordService;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private static MemberService memberService = new MemberService();
    public static void MainMenu(){
        System.out.println("====\tWelcome to WorkPal\t====");
        Scanner scanner = new Scanner(System.in);
        System.out.println("====\t Sign up Menu\t ====");
        System.out.println("==\t Enter Username (must be unique):");
        String username = scanner.nextLine();
        try{
            if(MemberRepository.isUsernameUnique(username)){
                System.out.println("Username already exists. Please try again.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error checking username uniqueness.");
        }
        System.out.println("==\t Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("==\t Enter email address: ");
        String email = scanner.nextLine();
        try {
            String hashed_password = PasswordService.hashPassword(password);
            if(memberService.signUpMember(username,email,hashed_password)){
                System.out.println("User successfully registered.");
            }else{
                System.out.println("User not registered. Please try again.");
            }
        }catch (NoSuchAlgorithmException e){
            System.out.println("NoSuchAlgorithm error: "+e.getMessage());
        }
    }
}
