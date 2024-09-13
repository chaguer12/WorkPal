package com.work.GUI;

import com.work.repository.repositories.MemberRepository;
import com.work.services.ManagerService;
import com.work.services.MemberService;
import com.work.services.PasswordService;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Menu {
    private static MemberService memberService = new MemberService();
    private static ManagerService managerService = new ManagerService();
    public static Scanner scanner = new Scanner(System.in);
    public static void MainMenu(){


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
                    System.out.println("====\t You've selected Manager.");

                    break;
                case 2:
                    System.out.println("====\t You've selected Admin.");
                    AdminMenu.firstMenu();
                    break;
                case 3:

                    System.out.println("====\t Press [0] to login or [1] to Sign up \t====");
                    if(scanner.nextInt() == 0){
                        MemberMenu.MemberLoginMenu();

                    }else{
                        MemberSignUpMenu();
                    }

                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

    }

    public static void MemberSignUpMenu(){
        System.out.println("====\tWelcome to WorkPal\t====");
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
    public static void ManagerSignUpMenu(){
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
            if(managerService.signUpManager(username,email,hashed_password)){
                System.out.println("User successfully registered.");
            }else{
                System.out.println("User not registered. Please try again.");
            }
        }catch (NoSuchAlgorithmException e){
            System.out.println("NoSuchAlgorithm error: "+e.getMessage());
        }

    }

}


