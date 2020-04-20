package com.twu.biblioteca;

import com.twu.biblioteca.services.BookCheckoutService;
import com.twu.biblioteca.services.BookListService;
import com.twu.biblioteca.services.QuitApplicationService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        BookReader bookReader =  new BookReader(printStream, new BufferedReader(new InputStreamReader(System.in)));

        GreetingPrinter greetingPrinter = new GreetingPrinter(printStream);

        BookCollection bookCollection = new BookCollection(books());

        BookListService bookListService = new BookListService(bookCollection, printStream);
        BookCheckoutService bookCheckoutService = new BookCheckoutService(bookCollection, bookReader);
        QuitApplicationService quitApplicationService = new QuitApplicationService();

        greetingPrinter.greeting();

        Menu menu = new Menu();
        menu.addService("1", bookListService);
        menu.addService("2", bookCheckoutService);
        menu.addService("0", quitApplicationService);
        printStream.print(menu);

//        bookListService.call();
//        bookCheckoutService.call();
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        return books;
    }
}
