package com.webdev2;

/**
 * Domain class representing a book.
 * Plain Java object stored in an in-memory list — no database required.
 */
public class Book {

    private final int    id;
    private final String title;
    private final String author;
    private final double price;

    public Book(int id, String title, String author, double price) {
        this.id     = id;
        this.title  = title;
        this.author = author;
        this.price  = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Book{id=%d, title='%s', author='%s', price=%.2f}",
                id, title, author, price);
    }
}
