package org.example;

import java.time.Year;

public class Book {
    private String title;
    private String author;
    private int year;
    private String isbn;

    public Book(String title, String author, int year, String isbn) {
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || year < -10000 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Title, author, and ISBN cannot be empty");
        } else {
            this.title = title;
            this.author = author;
            this.year = year;
            this.isbn = isbn;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
