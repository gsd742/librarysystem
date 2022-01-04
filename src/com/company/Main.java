package com.company;


import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.lang.invoke.SwitchPoint;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static File books = new File("books");

    public static void main(String[] args) {
        System.out.println("what would you like to do?");
        System.out.println("1. register a book");
        System.out.println("2. log in ");
        System.out.println("3. register for an account");
        Scanner input = new Scanner(System.in);
        System.out.println("enter number associated with task: ");
        int task = Integer.parseInt(input.nextLine());
        switch(task){
            case(1):
                savebook();
                break;
            case (2):
                System.out.println("log in");
                break;
            case (3):
                System.out.println("register");
                break;
        }

        }



    public static String bookdetails(){
        Scanner input = new Scanner(System.in);
        String booktitle = getString("enter book title:");
        System.out.println("enter the ISBN: ");
        Integer isbn = input.nextInt();
        String author = getString("enter the author: ");
        String genre = getString("enter the genre: ");
        books newbook = new books (booktitle, isbn, author, genre);

        return (booktitle+ "%" + isbn + "%" + author +"%"+ genre); //add in % to know where the things seperate from each other
    }

    public static String register(){
        boolean valid = false;
        String username = "";
        while (valid == false) {
            username = getString("enter your email address: ");
            if (username.contains("@")) {
                valid = true;
            }
        }
        valid = false ;
        while (valid == false){
            String password = getString("enter your password: ");
            boolean length = false;
            boolean upper = false;
            boolean lower = false;
            if (password.length()>8){
                length = true;
            }
            else{
                System.out.println("too short, at least 8 character plz");
            }
            if(password.matches(".*[A-Z].*")){ //check a-z capital
                upper = true;
            }
            else{
                System.out.println("need to have upper case");
            }
            if (password.matches(".*[a-z].*")){ // check a-z lower
                lower = true;
            }
            else{
                System.out.println("need to have lower case");
            }
            //*************you were here************
            //if all of the three are true then valid is true
            }



        }

    public static String getString(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void savebook(){
        try {
            FileWriter mywriter = new FileWriter(books);
            mywriter.write(bookdetails());
            mywriter.close();
            System.out.println("book has been successfully stored ");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
