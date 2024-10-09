package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "'', '', 1922, '3345'",
            "'Sagan om Ringen', 'Tolkien', 1992, ''",
            "'Sagan om Ringen', 'Tolkien', 2025, '3345'"
    })
    void addBookTestThrows(String title, String author, int year, String isbn) {
        // given
        Library library = new Library();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book(title, author, year, isbn));
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

    @ParameterizedTest
    @CsvSource({
            "3345, true",
            "3355, true",
            "2245, false"
    })
    void doesBookExistTest(String isbn, boolean exists){
        //given
        Library library = new Library();

        //when
        library.addBook(new Book("Harry Potter", "JK Rowling", 1994, "3345"));
        library.addBook(new Book("Sagan om Ringen", "Tolkien", 1992, "3355"));

        //then
        assertEquals(library.doesBookExist(isbn), exists);

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