package main.java;

public class Book implements Comparable<Book> {
    private String title;
    private String isbn;
    private Integer yearRelease;
    private Author author;
    
    public Book(String title, String isbn, int yearRelease, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.yearRelease = yearRelease;
        this.author = author;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public Integer getYearRelease() {
        return this.yearRelease;
    }
    
    public Author getAuthor() {
        return this.author;
    }
    
    public String getAuthorFullName(){
              return this.author.getFullName();
      }
   
    @Override
    public int compareTo(Book b) {
        return getYearRelease()- b.getYearRelease();
    }
    
     @Override
    public String toString() {
        return "Book : " + getTitle() + " - " + getIsbn() + " - " + getYearRelease()+ "\n";
    }
}
