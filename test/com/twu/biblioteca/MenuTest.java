package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MenuTest {

    @Test
    public void printMenuOptionsInToString() {
        Menu menu = new Menu();

        String menuString = "MENU\n" +
            "1 - List of books\n" +
            "2 - Checkout book\n" +
            "0 - Exit application\n" +
            "\n";

        assertThat(menuString, is(menu.toString()));
    }
}
