package com.twu.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String libraryNumber, String password, String name, String email, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public String[] varsAsArray() {
        return new String[]{name, email, phone};
    }
}
