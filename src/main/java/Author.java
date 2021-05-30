package main.java;

public class Author {
    private String name;
    private String surname;
    private Integer yearBorn;
    
    public Author(String name, String surname, Integer yearBorn) {
        this.name = name;
        this.surname = surname;
        this.yearBorn = yearBorn;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public Integer getYearBorn() {
        return this.yearBorn;
    }
    public String getFullName() {
        return getName() + " " + getSurname() + " " + getYearBorn();
    }
}
