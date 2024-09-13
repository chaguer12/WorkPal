package com.work.GUI;

import com.work.services.MemberService;

import java.util.Scanner;

public class AdminMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static MemberService memberService = new MemberService();
    public static void firstMenu(){
        int choice = 0;
        do {
            System.out.println("====\t Welcome to Admin Menu:");
            System.out.println("[1]. Add Member or Manager");
            System.out.println("[2]. Modify Member or Manager");
            System.out.println("[3]. Delete Member or Manager");
            System.out.println("[4]. Reset Password");
            System.out.println("[0]. Exit");
            System.out.print("Enter your choice: ");
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                scanner.nextLine();
            }
            switch (choice){
                case 1:
                    addMemberMenu();
                    break;
                case 2:
                    //modifyMemberMenu();
                    break;
                case 3:
                    //deleteMemberMenu();
                    break;
                case 4:
                    //resetPasswordMenu();
                    break;
                case 0:
                    System.out.println("Exiting Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }while (choice != 0);


    }
    public static void addMemberMenu(){
        System.out.println("====\t Add a new member: \t====");
        int choice = 0;
        do {
            System.out.println("[1]. Add Member");
            System.out.println("[2]. add Manager");
            System.out.println("[3]. Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    memberService.signUpMember();

            }
        }while(choice !=0 );
        Menu.MemberSignUpMenu();

    }
}
