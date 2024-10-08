package org.example;

import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {}

    public void addBook(Book book) {
        //add a book to books
    }

    public void removeBook(String isbn) {
        //remove book with isbn
    }

    public void updateBook(String isbn, Book updatedBook) {
        //update a book
    }

    public Book getBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        //Show all books
    }
}
