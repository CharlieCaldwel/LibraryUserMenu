package com.mycompany.main;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    
    public static void main(String[] args) {

        Library lib = new Library();
        String answer = "no";
        User ActiveUser = null;
        String ActiveUserPassword = "abc";

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

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("━ Welcome to the Library Management System ━");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Please login to continue: ");

        while(ActiveUser == null || !ActiveUserPassword.equals(ActiveUser.password)) {
            int PassAttempts = 0;
            try {
                System.out.print("Email: ");
                ActiveUser = lib.getOneUser(new Scanner(System.in).nextLine());
                while (PassAttempts < 4) {
                    if (ActiveUser != null) {
                        System.out.print("Password: ");
                        ActiveUserPassword = new Scanner(System.in).nextLine();
                    }
                    if (!ActiveUserPassword.equals(ActiveUser.password)) {
                        System.out.println("\nInvalid Password");
                        PassAttempts++;
                        System.out.println("You have " + (4 - PassAttempts) + " attempts left\n");
                    }
                    if (ActiveUserPassword.equals(ActiveUser.password)) {
                        PassAttempts = 4;
                    }
                }
            }
            catch (NullPointerException e) {
                System.out.println("User not found");
            }
        }

        lib.removeUser(ActiveUser);
        lib.getUsers();

        try (Scanner scan = new Scanner(System.in)) {

            String option = "0";
            String line;


            while (!option.equals("6")) {

                Library.ClearDisplay();
                System.out.println(Library.DisplayOptions());
                System.out.print("Enter option number: ");
                option = scan.nextLine();


                switch (option) {

                    case "1":
                        Library.ClearDisplay();
                        System.out.println("Book options: ");
                        lib.getBooks();
                        System.out.print("\nEnter book title or author you wish to borrow: ");
                        String searchWord = scan.nextLine();
                        Book borrowBook = lib.getBook(searchWord);
                        if(borrowBook != null) {
                            System.out.println("Do you want to borrow " + borrowBook.title + " by " + borrowBook.author + "? (yes/no): ");
                            answer = scan.nextLine();
                            if (answer.equalsIgnoreCase("yes")) {
                                ActiveUser.addBook(borrowBook);
                            }
                        }
                        else{
                            System.out.println("Book not found");
                        }
                        break;

                    case "2":
                        System.out.println("Return options: ");
                        break;

                    case "3":
                        System.out.println("Fees due: ");
                        break;

                    case "4":
                        System.out.println("Books currently borrowed: ");
                        System.out.println(ActiveUser.usersBooks[0].title);
                        break;

                    case "5":
                        System.out.println("Name: ");
                        System.out.println("Library ID: ");
                        break;

                    case "6":
                        lib.addUser(ActiveUser);
                        try {
                            lib.RewriteUsers();
                        }
                        catch (IOException e) {
                            System.out.println("Failed to rewrite users file");
                        }
                        System.out.println("Thank you for using the Library Management System");
                        System.out.println("Logging out... ");
                        break;

                    case "addUser":
                        System.out.println("Add new user\n") ;
                        System.out.print("Name: ");
                        String userName = scan.nextLine();
                        System.out.print("Email: ");
                        String userEmail = scan.nextLine();
                        System.out.print("Password: ");
                        String userPassword = scan.nextLine();
                        System.out.print("Re-enter password: ");
                        String userPassword2 = scan.nextLine();
                        if(userPassword.equals(userPassword2)) {
                            User user = new User(userName, userEmail, userPassword);
                            lib.addUser(user);
                            ReadAndWriteFile.writeUser(user);
                        }
                        else{
                            System.out.println("Passwords do not match");
                        }
                        System.out.println("\n");
                        lib.getUsers();
                        break;

                    default:
                        System.out.println("Invalid input");

                }
                if(!option.equals("6")) {
                    System.out.println("\n Press enter to continue");
                    scan.nextLine();
                }
            }
        }  // end scanner
    } // end void main

} // end Main

