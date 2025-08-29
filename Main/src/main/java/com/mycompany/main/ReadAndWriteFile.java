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

    public static List<User> readUsers(String file) throws IOException {
        String line;
        List<User> userList = new ArrayList<>();
        line = ReadAndWriteFile.readFile("UserData.txt");

        if(!line.isEmpty()) {
            String[] users = line.split("\n");

            for (String user : users) {
                userList.add(readUser(user));
            }
        }
        return userList;
    }

    private static User readUser(String line){

        String userName = line.split("\\|")[0];
        String UserEmail = line.split("\\|")[1];
        return new User(userName, UserEmail);
    }

    public static void writeUser(User user){
        try{
            String userString = user.name.toLowerCase() + "|" + user.email.toLowerCase();
            Files.writeString(Paths.get("UserData.txt"), userString + "\n", StandardOpenOption.APPEND);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
