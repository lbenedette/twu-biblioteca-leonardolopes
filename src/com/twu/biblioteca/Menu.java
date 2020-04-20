package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Service;

import java.util.LinkedHashMap;
import java.util.Map;

public class Menu {
    LinkedHashMap<String, Service> services;

    public Menu(LinkedHashMap<String, Service> services) {
        this.services = services;
    }

    public void addService(String option, Service service) {
        services.put(option, service);
    }

    public LinkedHashMap<String, Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        StringBuilder menu = new StringBuilder("MENU\n");

        for (Map.Entry<String, Service> service : services.entrySet()) {
            menu.append(service.getKey())
                .append(" - ")
                .append(service.getValue().getName())
                .append("\n");
        }

        menu.append("\n");
        return menu.toString();
    }
}
