package com.mycompany.main;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {

        Library users = new Library();

        try (Scanner scan = new Scanner(System.in)) {

            String option = "0";
            String line;

            System.out.println(Library.DisplayOptions());

                Book book = ReadAndWriteFile.readBooks("Books.txt");
                users.addBook(book);
                System.out.println(users.books.size());

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

                    default:
                        System.out.println("Invalid input");

                }
            }
        }  // end scanner
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end void main
} // end Main

