package com.twu.biblioteca.fakes;

import com.twu.biblioteca.interfaces.Service;

public class FakeService implements Service {
    public void call() {
    }

    public String getName() {
        return "Fake Service";
    }
}
