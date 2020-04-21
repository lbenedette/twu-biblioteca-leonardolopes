package com.twu.biblioteca;

public class Movie {
    private String title;
    private String year;
    private String director;
    private String rating;

    public Movie(String title, String year, String director, String rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String[] varsToArray() {
        return new String[]{title, year, director, rating};
    }
}
