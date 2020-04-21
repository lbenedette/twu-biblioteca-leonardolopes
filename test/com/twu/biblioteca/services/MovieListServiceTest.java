package com.twu.biblioteca.services;

import com.twu.biblioteca.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MovieListServiceTest {
    private List<Movie> movies;
    private Movie movie;
    private PrintStream printStream;
    private MovieListService movieListService;

    @Before
    public void setUp() {
        movies = new ArrayList<>();
        movie = mock(Movie.class);
        movies.add(movie);
        printStream = mock(PrintStream.class);
        movieListService = new MovieListService(movies, printStream);
    }

    @Test
    public void showAMovieListTest() {
        String expected = String.format("%-40s%-40s%-40s%-40s\n", "Title", "Year", "Director", "Rating") +
            String.format("%-40s%-40s%-40s%-40s\n", "The Matrix", "1999", "The Wachowskis", "9");

        when(movie.isAvailable()).thenReturn(true);
        when(movie.varsToArray()).thenReturn(new String[]{"The Matrix", "1999", "The Wachowskis", "9"});

        movieListService.call();

        verify(printStream).print(expected);
    }

    @Test
    public void dontShowUnavailableMovieInListTest() {
        String expected = String.format("%-40s%-40s%-40s%-40s\n", "Title", "Year", "Director", "Rating");

        when(movie.isAvailable()).thenReturn(false);

        movieListService.call();

        verify(printStream).print(expected);
    }
}
