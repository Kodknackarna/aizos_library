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

        //then
        assertEquals("Harry Potter", library.getBook("3545").getTitle());

        // Här testar vi att undantagen kastas
        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("", "", 1922, "3345"));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("Sagan om Ringen", "Tolkien", 1992, ""));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("Sagan om Ringen", "Tolkien", 2025, "3345"));
        });
    }

    @Test
    void removeBookTest(){
        //given
        Library library = new Library();
        library.addBook(new Book("Harry Potter", "JK Rowling", 1994, "3345"));
        //when
        library.removeBook("3345");

        //then
        assertNull(library.getBook("3345"));

    }

    @Test
    void removeBookTestTrue(){
        //given
        Library library = new Library();
        library.addBook(new Book("Harry Potter", "JK Rowling", 1994, "3345"));
        //when
        library.removeBook("3345");

        //then
        assertTrue(library.doesBookExist("3345"));

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