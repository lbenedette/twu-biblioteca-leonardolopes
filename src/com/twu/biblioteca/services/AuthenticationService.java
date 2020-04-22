package com.twu.biblioteca.services;

import com.twu.biblioteca.interfaces.Service;

public class AuthenticationService implements Service {
    private String libraryNumber;
    private String password;

    public String getName() {
        return "Login";
    }

    public void call() {

    }
}
