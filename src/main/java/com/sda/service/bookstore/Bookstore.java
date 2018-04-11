package com.sda.service.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private final List<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }
    public void add(Book book){
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void upadateBook(Book book, String title){
        books.get(books.indexOf(book)).setTitle(title);
    }

}
