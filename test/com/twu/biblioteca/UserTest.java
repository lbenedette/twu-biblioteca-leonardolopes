package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    @Test
    public void returnVarAsArrayFromUser() {
        User user = new User("123-1234", "password", "Leonardo Lopes", "leonardo@email.com", "(99) 99991-1111");

        assertThat(user.varsAsArray(), is(new String[]{"Leonardo Lopes", "leonardo@email.com", "(99) 99991-1111"}));
    }
}
