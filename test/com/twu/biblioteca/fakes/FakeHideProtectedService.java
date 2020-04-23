package com.twu.biblioteca.fakes;

import com.twu.biblioteca.interfaces.HideProtectedService;

public class FakeHideProtectedService implements HideProtectedService {
    public String getName() {
        return "Fake Hide Protected Service";
    }

    public void call() {
    }
}
