package com.twu.biblioteca;

import com.twu.biblioteca.fakes.FakeHideProtectedService;
import com.twu.biblioteca.fakes.FakeProtectedService;
import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.fakes.FakeService;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.LinkedHashMap;

import static org.mockito.Mockito.*;


public class MenuTest {
    private LinkedHashMap<String, Service> services;
    private Authenticator authenticator;
    private PrintStream printStream;
    private Menu menu;
    private FakeService fakeService;

    @Before
    public void setUp() {
        services = new LinkedHashMap<>();

        authenticator = mock(Authenticator.class);
        printStream = mock(PrintStream.class);
        fakeService = mock(FakeService.class);

        menu = new Menu(services, authenticator, printStream);
    }

    @Test
    public void printMenuBasedOnServicesTest() {
        String expected = "MENU\n" +
            "1 - Fake Service\n";
        menu.addService("1", fakeService);

        when(fakeService.getName()).thenReturn("Fake Service");

        menu.show();

        verify(printStream).println(expected);
    }

    @Test
    public void callServiceByOptionTest() {
        menu.addService("1", fakeService);

        menu.callService("1");

        verify(fakeService).call();
    }

    @Test
    public void showErrorMessageWhenEnterAInvalidOptionTest() {
        menu.callService("1");

        verify(printStream).println("Please select a valid option!");
    }

    @Test
    public void dontCallProtectedServiceWhenUserIsNotLoggedTest() {
        FakeProtectedService fakeProtectedService = mock(FakeProtectedService.class);
        menu.addService("1", fakeProtectedService);

        when(authenticator.getUser()).thenReturn(null);

        menu.callService("1");

        verify(fakeProtectedService, never()).call();
    }

    @Test
    public void callProtectedServiceWhenUserIsLoggedTest() {
        FakeProtectedService fakeProtectedService = mock(FakeProtectedService.class);
        User user = mock(User.class);
        menu.addService("1", fakeProtectedService);

        when(authenticator.getUser()).thenReturn(user);

        menu.callService("1");

        verify(fakeProtectedService).call();
    }

    @Test
    public void dontShowHideProtectedServiceWhenUserIsNotLoggedTest() {
        FakeHideProtectedService fakeHideProtectedService = mock(FakeHideProtectedService.class);
        menu.addService("1", fakeHideProtectedService);

        when(fakeHideProtectedService.getName()).thenReturn("Hide Service");
        when(authenticator.getUser()).thenReturn(null);

        menu.show();

        verify(printStream).println("MENU\n");
    }

    @Test
    public void showHideProtectedServiceWhenUserIsLoggedTest() {
        FakeHideProtectedService fakeHideProtectedService = mock(FakeHideProtectedService.class);
        User user = mock(User.class);
        menu.addService("1", fakeHideProtectedService);

        when(fakeHideProtectedService.getName()).thenReturn("Hide Service");
        when(authenticator.getUser()).thenReturn(user);

        menu.show();

        verify(printStream).println("MENU\n1 - Hide Service\n");
    }
}
