package com.mycompany.main;


public class User{

    String name;
    String email;
    String password;
    Book[] usersBooks = new Book[3];


    public User(String name, String email, String password){

        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User(String name, String email, String password, Book usersBooks1){
        this.name = name;
        this.email = email;
        this.password = password;
        this.usersBooks[0] = usersBooks1;
    }

    public User(String name, String email, String password, Book usersBooks1, Book usersBooks2){
        this.name = name;
        this.email = email;
        this.password = password;
        this.usersBooks[0] = usersBooks1;
        this.usersBooks[1] = usersBooks2;
    }

    public User(String name, String email, String password, Book usersBooks1, Book usersBooks2, Book usersBooks3){
        this.name = name;
        this.email = email;
        this.password = password;
        this.usersBooks[0] = usersBooks1;
        this.usersBooks[1] = usersBooks2;
        this.usersBooks[2] = usersBooks3;
    }

    public void addBook(Book book){
        if(usersBooks[0] == null){
            usersBooks[0] = book;
        }
        else if(usersBooks[1] == null){
            usersBooks[1] = book;
        }
        else if(usersBooks[2] == null){
            usersBooks[2] = book;
        }
    }


}
