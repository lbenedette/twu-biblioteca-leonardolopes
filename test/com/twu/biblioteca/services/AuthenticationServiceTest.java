package com.twu.biblioteca.services;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.User;
import com.twu.biblioteca.exceptions.InvalidPasswordException;
import com.twu.biblioteca.exceptions.UserNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {
    private final User user = new User("123-1234", "password", "Leonardo Lopes", "leonardo@email.com", "(99) 99991-1111");
    private Authenticator authenticator;
    private PrintStream printStream;
    private Scanner scanner;
    private AuthenticationService authenticationService;

    @Rule
    public final TextFromStandardInputStream in = emptyStandardInputStream();

    @Before
    public void setUp() {
        authenticator = mock(Authenticator.class);
        printStream = mock(PrintStream.class);
        scanner = new Scanner(System.in);
        authenticationService = new AuthenticationService(authenticator, printStream, scanner);
    }

    @Test
    public void requestLibraryNumberAndPasswordTest() {
        in.provideLines("123-1234", "verycomplicatedpassword");

        authenticationService.call();

        verify(printStream).println("Enter your library number: ");
        verify(printStream).println("Enter your password: ");
    }

    @Test
    public void authenticateAUserWithLibraryNumberAndPasswordTest() {
        in.provideLines("123-1234", "verycomplicatedpassword");

        when(authenticator.getUser()).thenReturn(user);

        authenticationService.call();
    }

    @Test
    public void showSuccessfulMessageWhenUserLoggedTest() {
        in.provideLines("123-1234", "verycomplicatedpassword");

        when(authenticator.getUser()).thenReturn(user);

        authenticationService.call();

        verify(printStream, times(1)).println("Welcome! You logged with success!");
    }

    @Test
    public void showErrorMessageWhenLibraryNumberDontExistTest() {
        in.provideLines("111-1111", "verycomplicatedpassword");

        doThrow(new UserNotFoundException("User not found!")).when(authenticator).authenticate("111-1111", "verycomplicatedpassword");

        authenticationService.call();

        verify(printStream, times(1)).println("User not found!");
    }

    @Test
    public void showErrorMessageWhenPasswordIsInvalidTest() {
        in.provideLines("123-1234", "invalidpassword");

        doThrow(new InvalidPasswordException("Password is invalid!")).when(authenticator).authenticate("123-1234", "invalidpassword");

        authenticationService.call();

        verify(printStream, times(1)).println("Password is invalid!");
    }
}
