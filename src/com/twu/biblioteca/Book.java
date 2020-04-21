package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String yearPublished;
    private boolean available;

    public Book(String title, String author, String yearPublished, boolean available) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = available;
    }

    public String[] getFields() {
        return new String[]{title, author, yearPublished};
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

    public void checkin() {
        available = true;
    }
}
