package com.mycompany.model;

import com.mycompany.libraryswing.MyTools;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * The Library class represents a library with a list of books and readers.
 * It provides methods for managing books, readers, and library operations.
 * 
 *  @author Ellina
 */
public class Library {

    private List<Book> listBooks;  // List of books in the library
    private List<Reader> listReaders; // List of readers in the library
    private Reader currentReader = null; // Currently logged-in reader

    public Library() {
        this.listBooks = new ArrayList<>();
        this.listReaders = new ArrayList<>();
    }

    /**
     * Constructor with parameters. Creates a library with given lists of books
     * and readers.
     *
     * @param listBooks List of books
     * @param listReaders List of readers
     */
    public Library(List<Book> listBooks, List<Reader> listReaders) {
        this.listBooks = listBooks;
        this.listReaders = listReaders;
    }

    public Reader getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(Reader currentReader) {
        this.currentReader = currentReader;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public List<Reader> getListReaders() {
        return listReaders;
    }

    public void setListReaders(List<Reader> listReaders) {
        this.listReaders = listReaders;
    }

    public void setListBook(List<Book> listBook) {
        this.listBooks = listBook;
    }

    /**
     * Generates lists of readers and books with random data.
     *
     * @param zahlBook Number of books to generate
     * @param zahlReader Number of readers to generate
     */
    public void generatorList(int zahlBook, int zahlReader) {
        // generating readers using the Faker
        for (int i = 0; i < zahlReader; i++) {
            Reader r = new Reader().generateReader();
            listReaders.add(r);
            r.setIdReader(i + 2);
        }
        // Add a fixed reader for ease of demonstration (fixed user) 
        listReaders.add(new Reader(1, "Thea", "Weis", LocalDate.of(1985, 1, 1)));
        // generating books using the Faker
        for (int i = 0; i < zahlBook; i++) {
            Book b = new Book().generateBook();
            listBooks.add(b);
            b.setIdBook(i + 1);
            //for every second book, we simulate the situation that it is in the hands of a randomly selected reader
            if (i % 2 == 1) {
                b.setReader(listReaders.get(MyTools.generatInt(listReaders.size()) - 1));
            }
        }
    }

    public void clearLibrary() {
        listBooks.clear();
        listReaders.clear();
    }

    public void whritLibraryInFile() throws FileNotFoundException, IOException {
        Path path = Paths.get("lines.txt");

        System.out.println("Gibt es die File " + Files.exists(path));
        try (
                 PrintWriter pw = new PrintWriter("lines.txt");) {

            listBooks.forEach(b -> pw.println(b.toString()));

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /*
    * method takes a login and password as input and tries to find a matching reader in the list of readers. 
    * If a matching reader is found, 
    * it sets that reader as the current reader and displays a welcome message
    * @param login
    * @param pass
     */
    
    public boolean chooseCurReader(String login, char[] pass) {

        this.getListReaders().forEach(System.out::println);
        System.out.println(login);
        Optional<Reader> optionalReader = this.getListReaders()
                .stream()
                .filter(r -> r.getLogin().equals(login))
                .filter(r -> Arrays.equals(r.getPass().toCharArray(), pass))
                .findFirst();
        if (optionalReader.isPresent()) {
            currentReader = optionalReader.get();
            System.out.println("Welcome " + currentReader.getFirstName() + " " + currentReader.getLastName());

            return true;
        }
        return false;

    }

    public List<Book> getUsersBook(Reader reader) {

        List<Book> readersBook
                = this.getListBooks()
                        .stream()
                        .filter(b -> b.getReader() != null)
                        .filter(b -> b.getReader().equals(reader))
                        .collect(Collectors.toList());
        readersBook.forEach(System.out::println);
        return readersBook;

    }

//    public void showUndReturnUsersBook(boolean returnBook) {
//        if (currentReader != null) {
//
//            Reader searchReader = currentReader;
//            System.out.println("Risers Name: " + currentReader.getFirstName() + " " + currentReader.getLastName());
//            List<Book> readersBook
//                    = this.getListBooks()
//                            .stream()
//                            .filter(b -> b.getReader() != null)
//                            .filter(b -> b.getReader().equals(searchReader))
//                            .collect(Collectors.toList());
//
//            if (!readersBook.isEmpty()) {
//                System.out.println("Ihre Bücher: ");
//                readersBook.forEach(System.out::println);
//                if (returnBook) {
//                    readersBook.forEach(b -> b.setReader(null));
//                    System.out.println("Ihre Bücher wurden zurückgegeben. Danke.");
//                }
//            } else {
//                System.out.println("Sie haben keine ausgeliehene Bücher!");
//            }
//
//        }
//    }

}
