package com.mycompany.main;
import java.util.Date;

public class Book {
    String title;
    String author;
    int copies;
    Date publishDate;

    public Book(String title, String author, int copies, Date publishDate){
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.publishDate = publishDate;
    }
}
