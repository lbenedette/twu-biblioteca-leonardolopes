package com.twu.biblioteca;

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
}
