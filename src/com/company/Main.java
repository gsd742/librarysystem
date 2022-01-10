package com.company;

//made it to add them to list after beingmade objects? ns how to edit/delete them

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static File storedbooks = new File("books"); //...?
    public static ArrayList<books> BookList = new ArrayList<>();
    public static ArrayList<borrower> BorrowerList = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("what would you like to do?");
        System.out.println("1. register a book");
        System.out.println("2. log in ");
        System.out.println("3. register for an account");
        System.out.println("4. edit book details");
        Scanner input = new Scanner(System.in);
        System.out.println("enter number associated with task: ");
        int task = Integer.parseInt(input.nextLine());
        switch(task){
            case(1):
                bookdetails();
                break;
            case (2):
                System.out.println("log in");
                break;
            case (3):
                System.out.println("register");
                register();
                break;
            case (4):
                System.out.println("edit books");


        }

        }



    public static void  bookdetails(){ //gets the book details input only
        Scanner input = new Scanner(System.in);
        String booktitle = getString("enter book title:");
        System.out.println("enter the ISBN: ");
        Integer isbn = input.nextInt();
        String author = getString("enter the author: ");
        String genre = getString("enter the genre: ");
        books newbook = new books (booktitle, isbn, author, genre); //adds to object
        BookList.add(newbook); //adds book to list
    }

    public static void register(){
      String username =getusername();
      String password = getpassword();
      borrower newborrower = new borrower(username, password);
      BorrowerList.add(newborrower); //add to borrower list
    }

    public static String getusername(){
        boolean valid = false; //username
        String username = "";
        while (valid == false) {
            username = getString("enter your email address: ");
            if (username.contains("@")) {
                valid = true;
            }
        }
        return username;
    }

    public static String getpassword(){
        boolean valid = false ;
        String password = " ";
        while (valid == false){
            password = getString("enter your password: ");
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
            if (length == true & upper == true & lower == true){
                valid = true;
            }
        }
        return password;
    }

      public static String getString(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void  editbook(){ //unfinished not sure how to edit
        String title = getString("what is the name of the book?");
        if (BookList.contains(title)== true){
            // change what it is books.booktitle = new title

        }
        else{
            System.out.println("title doesnt exist");
        }

    }

    public static void savebook(){
        try {
            FileWriter mywriter = new FileWriter(storedbooks);
            mywriter.write(bookdetails());
            mywriter.close();
            System.out.println("book has been successfully stored ");
        }
        catch (Exception e){
            System.out.println(e);
        }
    } //was for saving to file but ns ? NOT USED

}
