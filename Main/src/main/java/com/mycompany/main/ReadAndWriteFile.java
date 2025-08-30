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
        List<Book> bookList = new ArrayList<>();
        if(!line.isEmpty()) {
            String[] books = line.split("\n");

            for (String book : books) {
                bookList.add(readBook(book));
            }
        }
        return bookList;
    }

    private static Book readBook(String line){
        if(!line.isEmpty()) {
            String bookTitle = line.split("\\|")[0];
            String bookAuthor = line.split("\\|")[1];
            int bookCopies = Integer.parseInt(line.split("\\|")[2]);
            int bookYear = Integer.parseInt(line.split("\\|")[3].trim());
            int bookMonth = Integer.parseInt(line.split("\\|")[4].trim());
            int bookDay = Integer.parseInt(line.split("\\|")[5].trim());
            LocalDate date = LocalDate.of(bookYear, bookMonth, bookDay);
            return new Book(bookTitle, bookAuthor, bookCopies, date);
        }
        return null;
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
        String UserPassword = line.split("\\|")[2];

        return new User(userName, UserEmail, UserPassword);
    }

    public static void writeUser(User user){
        try{
            if(user.usersBooks[0] != null) {
                String userString = user.name.toLowerCase() + "|" + user.email.toLowerCase() + "|" + user.password + "|"
                        + user.usersBooks[0].title + "|" + user.usersBooks[0].author + "|" + user.usersBooks[0].publishDate.getYear() + "|" + user.usersBooks[0].publishDate.getMonthValue() + "|" + user.usersBooks[0].publishDate.getDayOfMonth()
                        + "|" + "|" + "|" + "|"
                        + "|" + "|" + "|" + "|";
                Files.writeString(Paths.get("UserData.txt"), userString + "\n", StandardOpenOption.APPEND);
            }
            else if(user.usersBooks[1] != null) {
                String userString = user.name.toLowerCase() + "|" + user.email.toLowerCase() + "|" + user.password + "|"
                        + user.usersBooks[0].title + "|" + user.usersBooks[0].author + "|" + user.usersBooks[0].publishDate.getYear() + "|" + user.usersBooks[0].publishDate.getMonthValue() + "|" + user.usersBooks[0].publishDate.getDayOfMonth()
                        + user.usersBooks[1].title + "|" + user.usersBooks[1].author + "|" + user.usersBooks[1].publishDate.getYear() + "|" + user.usersBooks[1].publishDate.getMonthValue() + "|" + user.usersBooks[1].publishDate.getDayOfMonth()
                        + "|" + "|" + "|" + "|";
                Files.writeString(Paths.get("UserData.txt"), userString + "\n", StandardOpenOption.APPEND);
            }
            else if(user.usersBooks[2] != null) {
                String userString = user.name.toLowerCase() + "|" + user.email.toLowerCase() + "|" + user.password + "|"
                        + user.usersBooks[0].title + "|" + user.usersBooks[0].author + "|" + user.usersBooks[0].publishDate.getYear() + "|" + user.usersBooks[0].publishDate.getMonthValue() + "|" + user.usersBooks[0].publishDate.getDayOfMonth()
                        + user.usersBooks[1].title + "|" + user.usersBooks[1].author + "|" + user.usersBooks[1].publishDate.getYear() + "|" + user.usersBooks[1].publishDate.getMonthValue() + "|" + user.usersBooks[1].publishDate.getDayOfMonth()
                        + user.usersBooks[2].title + "|" + user.usersBooks[2].author + "|" + user.usersBooks[2].publishDate.getYear() + "|" + user.usersBooks[2].publishDate.getMonthValue() + "|" + user.usersBooks[2].publishDate.getDayOfMonth();
                Files.writeString(Paths.get("UserData.txt"), userString + "\n", StandardOpenOption.APPEND);
            }
            else{
                String userString = user.name.toLowerCase() + "|" + user.email.toLowerCase() + "|" + user.password + "|"
                        + "|" + "|" + "|" + "|"
                        + "|" + "|" + "|" + "|"
                        + "|" + "|" + "|" + "|";
                Files.writeString(Paths.get("UserData.txt"), userString + "\n", StandardOpenOption.APPEND);
            }

        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
