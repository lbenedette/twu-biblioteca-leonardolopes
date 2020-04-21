package com.twu.biblioteca.services;

import com.twu.biblioteca.Movie;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieListServiceTest {

    @Test
    public void showAMovieListTest() {
        String expected = String.format("%-40s%-40s%-40s%-40s\n", "Title", "Year", "Director", "Rating") +
            String.format("%-40s%-40s%-40s%-40s\n", "The Matrix", "1999", "The Wachowskis", "9");

        List<Movie> movies = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        MovieListService movieListService = new MovieListService(movies, printStream);
        movies.add(new Movie("The Matrix", "1999", "The Wachowskis", "9", true));

        movieListService.call();

        verify(printStream).print(expected);
    }
}
