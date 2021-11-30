package com.company;

import java.io.File;
import java.io.FileWriter;
import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {
    public static File books = new File("books");

    public static void main(String[] args) {
        System.out.println("what would you like to do?");
        System.out.println("1. register a book");
        int task = Integer.parseInt("enter number associated with task: ");
        switch(task){
            case(1):
                bookdetails();
                FileWriter mywriter =
             //**************you were here**************************
             //making what you receive from the method save to the external file


        }

        }



    public static String bookdetails(){
        String booktitle = getString("enter book title:");
        int isbn = Integer.parseInt(getString("enter the ISBN: "));
        String author = getString("enter the author: ");
        String genre = getString("enter the author: ");
        return (booktitle+ "%" + isbn + "%" + author +"%"+ genre);
        //good use of delibrators
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
