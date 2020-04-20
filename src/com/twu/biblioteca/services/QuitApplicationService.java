package com.twu.biblioteca.services;

import com.twu.biblioteca.interfaces.Service;

public class QuitApplicationService implements Service {
    public String getName() {
        return "Quit application";
    }

    public void call() {
        System.exit(0);
    }
}
