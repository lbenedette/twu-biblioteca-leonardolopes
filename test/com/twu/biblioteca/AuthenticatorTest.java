package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidPasswordException;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticatorTest {
    private User user = new User("123-1234", "password", "Leonardo Lopes", "leonardo@email.com", "(99) 99991-1111");
    private List<User> users;
    private Authenticator authenticator;

    @Before
    public void setUp() {
        users = new ArrayList<>();
        authenticator = new Authenticator(users);
    }

    @Test
    public void returnUserWithLibraryNumberAndPasswordTest() {
        users.add(user);

        authenticator.authenticate("123-1234", "verycomplicatedpassword");

        assertThat(authenticator.getUser(), is(user));
    }

    @Test(expected = UserNotFoundException.class)
    public void throwExceptionWhenUserIsNotFoundTest() {
        authenticator.authenticate("123-1234", "verycomplicatedpassword");
    }

    @Test(expected = InvalidPasswordException.class)
    public void throwExceptionWhenPasswordIsIncorrectTest() {
        users.add(user);

        authenticator.authenticate("123-1234", "incorrectpassword");
    }
}
