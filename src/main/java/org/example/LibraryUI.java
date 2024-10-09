package org.example;

public class LibraryUI {

    private Library library;

    public LibraryUI(Library library) {
        this.library = library;
    }

    public String getBookTitleByIsbn(String isbn) {
        Book book = library.getBook(isbn);
        return book.getTitle();
    }
}
