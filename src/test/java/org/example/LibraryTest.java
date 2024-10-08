package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {


    @Test
    void addBookTest(){
        //given
        Library library = new Library();

        //when
        library.addBook("Harry Potter", "JK Rowling", 1994, "3545");
        library.addBook("", "", 1922, "3345");
        library.addBook("Sagan om Ringen", "Tolkien", 1992, "");

        //then
        assertEquals("Harry Potter", library.getBook("3545").getTitle());
        assertNull(library.getBook("3345"));
        assertNull(library.getBook(""));

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
        library.updateBook("Harry Potter", "New Author", 1994, "3545");

        //then
        assertEquals("New Author", library.getBook("3545").getAuthor());
    }
}