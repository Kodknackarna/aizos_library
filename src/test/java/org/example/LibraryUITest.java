package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryUITest {

    @Test
    void canGetTitleByIsbn(){

        //given
        Library library = mock(Library.class);
        Book expectedBook = new Book("Harry Potter", "JK Rowling", 1993, "3355");
        when(library.getBook("3355")).thenReturn(expectedBook);
        LibraryUI libraryUI = new LibraryUI(library);

        //when
        String title = libraryUI.getBookTitleByIsbn("3355");

        //then
        assertEquals("Harry Potter", title);
        //verify(library).getBook("3355");
    }

    @Test
    void canGetBooksByAuthor(){
        //given
        Library library = mock(Library.class);
        List<Book> library2 = new ArrayList<Book>();
        Book expectedBookA = new Book("Harry Potter och de Vises Sten", "JK Rowling", 1993, "3355");
        Book expectedBookB = new Book("Harry Potter och Hemligheternas kammare ", "JK Rowling", 1993, "3355");
        Book expectedBookC = new Book("Harry Potter, fången från Azkaban", "JK Rowling", 1993, "3355");
        Book notExpectedBookA = new Book("Sagan om Ringen", "Tolkien", 1930, "2563");
        Book notExpectedBookB = new Book("Sagan om de två tornen", "Tolkien", 1931, "2599");
        library2.add(expectedBookA);
        library2.add(expectedBookB);
        library2.add(expectedBookC);
        library2.add(notExpectedBookA);
        library2.add(notExpectedBookB);
        when(library.listBooks()).thenReturn(library2);
        LibraryUI libraryUI = new LibraryUI(library);
        //when
        List<Book> books = libraryUI.getBooksByAuthor("JK Rowling");

        //then
        assertEquals(3,books.size());

    }
}