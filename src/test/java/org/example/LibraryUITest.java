package org.example;

import org.junit.jupiter.api.Test;

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
        verify(library).getBook("3355");
    }

}