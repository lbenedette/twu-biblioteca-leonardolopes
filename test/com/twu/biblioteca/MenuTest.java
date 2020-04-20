package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.stubs.FakeService;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MenuTest {
    private LinkedHashMap<String, Service> services;
    private PrintStream printStream;
    private Menu menu;
    private FakeService service;

    @Before
    public void setUp() {
        services = new LinkedHashMap<>();
        printStream = mock(PrintStream.class);
        menu = new Menu(services, printStream);
        service = new FakeService();
    }

    @Test
    public void addServicesWithOptionTests() {
        LinkedHashMap<String, Service> expected = new LinkedHashMap<>();
        expected.put("1", service);

        menu.addService("1", service);

        assertThat(menu.getServices(), is(expected));
    }

    @Test
    public void printMenuBasedOnServicesTest() {
        String expected = "MENU\n" +
            "1 - Fake Service\n";

        menu.addService("1", service);
        menu.show();

        verify(printStream).println(expected);
    }
}
