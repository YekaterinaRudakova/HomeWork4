package com.it_academy.parsers.stax_parser;

import com.it_academy.parsers.stax_parser.managers.JournalSecondManager;
import com.it_academy.parsers.stax_parser.model.SecondJournal;

public class StaxParserDemo {

    public static void main(String[] args) {
        JournalSecondManager journalSecondManager = new JournalSecondManager();
        SecondJournal secondJournal = journalSecondManager.doParsingJournalWithStax();
        System.out.println(secondJournal);
    }
}
