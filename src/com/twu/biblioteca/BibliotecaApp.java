package com.twu.biblioteca;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.services.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static final PrintStream printStream = System.out;
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_OPTION_MESSAGE = "Enter a option: ";
    private static final String INPUT_BOOK_TITLE_MESSAGE = "Enter a book title: ";
    private static final String INPUT_MOVIE_TITLE_MESSAGE = "Enter a movie title: ";

    public static void main(String[] args) {
        GreetingPrinter greetingPrinter = new GreetingPrinter(printStream);
        greetingPrinter.greeting();

        Menu menu = new Menu(initializeServices(), printStream);
        InputReader inputReader = new InputReader(printStream, scanner, INPUT_OPTION_MESSAGE);

        while (true) {
            menu.show();
            menu.callService(inputReader.read());
            pressAnyKeyToContinue();
        }
    }

    private static LinkedHashMap<String, Service> initializeServices() {
        LinkedHashMap<String, Service> services = new LinkedHashMap<>();

        BookCollection bookCollection = new BookCollection(books());
        InputReader bookReader = new InputReader(printStream, scanner, INPUT_BOOK_TITLE_MESSAGE);
        InputReader movieReader = new InputReader(printStream, scanner, INPUT_MOVIE_TITLE_MESSAGE);

        List<Movie> movies = movies();

        services.put("1", new BookListService(bookCollection, printStream));
        services.put("2", new BookCheckoutService(bookCollection, bookReader, printStream));
        services.put("3", new BookCheckinService(bookCollection, bookReader, printStream));
        services.put("4", new MovieListService(movies, printStream));
        services.put("5", new MovieCheckoutService(movies, movieReader, printStream));
        services.put("quit", new QuitApplicationService());

        return services;
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", true));
        books.add(new Book("The Two Towers", "J. R. R. Tolkien", "1954", true));
        books.add(new Book("The Return Of The King", "J. R. R. Tolkien", "1955", true));

        return books;
    }

    private static List<Movie> movies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Matrix", "1999", "The Wachowskis", "9", true));

        return movies;
    }

    private static void pressAnyKeyToContinue() {
        printStream.print("\n...");
        scanner.nextLine();
    }
}
