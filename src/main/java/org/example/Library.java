package org.example;

import java.util.ArrayList;
import java.util.List;


public class Library {

    private List<Book> books = new ArrayList<>();

    public Library() {}

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        //remove book with isbn
        books.remove(getBook(isbn));
    }

    public boolean doesBookExist(String isbn) {
        for (Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public void updateBook(String isbn, Book updatedBook) {
        for (Book book : books) {
            if(book.getIsbn().equals(isbn)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setYear(updatedBook.getYear());
                book.setIsbn(updatedBook.getIsbn());
            }
        }
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
