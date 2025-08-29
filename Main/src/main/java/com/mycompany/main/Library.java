package com.mycompany.main;
import java.util.ArrayList;
import java.util.List;


public class Library{

   private List<User> users = new ArrayList<>();
   private List<Book> books = new ArrayList<>();


    static String DisplayOptions(){
    return
            """
                    \nHello what would you like to do \
                    
                    
                    ⌈1⌉ Borrow a book \
                    
                    |2| Return a book \
                    
                    |3| Check outstanding fees \
                    
                    |4| Current books \
                    
                    |5| View Profile\
                    
                    ⌊6⌋ Logout""";



    } // end DisplayOptions

    static void ClearDisplay(){
         for( int i = 0; i < 25; i ++){
             System.out.println("\n");
        }
    } // end ClearDisplay

    public void addUser(User user){

        users.add(user);

    } //end addUser

    public void removeUser(User user){

        users.remove(user);

    } // end removeUser

    public void getUsers(){

        for(User user : users){

            System.out.println("Name: " + user.name + ", Email: " + user.email);

        }

    } // end getUser

    public User getOneUser(String searchWord){
        int i = 0;
        for(User user : users){
            if(!users.isEmpty()) {
                if (user.name.contains(searchWord.toLowerCase()) || user.email.contains(searchWord.toLowerCase())) {
                    return user;
                }
                System.out.println("i = " + i + "Users size = " + users.size());
                if (i == users.size()) {
                    System.out.println("User not found");
                }
                i++;
            }
        }
        return null;
    }

    public void addBook(Book book){

        books.add(book);

    } // end addBook

    public void removeBook(Book book){

        books.remove(book);

    } // end removeBook

    public int getBookCount(){
        return books.size();
    }

    public Book getBook(String searchWord) {
        Book bookFound = null;
        for (Book book : books) {
            if (book.title.contains(searchWord) || book.author.contains(searchWord)) {
                System.out.println("Book found: ");
                System.out.println("Book: " + book.title + ", Author: " + book.author + ", Copies: " + book.copies + ", Publish Date: " + book.publishDate);
                bookFound = book;
            }
        }
        return bookFound;
    } // end getBook

    public void getBookCopies(Book book){

        System.out.println("Amount of copies left: " + book.copies );

    } // end getBookCopies

} // end Library
