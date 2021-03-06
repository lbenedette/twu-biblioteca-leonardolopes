package com.twu.biblioteca.book;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookCollectionTest {
    private Book book;
    private List<Book> books;
    private BookCollection bookCollection;

    @Before
    public void setUp() {
        book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", true);
        books = new ArrayList<>();
        bookCollection = new BookCollection(books);
    }

    @Test
    public void getOnlyAvailableBooksTest() {
        books.add(book);
        Book checkedBook = mock(Book.class);
        books.add(checkedBook);

        when(checkedBook.isAvailable()).thenReturn(false);

        assertThat(bookCollection.getAvailableBooks(), not(hasItem(checkedBook)));
    }

    @Test
    public void findBookByTitleTest() {
        books.add(book);

        assertThat(bookCollection.findByTitle("The Fellowship Of The Ring"), is(book));
    }

    @Test(expected = BookNotFoundException.class)
    public void throwExceptionWhenBookDontExistTest() {
        bookCollection.findByTitle("The Two Towers");
    }
}
