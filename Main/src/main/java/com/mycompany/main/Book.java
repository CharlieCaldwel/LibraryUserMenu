package com.mycompany.main;
import java.time.LocalDate;


public class Book {
    String title;
    String author;
    int copies;
    LocalDate publishDate;

    public Book(String title, String author, int copies, LocalDate publishDate){
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.publishDate = publishDate;
    }

    public Book(String title, String author, LocalDate publishDate){
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.copies = 1;
    }
}
