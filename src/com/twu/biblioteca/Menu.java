package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.HideProtectedService;
import com.twu.biblioteca.interfaces.ProtectedService;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    private LinkedHashMap<String, Service> services;
    private Authenticator authenticator;
    private PrintStream printStream;

    public Menu(LinkedHashMap<String, Service> services, Authenticator authenticator, PrintStream printStream) {
        this.services = services;
        this.authenticator = authenticator;
        this.printStream = printStream;
    }

    public void addService(String option, Service service) {
        services.put(option, service);
    }

    public LinkedHashMap<String, Service> getServices() {
        return services;
    }

    public void callService(String option) {
        try {
            checkAuth(services.get(option));
        } catch (NullPointerException e) {
            printStream.println("Please select a valid option!");
        }
    }

    private void checkAuth(Service service) {
        if (check(service)) {
            service.call();
        } else {
            printStream.println("Access denied! You need to login to access this");
        }
    }

    private boolean check(Service service) {
        if (service instanceof ProtectedService) {
            return authenticator.getUser() != null;
        }

        return true;
    }

    public void show() {
        printStream.println(menuString());
    }

    private String menuString() {
        StringBuilder menu = new StringBuilder("MENU\n");

        for (Map.Entry<String, Service> service : services.entrySet()) {
            if (canShowService(service.getValue())) {
                menu.append(service.getKey())
                    .append(" - ")
                    .append(service.getValue().getName())
                    .append("\n");
            }
        }

        return menu.toString();
    }

    private boolean canShowService(Service service) {
        if (service instanceof HideProtectedService) {
            return authenticator.getUser() != null;
        }

        return true;
    }
}
