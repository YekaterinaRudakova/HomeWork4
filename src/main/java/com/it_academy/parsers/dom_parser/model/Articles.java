package com.it_academy.parsers.dom_parser.model;

import java.util.List;

public class Articles {
    private final String title;
    private final String author;
    private final String url;
    private final List<Hotkeys> hotkeys;

    public Articles(String title, String author, String url, List<Hotkeys> hotkeys) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "Article: \"" + title + "\"" +
                ", " + author +
                ", url:" + url + ", hotkeys: " + hotkeys;
    }
}
