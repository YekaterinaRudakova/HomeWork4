package com.it_academy.parsers.dom_parser.model;

import java.util.List;

public class Journal {
    private String title;
    private List<Articles> articles;
    private Contacts contact;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public void setContacts(Contacts contacts) {
        this.contact = contacts;
    }

    @Override
    public String toString() {
        return "Journal:\"" + title + '\"' +
                "\n" + articles + "\n" + contact + "\n";
    }
}
