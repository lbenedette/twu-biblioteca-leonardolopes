package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    LinkedHashMap<String, Service> services;
    PrintStream printStream;

    public Menu(LinkedHashMap<String, Service> services, PrintStream printStream) {
        this.services = services;
        this.printStream = printStream;
    }

    public void addService(String option, Service service) {
        services.put(option, service);
    }

    public LinkedHashMap<String, Service> getServices() {
        return services;
    }

    public void callService(String option) {
        Service service = services.get(option);
        service.call();
    }

    public void show() {
        printStream.println(menuString());
    }

    private String menuString() {
        StringBuilder menu = new StringBuilder("MENU\n");

        for (Map.Entry<String, Service> service : services.entrySet()) {
            menu.append(service.getKey())
                .append(" - ")
                .append(service.getValue().getName())
                .append("\n");
        }

        return menu.toString();
    }
}
