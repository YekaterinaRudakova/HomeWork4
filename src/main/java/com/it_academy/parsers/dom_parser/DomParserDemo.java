package com.it_academy.parsers.dom_parser;

import com.it_academy.parsers.dom_parser.managers.JournalManager;
import com.it_academy.parsers.dom_parser.model.Journal;

public class DomParserDemo {
    public static void main(String[] args) {
        JournalManager journalManager = new JournalManager();
        Journal journal = journalManager.doParsingJournal();
        System.out.println(journal);
    }
}
