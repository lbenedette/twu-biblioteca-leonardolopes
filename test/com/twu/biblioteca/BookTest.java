package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BookTest {

    @Test
    public void shouldReturnFieldsTitleAuthorAndYearPublished() {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");

        String[] fields = book.getFields();
        assertThat(fields, is(new String[]{"The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"}));
    }
}
