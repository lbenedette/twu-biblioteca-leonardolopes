package com.twu.biblioteca.services;

import com.twu.biblioteca.Movie;
import com.twu.biblioteca.fakes.FakeReader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

public class MovieCheckoutServiceTest {
    private List<Movie> movies;
    private FakeReader fakeReader;
    private PrintStream printStream;
    private MovieCheckoutService movieCheckoutService;

    @Rule
    public final TextFromStandardInputStream in = emptyStandardInputStream();

    @Before
    public void setUp() {
        movies = new ArrayList<>();
        fakeReader = mock(FakeReader.class);
        printStream = mock(PrintStream.class);
        movieCheckoutService = new MovieCheckoutService(movies, fakeReader, printStream);
    }

    @Test
    public void checkoutAMovieAndChangeStatusTest() {
        Movie movie = new Movie("The Matrix", "1999", "The Wachowskis", "9", true);
        movies.add(movie);

        when(fakeReader.read()).thenReturn("The Matrix");

        movieCheckoutService.call();

        assertThat(movie.isAvailable(), is(false));
    }

    @Test
    public void showSuccessfulMessageWhenMoviesIsCheckoutTest() {
        Movie movie = new Movie("The Matrix", "1999", "The Wachowskis", "9", true);
        movies.add(movie);

        when(fakeReader.read()).thenReturn("The Matrix");

        movieCheckoutService.call();

        verify(printStream).println("Thank you! Enjoy the movie");
    }

    @Test
    public void showErrorMessageWhenMoviesIsUnavailableTest() {
        Movie movie = new Movie("The Matrix", "1999", "The Wachowskis", "9", false);
        movies.add(movie);

        when(fakeReader.read()).thenReturn("The Matrix");

        movieCheckoutService.call();

        verify(printStream).println("Sorry, that movie is not available");
    }

    @Test
    public void showErrorMessageWhenMoviesIsNotFoundTest() {
        when(fakeReader.read()).thenReturn("The Matrix");

        movieCheckoutService.call();

        verify(printStream).println("Book not found!");
    }
}
