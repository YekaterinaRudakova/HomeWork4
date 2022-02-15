package com.it_academy.parsers.stax_parser.model;

public class Contacts {
    private String address;
    private String tel;
    private String email;
    private String url;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
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
