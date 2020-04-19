package com.twu.biblioteca.stubs;

import com.twu.biblioteca.interfaces.Service;

public class FakeService implements Service {
    public String getName() {
        return "Fake Service";
    }
}
