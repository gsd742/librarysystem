package com.company;




import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Main {
    public static File storedbooks = new File("books"); //...?
    public static File storedborrowers = new File ("borrowers");
    public static ArrayList<books> BookList = new ArrayList<>();
    public static ArrayList<borrower> BorrowerList = new ArrayList<>();


    public static void main(String[] args) {
        readfromfile();
        boolean finished = false;
        while(finished == false) {
            System.out.println("what would you like to do?");
            System.out.println("1. register a book");
            System.out.println("2. delete borrower ");
            System.out.println("3. register for an account");
            System.out.println("4. edit book details");
            System.out.println("5. delete book");
            System.out.println("6. edit borrower");
            Scanner input = new Scanner(System.in);
            System.out.println("enter number associated with task: ");
            int task = Integer.parseInt(input.nextLine());
            switch(task){
                case(1):
                    bookdetails();
                    break;
                case (2):
                    System.out.println("delete borrower");
                    deleteborrower();
                    break;
                case (3):
                    System.out.println("register");
                    register();
                    break;
                case (4):
                    System.out.println("edit books");
                    editbook();
                    break;
                case(5):
                    System.out.println("delete book");
                    deletebook();
                    break;
                case(6):
                    System.out.println("edit borrower");
                    editborrower();
                    break;
            }
            String more = getString("anything else? yes or no");
            if (more.contains("yes")){
                finished = false;
            }
            else{
                finished = true;
                System.out.println("bye-bye");
            }
        }
        writebooktofile();
        writeborrowertofile();
        }

    public static void  bookdetails(){ //gets the book details input only
        Scanner input = new Scanner(System.in);
        String booktitle = getString("enter book title:");
        System.out.println("enter the ISBN: ");
        Integer isbn = input.nextInt();
        String author = getString("enter the author: ");
        String genre = getString("enter the genre: ");
        books newbook = new books (booktitle, isbn, author, genre); //adds to object
        System.out.println("book has been added");
        BookList.add(newbook); //adds book to list
    }

    public static void register(){ //sets username and make borrowed book variable empty
      String username =getusername();
      String password = getpassword();
      boolean employee = getemployee();
      borrower newborrower = new borrower(username, password, employee);
      BorrowerList.add(newborrower); //add to borrower list
    }

    public static String getusername(){
        boolean valid = false;
        String username = "";
        while (valid == false ){
            username = getString("enter your email address : ");
            if (username.contains("@")){
                valid = true;
            }
        }
        return username;
    }

    public static String getpassword() {
        boolean valid = false;
        String password = "";
        while (valid == false){
            password = getString("enter your password: ");
            boolean length = false ;
            boolean upper = false;
            boolean lower = false ;
            if (password.length() > 8){
                length = true;
            }
            else {
                System.out.println("password is too short, needs to be at least 8 characters");
            }
            if (password.matches(".*[A-Z].*")){
                upper = true;
            }
            else{
                System.out.println("need to have at least one capital letter");
            }
            if (password.matches(".*[a-z].*")){
                lower = true;
            }
            else {
                System.out.println("password needs to contain a lower case letter");
            }
            if (length == true & upper == true & lower == true){
                valid = true;
            }
        }
        return password;
    }

    public static boolean getemployee(){
        boolean valid = false;
        boolean employee;
        while (valid == false){ //makes sure there is valid input
            String ans = getString("are you an employee? Y/N ");
            if (ans == "Y"){
                employee = true;
                valid = true;
            }
            if (ans == "N"){
                employee = false;
                valid = true;
            }
            else{
                System.out.println("not valid input, please put Y or N");
            }
        }
        return employee;
    }

    public static void  editbook(){ //deletes and creates new book from input
        String title = getString("what is the name of the book?");
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getBooktitle().contains(title)== true){ //takes i in arraylist, then gets book title and checks against title typed in
                BookList.remove(i); //delete what is held ion that slot of the array list
                bookdetails(); //saves the book as new, therefore they can edit what they want
                System.out.println("title has been edited");
            }
        }

    }

    public static void deletebook (){ //deletes book from arraylist after searching with the title
        String title = getString("what is the title?");
        for( int i = 0; i< BookList.size(); i++){
            if (BookList.get(i).getBooktitle().contains(title)){
                BookList.remove(i);
                System.out.println(title+ "has been deleted");
            }
            else{
                System.out.println("doesnt exist");
            }
        }
    return;
    }

    public static void editborrower (){ //searches username, then deletes user and creates a new one fom input
        String borrower = getString("what is the username? ");
        for (int i = 0; i< BorrowerList.size(); i++){
            if( BorrowerList.get(i).getUsername().contains(borrower)){
                BorrowerList.remove(i);
                register();
                System.out.println( borrower + "has been edited");
            }
        }
    }

    public static void deleteborrower(){ //searches for username, thn deletes from array list
        String borrower = getString("what is the name?");
        for (int i = 0; i< BorrowerList.size();i++){
            if(BorrowerList.get(i).getUsername().contains(borrower)){
                BorrowerList.remove(i);
                System.out.println("deleted" + borrower);
            }
        }
    }

    public static void writebooktofile(){
        try {

           FileWriter writeto = new FileWriter(storedbooks);
           PrintWriter printto = new PrintWriter(writeto);
           for ( int i = 0; i < BookList.size();i++){
               printto.println(BookList.get(i).toString());
           }
            writeto.close();
        }
        catch ( Exception e){
            e.printStackTrace();
            System.out.println("uh oh an error (-.-);");
        }

    }

    public static void writeborrowertofile(){
        try {

            FileWriter writeto = new FileWriter(storedborrowers);
            PrintWriter printto = new PrintWriter(writeto);
            for ( int i = 0; i < BorrowerList.size();i++){
                printto.println(BorrowerList.get(i).toString());
            }
            writeto.close();
        }
        catch ( Exception e){
            e.printStackTrace();
            System.out.println("uh oh an error (-.-);");
        }


    }

    public static void readfromfile(){
        String linefromfile;
        try{
            BufferedReader read = new BufferedReader(new FileReader(storedbooks));
            while ((linefromfile = read.readLine()) != null){
                String [] bookdetails = linefromfile.split(",");
                String booktitle = bookdetails[0];
                Integer isbn = Integer.parseInt(bookdetails[1]);
                String author = bookdetails[2];
                String genre = bookdetails[3];
                books newbook = new books (booktitle, isbn, author, genre );
                BookList.add(newbook);
            }
        }
        catch ( Exception e){
            System.out.println("uh on error on reading ;-;");
            System.out.println(e);
        }
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
