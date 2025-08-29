package com.mycompany.main;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    
    public static void main(String[] args) {

        Library lib = new Library();
        String answer = "no";

        try {
            for(Book book : ReadAndWriteFile.readBooks("Books.txt")) {
                lib.addBook(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            for(User user : ReadAndWriteFile.readUsers("UserData.txt")) {
                lib.addUser(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        User charlie = lib.getOneUser("bobby");
        if (charlie != null){
            System.out.println(charlie.name + " " + charlie.email);
        }



        try (Scanner scan = new Scanner(System.in)) {

            String option = "0";
            String line;

            System.out.println(Library.DisplayOptions());

            while (!option.equals("6")) {

                System.out.print("Enter option number: ");
                option = scan.nextLine();


                switch (option) {

                    case "1":
                        System.out.println("Book options: ");
                        break;

                    case "2":
                        System.out.println("Return options: ");
                        break;

                    case "3":
                        System.out.println("Fees due: ");
                        break;

                    case "4":
                        System.out.println("Books currently borrowed: ");
                        break;

                    case "5":
                        System.out.println("Name: ");
                        System.out.println("Library ID: ");
                        break;

                    case "6":
                        System.out.println("Logging out... ");
                        break;

                    case "7":
                        String userName;
                        String userEmail;
                        System.out.print("Name: ");
                        userName = scan.nextLine();
                        System.out.print("Email: ");
                        userEmail = scan.nextLine();
                        User user = new User(userName, userEmail);
                        lib.addUser(user);
                        ReadAndWriteFile.writeUser(user);
                        System.out.println("\n");
                        lib.getUsers();
                        break;

                    default:
                        System.out.println("Invalid input");

                }
            }
        }  // end scanner
    } // end void main

} // end Main

