package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Service;
import com.twu.biblioteca.stubs.FakeService;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MenuTest {
    private LinkedHashMap<String, Service> services;
    private Menu menu;
    private FakeService service;

    @Before
    public void setUp() {
        services = new LinkedHashMap<>();
        menu = new Menu(services);
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
            "1 - Fake Service\n" +
            "\n";

        menu.addService("1", service);

        assertThat(menu.toString(), is(expected));
    }
}
