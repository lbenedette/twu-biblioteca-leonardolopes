package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BookCollectionTest {
    private final Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");
    private List<Book> books;
    private BookCollection bookCollection;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        bookCollection = new BookCollection(books);
    }

    @Test
    public void printBookListWithOneBookTest() {
        books.add(book);

        String bookListString = String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");
        bookListString += String.format("%-40s%-40s%-40s\n", "The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");

        assertThat(bookListString, is(bookCollection.listBooks()));
    }

    @Test
    public void printBookListWithTwoBooksTest() {
        books.add(book);
        books.add(new Book("The Two Towers", "J. R. R. Tolkien", "1954"));

        String bookListString = String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");
        bookListString += String.format("%-40s%-40s%-40s\n", "The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");
        bookListString += String.format("%-40s%-40s%-40s\n", "The Two Towers", "J. R. R. Tolkien", "1954");

        assertThat(bookListString, is(bookCollection.listBooks()));
    }

    @Test
    public void printBookListWithoutBooksTest() {
        String bookListString = String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");

        assertThat(bookListString, is(bookCollection.listBooks()));
    }

    @Test
    public void findBookByTitleTest() {
        books.add(book);

        Book foundBook = bookCollection.findByTitle("The Fellowship Of The Ring");

        assertThat(book, is(foundBook));
    }

    @Test
    public void returnNullWhenBookDontExistTest() {
        Book foundBook = bookCollection.findByTitle("The Two Towers");

        assertThat(null, is(foundBook));
    }

    @Test
    public void checkoutBookAndChangeItAvailableStatusTest() {
        books.add(book);

        bookCollection.checkoutBook("The Fellowship Of The Ring");

        assertThat(false, is(book.isAvailable()));
    }

    @Test
    public void Test() {
        books.add(book);

        bookCollection.checkoutBook("The Fellowship Of The Ring");

        assertThat(false, is(book.isAvailable()));
    }

    @Test
    public void printOnlyAvailableBooksInBookListTest() {
        books.add(new Book("The Two Towers", "J. R. R. Tolkien", "1954"));

        bookCollection.checkoutBook("The Two Towers");

        String checkedBookRow = String.format("%-40s%-40s%-40s\n", "The Two Towers", "J. R. R. Tolkien", "1954");
        assertThat(checkedBookRow, not(containsString(bookCollection.listBooks())));
    }
}
