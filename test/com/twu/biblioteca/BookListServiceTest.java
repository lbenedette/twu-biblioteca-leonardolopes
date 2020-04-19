package com.twu.biblioteca;

import com.twu.biblioteca.services.BookListService;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookListServiceTest {
    private List<Book> books;
    private BookCollection bookCollection;
    private PrintStream printStream;
    private BookListService bookListService;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        bookCollection = mock(BookCollection.class);
        printStream = mock(PrintStream.class);
        bookListService = new BookListService(bookCollection, printStream);
    }

    @Test
    public void printBookListStringTest() {
        String expected = String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");
        expected += String.format("%-40s%-40s%-40s\n", "The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");

        when(bookCollection.getAvailableBooks()).thenReturn(books);
        bookListService.call();

        verify(printStream).print(expected);
    }

    @Test
    public void printBookListWithoutBooksTest() {
        String expected = String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");

        when(bookCollection.getAvailableBooks()).thenReturn(new ArrayList<>());
        bookListService.call();

        verify(printStream).print(expected);
    }
}
