package com.twu.biblioteca;

import com.twu.biblioteca.services.QuitApplicationService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitApplicationServiceTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void quitApplicationTest() {
        QuitApplicationService quitApplicationService = new QuitApplicationService();

        exit.expectSystemExit();
        quitApplicationService.call();
    }
}
