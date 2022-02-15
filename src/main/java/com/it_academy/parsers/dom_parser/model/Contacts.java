package com.it_academy.parsers.dom_parser.model;

public class Contacts {
    private final String address;
    private final String tel;
    private final String email;
    private final String url;

    public Contacts(String address, String tel, String email, String url) {
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Contacts: " + address +
                ", tel:" + tel +
                ", email:" + email +
                ", url:" + url;
    }
}
