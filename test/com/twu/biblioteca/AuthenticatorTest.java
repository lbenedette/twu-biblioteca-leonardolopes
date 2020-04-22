package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidPasswordException;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticatorTest {

    @Test
    public void returnUserWithLibraryNumberAndPasswordTest() {
        User user = new User("123-1234", "verycomplicatedpassword");
        List<User> users = new ArrayList<>();
        users.add(user);
        Authenticator authenticator = new Authenticator(users);

        assertThat(authenticator.authenticate("123-1234", "verycomplicatedpassword"), is(user));
    }

    @Test(expected = UserNotFoundException.class)
    public void throwExceptionWhenUserIsNotFoundTest() {
        List<User> users = new ArrayList<>();
        Authenticator authenticator = new Authenticator(users);

        authenticator.authenticate("123-1234", "verycomplicatedpassword");
    }

    @Test(expected = InvalidPasswordException.class)
    public void throwExceptionWhenPasswordIsIncorrectTest() {
        User user = new User("123-1234", "verycomplicatedpassword");
        List<User> users = new ArrayList<>();
        users.add(user);
        Authenticator authenticator = new Authenticator(users);

        authenticator.authenticate("123-1234", "incorrectpassword");
    }
}
