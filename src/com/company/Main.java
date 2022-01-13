package com.company;

//need to make it so all borrowers and books are saved to an external file
//last thing should be save to file
//first thing should be retrieve from files

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileWriter;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static File storedbooks = new File("books"); //...?
    public static File storedborrowers = new File ("borrowers");
    public static ArrayList<books> BookList = new ArrayList<>();
    public static ArrayList<borrower> BorrowerList = new ArrayList<>();


    public static void main(String[] args) {
        boolean finished = false;
        while(finished == false) {
            System.out.println("what would you like to do?");
            System.out.println("1. register a book");
            System.out.println("2. log in ");
            System.out.println("3. register for an account");
            System.out.println("4. edit book details");
            System.out.println("5. delete book");
            System.out.println("6. edit borrower");
            System.out.println("7. delete borrower");
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
                    editbook();
                case(5):
                    System.out.println("delete book");
                    deletebook();
                case(6):
                    System.out.println("edit borrower");
                    editborrower();
                case (7):
                    System.out.println("delete borrower");
                    deleteborrower();

            }
            String more = getString("anything else?");
            if (more.contains("yes")){
                finished = false;
            }
            else{
                finished = true;
                System.out.println("bye-bye");
            }
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
      String borrowedbook = "";
      borrower newborrower = new borrower(username, borrowedbook);
      BorrowerList.add(newborrower); //add to borrower list
    }

    public static String getusername(){
        String username = getString("what username do you want? ");
        return username;
    }

    public static void  editbook(){
        String title = getString("what is the name of the book?");
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getBooktitle().contains(title)== true){ //takes i in arraylist, then gets book title and checks against title typed in
                BookList.remove(i); //delete what is held ion that slot of the array list
                bookdetails(); //saves the book as new, therefore they can edit what they want
                System.out.println("title has been edited");
            }
        }

    }

    public static void deletebook (){
        String title = getString("what is the title?");
        for( int i = 0; i< BookList.size(); i++){
            if (BookList.get(i).getBooktitle().contains(title)){
                BookList.remove(i);
                System.out.println(title+ "has been deleted");
            }
        }

    }

    public static void editborrower (){
        String borrower = getString("what is the username? ");
        for (int i = 0; i< BorrowerList.size(); i++){
            if( BorrowerList.get(i).getUsername().contains(borrower)){
                BorrowerList.remove(i);
                register();
                System.out.println( borrower + "has been edited");
            }
        }
    }

    public static void deleteborrower(){
        String borrower = getString("what is the name?");
        for (int i = 0; i< BorrowerList.size();i++){
            if(BorrowerList.get(i).getUsername().contains(borrower)){
                BorrowerList.remove(i);
                System.out.println("deleted" + borrower);
            }
        }
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
