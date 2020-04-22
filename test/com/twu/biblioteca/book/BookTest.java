package com.twu.biblioteca.book;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BookTest {

    @Test
    public void returnAllFieldsAsArrayTest() {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", true);

        String[] fields = book.getFields();
        assertThat(fields, is(new String[]{"The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"}));
    }

    @Test
    public void makeBookUnavailableWhenCheckoutTest() {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", true);

        book.checkout();

        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void makeBookAvailableWhenReturnTest() {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", false);

        book.checkin();

        assertThat(book.isAvailable(), is(true));
    }
}
