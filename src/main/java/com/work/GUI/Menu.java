package com.work.GUI;

import com.work.repository.repositories.MemberRepository;
import com.work.services.MemberService;
import com.work.services.PasswordService;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Menu {
    private static MemberService memberService = new MemberService();
    public static void MainMenu(){
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("====\t Choose your role: \t====");
            System.out.println("1. Manager");
            System.out.println("2. Admin");
            System.out.println("3. Member");
            System.out.println("4. Exit");

            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.println("You've selected Manager.");
                    // Manager-specific actions
                    break;
                case 2:
                    System.out.println("You've selected Admin.");
                    // Admin-specific actions
                    break;
                case 3:
                    MemberMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

    }

    public static void MemberMenu(){
        System.out.println("====\tWelcome to WorkPal\t====");
        Scanner scanner = new Scanner(System.in);
        System.out.println("====\t Sign up Menu\t ====");
        System.out.println("==\t Enter Username (must be unique):");
        String username = scanner.nextLine();
        try {


            do {
                if (MemberRepository.isUsernameUnique(username)) {
                    System.out.println("Username already exists. Please try again.");
                }

                System.out.println("==\t Enter Username (must be unique):");
                username = scanner.nextLine();
            } while (username.isEmpty() );
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


