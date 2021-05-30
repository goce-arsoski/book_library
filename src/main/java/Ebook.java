package main.java;

public class Ebook extends Book {
    
     public enum Format {
        EPUB,
        PDF,
        HTML5;
    } 
    private Format format;
    private Integer size;
    
   public Ebook(String title, String isbn, Integer yearRelease, Author author, Format format, Integer size) {
       super(title, isbn, yearRelease, author);
       this.format = format;
       this.size = size;
   }
}