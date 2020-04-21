package com.twu.biblioteca;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.book.BookReader;
import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.services.BookCheckinService;
import com.twu.biblioteca.services.BookCheckoutService;
import com.twu.biblioteca.services.BookListService;
import com.twu.biblioteca.services.QuitApplicationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BibliotecaApp {
    private static final PrintStream printStream = System.out;
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        GreetingPrinter greetingPrinter = new GreetingPrinter(printStream);
        greetingPrinter.greeting();

        Menu menu = new Menu(initializeServices(), printStream);
        InputReader inputReader = new InputReader(printStream, bufferedReader);

        while (true) {
            menu.show();
            menu.callService(inputReader.read());
            pressAnyKeyToContinue();
        }
    }

    private static LinkedHashMap<String, Service> initializeServices() {
        LinkedHashMap<String, Service> services = new LinkedHashMap<>();

        BookCollection bookCollection = new BookCollection(books());
        BookReader bookReader = new BookReader(printStream, bufferedReader);

        services.put("1", new BookListService(bookCollection, printStream));
        services.put("2", new BookCheckoutService(bookCollection, bookReader, printStream));
        services.put("3", new BookCheckinService(bookCollection, bookReader, printStream));
        services.put("0", new QuitApplicationService());

        return services;
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", true));
        books.add(new Book("The Two Towers", "J. R. R. Tolkien", "1954", true));
        books.add(new Book("The Return Of The King", "J. R. R. Tolkien", "1955", true));

        return books;
    }

    private static void pressAnyKeyToContinue() {
        try {
            printStream.print("\n...");
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
