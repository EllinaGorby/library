package com.mycompany.libraryswing;

import com.mycompany.model.Book;
//import com.mycompany.libraryswing.entity.Book;

import java.util.*;
import java.util.stream.Collectors;
import javax.swing.table.*;

/**
 *
 * @author Ellina
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

//    public BookTableModel() {
//        this.listBooks = new ArrayList<>();
//    }
    public BookTableModel(List<Book> listBooks) {
        autorSorter = (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor());
        genreSorter = (b1, b2) -> b1.getGenre().compareTo(b2.getGenre());
        readListBooks(listBooks);
    }

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

    public void sortAutor() {
        sort(autorSorter);
    }

    public void sortGenre() {
        sort(genreSorter);
    }

    private void sort(Comparator<Book> c) {
        showListBooks.sort(c);
        fireTableDataChanged();
    }

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

    public void getBooksInTable(List<Book> books) {
        readListBooks(books);
        fireTableDataChanged();
    }
}
