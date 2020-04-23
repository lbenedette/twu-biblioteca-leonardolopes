package com.twu.biblioteca.services;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.User;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class UserInfoServiceTest {

    @Test
    public void showUserInformationTest() {
        User user = new User("123-1234", "password", "Leonardo Lopes", "leonardo@email.com", "(99) 99991-1111");

        Authenticator authenticator = mock(Authenticator.class);
        PrintStream printStream = mock(PrintStream.class);
        UserInfoService userInfoService = new UserInfoService(authenticator, printStream);

        when(authenticator.getUser()).thenReturn(user);
        userInfoService.call();

        verify(printStream).println("Name: Leonardo Lopes\nEmail: leonardo@email.com\nPhone: (99) 99991-1111");
    }
}
