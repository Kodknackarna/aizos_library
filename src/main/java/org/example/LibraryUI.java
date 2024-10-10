package org.example;

import java.util.ArrayList;
import java.util.List;

public class LibraryUI {

    private Library library;

    public LibraryUI(Library library) {
        this.library = library;
    }

    public String getBookTitleByIsbn(String isbn) {
        Book book = library.getBook(isbn);
        return book.getTitle();
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> allBooks = library.listBooks();
        List<Book> authorsBooks = new ArrayList<Book>();
        for(Book book : allBooks){
            if(book.getAuthor().equals(author)){
                authorsBooks.add(book);
            }
        }
        return authorsBooks;
    }
}
