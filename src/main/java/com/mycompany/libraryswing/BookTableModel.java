package com.mycompany.libraryswing;

import com.mycompany.model.Book;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.table.*;

/**
 *
 * @author Ellina This is a class for a custom TableModel to display a list of
 * books
 *
 */
public class BookTableModel extends AbstractTableModel {

    private List<Book> showListBooks;
    private List<Book> listBooks;
    private Comparator<Book> autorSorter;
    private Comparator<Book> genreSorter;
    private String[] columns = {
        "Id",
        "Title",
        "Autor",
        "Jahr",
        "Genre",};

    /**
     * Constructs a new BookTableModel instance.
     *
     * @param listBooks the list of books to be displayed in the table
     */
    public BookTableModel(List<Book> listBooks) {
        // Create comparators for sorting books by author and genre
        autorSorter = (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor());
        genreSorter = (b1, b2) -> b1.getGenre().compareTo(b2.getGenre());
        // Populate the list of books to be displayed and filter it to show only books without readers,
        // that is, books that are in the library and not with the readers.
        readListBooks(listBooks);
    }

    /**
     * Populates the list of books to be displayed and filters it to show only
     * books without readers.
     *
     * @param listBooks the list of books to be displayed in the table
     */
    private void readListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
        filterWithautReader();

    }

    @Override
    public int getRowCount() {
        return showListBooks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book b = getBook(rowIndex);
        switch (columnIndex) {
            case 0:
                return b.getIdBook();
            case 1:
                return b.getName();
            case 2:
                return b.getAuthor();
            case 3:
                return b.getYear();
            case 4:
                return b.getGenre();
            default:
                throw new AssertionError();
        }
    }

    /**
     * Sorts the list of books by author and updates the table.
     */
    public void sortAutor() {
        sort(autorSorter);
    }

    /**
     * Sorts the list of books by genre and updates the table.
     */
    public void sortGenre() {
        sort(genreSorter);
    }

    /**
     * Sorts the list of books using the specified comparator and updates the
     * table.
     *
     * @param c the comparator used for sorting the books
     */
    private void sort(Comparator<Book> c) {
        showListBooks.sort(c);
        fireTableDataChanged();
    }

    /**
     * Filters the list of books to show only books without readers.
     */
    private void filterWithautReader() {
        List<Book> showBooks = listBooks
                .stream()
                .filter(b -> b.getReader() == null)
                .collect(Collectors.toList());
        this.showListBooks = showBooks;
    }

    public Book getBook(int index) {
        if (index >= 0 && index < showListBooks.size()) {
            return showListBooks.get(index);
        }
        return null;
    }

    /**
     * Sets the list of books for this table
     */
    public void getBooksInTable(List<Book> books) {
        readListBooks(books);
        fireTableDataChanged();
    }
}
