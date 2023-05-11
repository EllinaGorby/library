package com.mycompany.model;

import com.github.javafaker.Faker;
import java.util.Locale;

/**
 *
 * Represents a Book object with various properties such as id, name, publisher, author, genre, year, and reader.
 * The class also provides methods for setting and getting book information and 
 * methods for generating random book information
 * 
 * @author: Ellina
 */
public class Book {

    private long idBook;
    private String name;
    private String publisher;
    private String author;
    private String genre;
    private int year;
    private Reader reader;

    public Book() {
    }

    /**
     * Konstruktor für die Klasse Book mit Parametern.
     *
     * @param idBook ID des Buches
     * @param name Name des Buches
     * @param publisher Verlag des Buches
     * @param author Autor des Buches
     * @param genre Genre des Buches
     * @param year Jahr des Buches
     */
    public Book(int idBook, String name, String publisher, String author, String genre, int year) {
        this.idBook = idBook;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public long getIdBook() {
        return idBook;
    }

    public int getYear() {
        return year;
    }

    public Reader getReader() {
        return reader;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    /**
     * Generates a random Book object using the Faker library.
     *
     * @return The generated Book object.
     */
    public Book generateBook() {
        Faker f = new Faker(Locale.GERMANY);
        name = f.book().title();
        publisher = f.book().publisher();
        author = f.book().author();
        genre = f.book().genre();
        year = f.date().birthday().getYear() + 1900;

        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) this.idBook;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        return this.idBook == other.idBook;
    }

    @Override
    public String toString() {
        return "id: " + idBook + ", " + name + ", aut.: " + author + ", pub: " + publisher + ", year=" + year + ", gen:" + genre;
    }
    
    /**
     *  methods for outputting an object to the console in various options
     *
     * @return String
     */
    
    public String toStringKurz() {
        return "id: " + idBook + ", " + name + ", aut.: " + author;
    }
//
//    public String toStringFirstAuthor() {
//        return author + ", id: " + idBook + ", " + name + ", pub: " + publisher + ", year=" + year + ", gen:" + genre + ", r: " + reader;
//    }
//
//    public String toStringFirstGenre() {
//        return genre + ", id: " + idBook + ", " + name + ", aut.: " + author + ", pub: " + publisher + ", year=" + year + ", r: " + reader;
//    }
}
