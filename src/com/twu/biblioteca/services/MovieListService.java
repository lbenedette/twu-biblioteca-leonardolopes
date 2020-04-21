package com.twu.biblioteca.services;

import com.twu.biblioteca.Movie;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;
import java.util.List;

public class MovieListService implements Service {
    private List<Movie> movies;
    private PrintStream printStream;

    public MovieListService(List<Movie> movies, PrintStream printStream) {
        this.movies = movies;
        this.printStream = printStream;
    }

    public String getName() {
        return "List of movies";
    }

    public void call() {
        printStream.print(movieList());
    }

    private String movieList() {
        StringBuilder movieList = new StringBuilder(String.format("%-40s%-40s%-40s%-40s\n", "Title", "Year", "Director", "Rating"));

        movies.stream()
            .filter(Movie::isAvailable)
            .forEach(movie -> movieList.append(String.format("%-40s%-40s%-40s%-40s\n", movie.varsToArray())));

        return movieList.toString();
    }
}
