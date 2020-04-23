package com.twu.biblioteca.services;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.User;
import com.twu.biblioteca.interfaces.HideProtectedService;

import java.io.PrintStream;

public class UserInfoService implements HideProtectedService {
    private Authenticator authenticator;
    private PrintStream printStream;

    public UserInfoService(Authenticator authenticator, PrintStream printStream) {
        this.authenticator = authenticator;
        this.printStream = printStream;
    }

    public String getName() {
        return "Show user information";
    }

    public void call() {
        User user = authenticator.getUser();
        printStream.println(String.format("Name: %s\nEmail: %s\nPhone: %s", user.varsAsArray()));
    }
}
