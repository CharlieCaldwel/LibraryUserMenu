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
            String[] books = line.split("\\|");
            String bookTitle = books[0];
            String bookAuthor = books[1];
            int bookCopies = Integer.parseInt(books[2]);
            int bookYear = Integer.parseInt(books[3].trim());
            int bookMonth = Integer.parseInt(books[4].trim());
            int bookDay = Integer.parseInt(books[5].trim());
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

    private static User readUser(String line) {

        String[] users = line.split("\\|");
        
        String userName = users[0];
        String UserEmail = users[1];
        String UserPassword = users[2];
        Book book1 = null;
        if (users.length >= 8) {
            String bookTitle1 = users[3];
            String bookAuthor1 = users[4];
            int bookYear1 = Integer.parseInt(users[5].trim());
            int bookMonth1 = Integer.parseInt(users[6].trim());
            int bookDay1 = Integer.parseInt(users[7].trim());
            LocalDate date1 = LocalDate.of(bookYear1, bookMonth1, bookDay1);
            book1 = new Book(bookTitle1, bookAuthor1, date1);
        }
        Book book2 = null;
        if (users.length >= 13) {
            String bookTitle2 = users[8];
            String bookAuthor2 = users[9];
            int bookYear2 = Integer.parseInt(users[10].trim());
            int bookMonth2 = Integer.parseInt(users[11].trim());
            int bookDay2 = Integer.parseInt(users[12].trim());
            LocalDate date2 = LocalDate.of(bookYear2, bookMonth2, bookDay2);
            book2 = new Book(bookTitle2, bookAuthor2, date2);
        }
        Book book3 = null;
        if (users.length >= 18) {
            String bookTitle3 = users[13];
            String bookAuthor3 = users[14];
            int bookYear3 = Integer.parseInt(users[15].trim());
            int bookMonth3 = Integer.parseInt(users[16].trim());
            int bookDay3 = Integer.parseInt(users[17].trim());
            LocalDate date3 = LocalDate.of(bookYear3, bookMonth3, bookDay3);
            book3 = new Book(bookTitle3, bookAuthor3, date3);
        }

        return new User(userName, UserEmail, UserPassword, book1, book2, book3);
    }

    public static void writeUserV2(User user){
        StringBuilder userString = new StringBuilder();
        try {
            userString.append(user.name.toLowerCase())
                    .append("|").append(user.email.toLowerCase())
                    .append("|").append(user.password).append("|");

            for (int i = 0; i < 3; i++) {
                if (i < user.usersBooks.length && user.usersBooks[i] != null) {
                    userString.append(user.usersBooks[i].title).append("|")
                            .append(user.usersBooks[i].author).append("|")
                            .append(user.usersBooks[i].publishDate.getYear()).append("|")
                            .append(user.usersBooks[i].publishDate.getMonthValue()).append("|")
                            .append(user.usersBooks[i].publishDate.getDayOfMonth()).append("|");
                }
            }
            Files.writeString(Paths.get("UserData.txt"), userString + "\n", StandardOpenOption.APPEND);
        }
        catch (IOException e){
            System.out.println("Error writing to file");
        }
    }

}
