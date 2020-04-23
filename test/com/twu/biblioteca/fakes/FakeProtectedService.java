package com.twu.biblioteca.fakes;

import com.twu.biblioteca.interfaces.ProtectedService;

public class FakeProtectedService implements ProtectedService {
    public String getName() {
        return "Fake Protected Service";
    }

    public void call() {
    }
}
