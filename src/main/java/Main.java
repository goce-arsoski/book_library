package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Author harryPotterAuthor = new Author("Joanne", "Rowling", 1965);
        Author lordOfTheRingsAuthor = new Author("John Ronald", "Tolkien", 1892);
        Author structuresAndAlgorithmsAuthor = new Author("Robert", "Lafore", 1938);
        Author gamblingManAuthor = new Author("David", "Baldacci", 1960);
        Author silentPatientAuthor = new Author("Alex", "Michaelides", 1977);
        Author testAuthor = new Author("Goce", "Arsoski", 2000);

        Book printCopyOne = new PrintCopy("Harry Potter", "978-1-56619-909-4", 2000, harryPotterAuthor, 223, 2.5);
        Book printCopyTwo = new PrintCopy("The Lord of the Rings", "9780544003415", 1954, lordOfTheRingsAuthor, 1178, 3.2);
        Book printCopyThree = new PrintCopy("Data Structures and Algorithms in Java", "978-0672324536", 2002, structuresAndAlgorithmsAuthor, 800, 1.5);

        Book eBookOne = new Ebook("A Gambling Man", "9781529061819", 1999, gamblingManAuthor, Ebook.Format.EPUB, 10);
        Book eBookTwo = new Ebook("The Silent Patient", "9781250301710", 2021, silentPatientAuthor, Ebook.Format.PDF, 8);
        Book eBookThree = new Ebook("Test1", "9781250301714", 2019, silentPatientAuthor, Ebook.Format.HTML5, 4);
        Book eBookFour = new Ebook("Test2", "97812503017122", 2015, silentPatientAuthor, Ebook.Format.PDF, 9);
        Book eBookFive = new Ebook("Test3", "9781250301715", 2013, silentPatientAuthor, Ebook.Format.EPUB, 3);
        Book eBookSix = new Ebook("Test4", "9781250301723", 1998, testAuthor, Ebook.Format.EPUB, 6);

        List<Book> books = new ArrayList<Book>();
        books.add(printCopyOne);
        books.add(printCopyTwo);
        books.add(printCopyThree);
        books.add(eBookOne);
        books.add(eBookTwo);
        books.add(eBookThree);
        books.add(eBookFour);
        books.add(eBookFive);
        books.add(eBookSix);

        //2.а)
        PrintBooks(books);

        //2.б)
        System.out.println("Enter a character: ");
        Scanner s = new Scanner(System.in);
        char c = s.next().charAt(0);
        PrintBooksBySpecificAuthor(books, c);
        
        //2.в)
        FindAuthorsByDecades(books);

        //2.г)
        PrintAuthorsWithMoreThanThreeBooks(books);
        
        //2.д)
        FindOldestAndNewestBook(books);
    }

    public static void PrintBooks(List<Book> books) {
        Collections.sort(books);
        System.out.println(books);
    }

    public static void PrintBooksBySpecificAuthor(List<Book> books, char startChar) {
        List<Book> matchedBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().getSurname().toLowerCase().charAt(0) == Character.toLowerCase(startChar)) {
                matchedBooks.add(book);
            }
        }
        if (matchedBooks.isEmpty()) {
            System.out.println("No Author matched");
        } else {
            System.out.println(matchedBooks);
        }
    }
    // test
    public static void FindAuthorsByDecades(List<Book> books) {
        for (Book author : books) {
            Integer yearFrom = (author.getAuthor().getYearBorn() / 10) * 10;
            Integer yearTo = ((author.getAuthor().getYearBorn() + 10) / 10) * 10;
            System.out.println("In decade when " + author.getAuthorFullName() + " was born, these books are written:");

            for (Book book : books) {
                if((book.getYearRelease() >= yearFrom) && (book.getYearRelease() <= yearTo)) {
                    System.out.println("- " + book.getTitle());
                }
            }
        }
    }

    public static void PrintAuthorsWithMoreThanThreeBooks(List<Book> books) {
        Map<String, Long> authorsWithBooks = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthorFullName, Collectors.counting()));
        authorsWithBooks.forEach((k, v) -> {
            if (v > 3) {
                System.out.println(k);
            }
        });
    }

    public static void FindOldestAndNewestBook(List<Book> books) {
        if (!books.isEmpty()) {
            Book oldest = books.get(0);
            Book newset = oldest;
            for (Book book : books) {
                if (book.getYearRelease()< oldest.getYearRelease()) {
                    oldest = book;
                }
                if(book.getYearRelease()> newset.getYearRelease()){
                    newset = book;
                }
            }
            System.out.println("The oldest is " + oldest + " " + "and the newest is " + newset);
        }
        else {
            System.out.println("Book list is empty");
        }
    }
}