package com.it_academy.parsers.stax_parser.model;

import java.util.List;

public class Articles {
    private String title;
    private String author;
    private String url;
    private List<Hotkeys> hotkeys;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHotkeys(List<Hotkeys> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "Article: \"" + title + "\"" +
                ", " + author +
                ", url:" + url + ", hotkeys: " + hotkeys;
    }
}
