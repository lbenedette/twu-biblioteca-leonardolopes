package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MovieTest {

    @Test
    public void returnVarInArrayFormatTest() {
        String[] expected = new String[]{"The Matrix", "1999", "The Wachowskis", "9"};
        Movie movie = new Movie("The Matrix", "1999", "The Wachowskis", "9");

        assertThat(movie.varsToArray(), is(expected));
    }
}
