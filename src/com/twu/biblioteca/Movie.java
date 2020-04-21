package com.twu.biblioteca;

public class Movie {
    private String title;
    private String year;
    private String director;
    private String rating;
    private boolean available;

    public Movie(String title, String year, String director, String rating, boolean available) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.available = available;
    }

    public String[] varsToArray() {
        return new String[]{title, year, director, rating};
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkout() {
        available = false;
    }
}
