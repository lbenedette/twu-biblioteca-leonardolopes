package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidPasswordException;
import com.twu.biblioteca.exceptions.UserNotFoundException;

import java.util.List;

public class Authenticator {
    private List<User> users;
    private User user;

    public Authenticator(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void authenticate(String libraryNumber, String password) {
        user = checkPassword(findUserByLibraryNumber(libraryNumber), password);
    }

    private User findUserByLibraryNumber(String libraryNumber) {
        return users.stream()
            .filter(user -> user.getLibraryNumber().equals(libraryNumber))
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    private User checkPassword(User user, String password) {
        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new InvalidPasswordException("Password is invalid!");
    }
}
