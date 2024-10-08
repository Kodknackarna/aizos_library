package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {


    @Test
    void addBookTest(){
        //given
        Library library = new Library();

        //when
        library.addBook(new Book("Harry Potter", "JK Rowling", 1994, "3545"));
        library.addBook(new Book("", "", 1922, "3345"));
        library.addBook(new Book("Sagan om Ringen", "Tolkien", 1992, ""));

        //then
        assertEquals("Harry Potter", library.getBook("3545").getTitle());
        assertNull(library.getBook("3345"));
        assertNull(library.getBook(""));
        //assertThrows(IllegalArgumentException);

    }

    @Test
    void removeBookTest(){
        //given
        Library library = new Library();

        //when
        library.removeBook("3345");

        //then
        assertNull(library.getBook("3345"));

    }

    @Test
    void updateBookTest(){
        //given
        Library library = new Library();

        //when
        library.updateBook("Harry Potter", new Book("Ny titel", "Ny författare", 1992, "Nytt ISBN"));

        //then
        assertEquals("New Author", library.getBook("3545").getAuthor());
    }
}