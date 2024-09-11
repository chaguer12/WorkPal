package com.work.GUI;

import com.work.services.MemberService;

import java.util.Scanner;

public class MemberMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static MemberService memberService = new MemberService();
    public static void MemberLoginMenu(){
        try {

            System.out.println("====\t Enter your username");
            String username = scanner.nextLine();
            System.out.println("====\t Enter your password");
            String password = scanner.nextLine();
            memberService.loginMember(username,password);
        }catch (Exception e){
            System.out.println("An error has occured in login "+e.getMessage());
        }



    }
}
