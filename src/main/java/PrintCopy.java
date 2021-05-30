package main.java;

public class PrintCopy extends Book {
    private Integer numberOfPages;
    private Double weight;
    
    public PrintCopy(String title, String isbn, Integer yearRelease, Author author, Integer numberOfPages, Double weight) {
        super(title, isbn, yearRelease, author);
        this.numberOfPages = numberOfPages;
        this.weight = weight;
    }
}   