package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.services.BookCheckoutService;
import com.twu.biblioteca.services.BookListService;
import com.twu.biblioteca.services.QuitApplicationService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BibliotecaApp {
    private static final PrintStream printStream = System.out;

    public static void main(String[] args) {
        GreetingPrinter greetingPrinter = new GreetingPrinter(printStream);
        greetingPrinter.greeting();

        Menu menu = new Menu(initializeServices());
//        menu.show();
        printStream.print(menu);

//        bookListService.call();
//        bookCheckoutService.call();
    }

    private static LinkedHashMap<String, Service> initializeServices() {
        LinkedHashMap<String, Service> services = new LinkedHashMap<>();

        BookCollection bookCollection = new BookCollection(books());
        BookReader bookReader = new BookReader(printStream, new BufferedReader(new InputStreamReader(System.in)));

        services.put("1", new BookListService(bookCollection, printStream));
        services.put("2", new BookCheckoutService(bookCollection, bookReader));
        services.put("0", new QuitApplicationService());

        return services;
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        return books;
    }
}
