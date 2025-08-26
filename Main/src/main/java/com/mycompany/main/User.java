package com.mycompany.main;


public class User{

    String name;
    String email;
    String[] usersBooks = new String[3];

    static int userID = 0;
    int id = 0;


    public User(String name, String email){

        this.name = name;
        this.email = email;

        userID ++;
        this.id = userID;

    }

}
