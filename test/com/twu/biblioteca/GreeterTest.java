package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreeterTest {

    @Test
    public void printWelcomeMessageTest() {
        Greeter greeter = new Greeter();

        assertThat("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", is(greeter.greeting()));
    }
}
