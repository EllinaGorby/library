/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libraryswing;

import com.mycompany.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Ellina
 */
public class ListModelUsersBooks extends AbstractListModel<Book> {

    private List<Book> listBooks;

    public ListModelUsersBooks() {
        listBooks = new ArrayList<>();
    }

    public ListModelUsersBooks(List<Book> listBooks) {
        listBooks = new ArrayList<>();
        this.listBooks = listBooks;
    }

    @Override
    public int getSize() {
        return listBooks.size();
    }

    @Override
    public Book getElementAt(int index) {
        return listBooks.get(index);
    }
    
    public void getBooksInList(List<Book> books) {
            listBooks = books;
            fireContentsChanged(this, 0, getSize());
        }

}
