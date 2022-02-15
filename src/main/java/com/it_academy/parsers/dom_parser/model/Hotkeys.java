package com.it_academy.parsers.dom_parser.model;

public class Hotkeys {
    private final String hotkey;

    public Hotkeys(String hotkey) {
        this.hotkey = hotkey;
    }

    @Override
    public String toString() {
        return hotkey;
    }
}
