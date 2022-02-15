package com.it_academy.parsers.stax_parser.managers;

import com.it_academy.parsers.stax_parser.extractors.XMLContentExtractor;
import com.it_academy.parsers.stax_parser.model.Articles;
import com.it_academy.parsers.stax_parser.model.Contacts;
import com.it_academy.parsers.stax_parser.model.Hotkeys;
import com.it_academy.parsers.stax_parser.model.SecondJournal;
import com.it_academy.parsers.stax_parser.providers.ITagProvider;
import com.it_academy.parsers.stax_parser.utils.SecondJournalReader;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class JournalSecondManager implements ITagProvider {
    public SecondJournal doParsingJournalWithStax() {
        SecondJournal secondJournal = null;
        String tagContent = null;
        Contacts contacts = null;
        Articles article = null;
        List<Articles> articlesList = null;
        Hotkeys hotkey = null;
        List<Hotkeys> hotkeysList = null;

        XMLStreamReader reader;
        try {
            reader = SecondJournalReader.getXmlStreamReader();
            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants
                            .START_ELEMENT -> {
                        if (TAG_JOURNAL.equals(reader.getLocalName())) {
                            secondJournal = new SecondJournal();
                        }
                        if (TAG_CONTACTS.equals(reader.getLocalName())) {
                            contacts = new Contacts();
                        }
                        if (TAG_ARTICLES.equals(reader.getLocalName())) {
                            articlesList = new ArrayList<>();
                        }
                        if (TAG_ARTICLE.equals(reader.getLocalName())) {
                            article = new Articles();
                        }
                        if (TAG_HOTKEYS.equals(reader.getLocalName())) {
                            hotkeysList = new ArrayList<>();
                        }
                        if (TAG_HOTKEY.equals(reader.getLocalName())) {
                            hotkey = new Hotkeys();
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
                    case XMLStreamConstants.END_ELEMENT -> XMLContentExtractor.extractContentFromXMLFile(secondJournal, tagContent, contacts, article,
                            articlesList, hotkey, hotkeysList, reader);
                    case XMLStreamConstants.START_DOCUMENT -> {
                        article = new Articles();
                        hotkey = new Hotkeys();
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            System.out.println("Open parsing error " + ex.getMessage());
        }
        assert secondJournal != null;
        secondJournal.setContact(contacts);
        secondJournal.setArticles(articlesList);

        return secondJournal;
    }
}
