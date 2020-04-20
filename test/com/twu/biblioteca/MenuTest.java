package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.stubs.FakeService;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class MenuTest {
    private LinkedHashMap<String, Service> services;
    private PrintStream printStream;
    private Menu menu;
    private FakeService fakeService;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        fakeService = mock(FakeService.class);

        services = new LinkedHashMap<>();

        menu = new Menu(services, printStream);
    }

    @Test
    public void addServicesWithOptionTests() {
        LinkedHashMap<String, Service> expected = new LinkedHashMap<>();
        expected.put("1", fakeService);

        menu.addService("1", fakeService);

        assertThat(menu.getServices(), is(expected));
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
}
