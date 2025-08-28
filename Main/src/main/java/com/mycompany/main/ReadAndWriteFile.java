package com.mycompany.main;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWriteFile {


    public static String readFile(String filePath) throws IOException {
        String file = Files.readString(Paths.get(filePath));
        return file;
    }

    public static List<Book> readBooks(String file) throws IOException {
        String line;

        line = ReadAndWriteFile.readFile("Books.txt");
        String[] books = line.split("\n");
        List<Book> bookList = new ArrayList<>();

        for( String book : books){
            bookList.add(readBook(book));
        }
        return bookList;
    }

    private static Book readBook(String line){
        String bookTitle = line.split("\\|")[0];
        String bookAuthor = line.split("\\|")[1];
        int bookCopies = Integer.parseInt(line.split("\\|")[2]);
        int bookYear = Integer.parseInt(line.split("\\|")[3].trim());
        int bookMonth = Integer.parseInt(line.split("\\|")[4].trim());
        int bookDay = Integer.parseInt(line.split("\\|")[5].trim());
        LocalDate date = LocalDate.of(bookYear, bookMonth, bookDay);
        return new Book(bookTitle, bookAuthor, bookCopies, date);
    }
}
