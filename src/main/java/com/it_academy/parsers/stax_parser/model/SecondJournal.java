package com.it_academy.parsers.stax_parser.model;

import java.util.List;

public class SecondJournal {
    private String title;
    private List<Articles> articles;
    private Contacts contact;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public void setContact(Contacts contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Journal:\"" + title + '\"' +
                "\n" + articles + "\n" + contact + "\n";
    }
}
