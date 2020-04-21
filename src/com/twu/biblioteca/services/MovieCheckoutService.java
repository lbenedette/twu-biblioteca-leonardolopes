package com.twu.biblioteca.services;

import com.twu.biblioteca.Movie;
import com.twu.biblioteca.interfaces.Reader;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;
import java.util.List;

public class MovieCheckoutService implements Service {
    private List<Movie> movies;
    private Reader movieReader;
    private PrintStream printStream;

    public MovieCheckoutService(List<Movie> movies, Reader movieReader, PrintStream printStream) {
        this.movies = movies;
        this.movieReader = movieReader;
        this.printStream = printStream;
    }

    public String getName() {
        return "Checkout a movie";
    }

    public void call() {
        try {
            checkoutMovie(findMovieByTitle(movieReader.read()));
        } catch (NullPointerException e) {
            printStream.println("Book not found!");
        }
    }

    private Movie findMovieByTitle(String title) {
        return movies.stream()
            .filter(m -> m.getTitle().equals(title))
            .findFirst()
            .orElse(null);
    }

    private void checkoutMovie(Movie movie) {
        if (movie.isAvailable()) {
            movie.checkout();
            printStream.println("Thank you! Enjoy the movie");
        } else {
            printStream.println("Sorry, that movie is not available");
        }
    }
}
