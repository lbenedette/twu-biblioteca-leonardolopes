package com.twu.biblioteca.services;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.User;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;
import java.util.Scanner;

public class AuthenticationService implements Service {
    private Authenticator authenticator;
    private PrintStream printStream;
    private final Scanner scanner;
    private User user = null;

    public AuthenticationService(Authenticator authenticator, PrintStream printStream, Scanner scanner) {
        this.authenticator = authenticator;
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public String getName() {
        return "Login";
    }

    public User getUser() {
        return user;
    }

    public void call() {
        try {
            user = authenticator.authenticate(enterLibraryNumber(), enterPassword());
            printStream.println("Welcome! You logged with success!");
        } catch (Exception e) {
            printStream.println(e.getMessage());
        }
    }

    private String enterLibraryNumber() {
        printStream.println("Enter your library number: ");
        return scanner.nextLine();
    }

    private String enterPassword() {
        printStream.println("Enter your password: ");
        return scanner.nextLine();
    }
}
