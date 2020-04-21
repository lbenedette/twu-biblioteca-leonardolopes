package com.twu.biblioteca.fakes;

import com.twu.biblioteca.interfaces.Reader;

public class FakeReader implements Reader {
    public String read() {
        return "Fake String";
    }
}
