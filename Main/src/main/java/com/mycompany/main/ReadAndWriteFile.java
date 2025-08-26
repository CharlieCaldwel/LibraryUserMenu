package com.mycompany.main;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDate;

public class ReadAndWriteFile {


    public static String readFile(String filePath) throws IOException {
        String file = Files.readString(Paths.get(filePath));
        return file;
    }

    public static Book readBooks(String file) throws IOException {
        String line;
        line = ReadAndWriteFile.readFile("Books.txt");
        String[] books = line.split("\n");

        for( String book : books){
            String bookTitle = book.split("\\|")[0];
            String bookAuthor = book.split("\\|")[1];
            int bookCopies = Integer.parseInt(book.split("\\|")[2]);
            int bookYear = Integer.parseInt(book.split("\\|")[3].trim());
            int bookMonth = Integer.parseInt(book.split("\\|")[4].trim());
            int bookDay = Integer.parseInt(book.split("\\|")[5].trim());
            LocalDate date = LocalDate.of(bookYear, bookMonth, bookDay);
            Book newBook = new Book(bookTitle, bookAuthor, bookCopies, date);
            return newBook;
        }
        return null;
    }
}
