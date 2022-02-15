package com.it_academy.parsers.stax_parser.extractors;

import com.it_academy.parsers.stax_parser.model.Articles;
import com.it_academy.parsers.stax_parser.model.Contacts;
import com.it_academy.parsers.stax_parser.model.Hotkeys;
import com.it_academy.parsers.stax_parser.model.SecondJournal;
import com.it_academy.parsers.stax_parser.providers.ITagProvider;

import javax.xml.stream.XMLStreamReader;
import java.util.List;

public class XMLContentExtractor implements ITagProvider {
    public static void extractContentFromXMLFile(SecondJournal journal, String tagContent, Contacts contacts,
                                                 Articles article, List<Articles> articlesList, Hotkeys hotkey,
                                                 List<Hotkeys> hotkeysList, XMLStreamReader reader) {
        switch (reader.getLocalName()) {
            case TAG_JOURNAL_TITLE -> {
                assert journal != null;
                journal.setTitle(tagContent);
            }
            case TAG_ADDRESS -> {
                assert false;
                contacts.setAddress(tagContent);
            }
            case TAG_TEL -> {
                assert false;
                contacts.setTel(tagContent);
            }
            case TAG_EMAIL -> {
                assert false;
                contacts.setEmail(tagContent);
            }
            case TAG_ARTICLE -> {
                assert articlesList != null;
                articlesList.add(article);
            }
            case TAG_JOURNAL_URL -> {
                assert false;
                contacts.setUrl(tagContent);
            }
            case TAG_TITLE -> {
                assert false;
                article.setTitle(tagContent);
            }
            case TAG_AUTHOR -> {
                assert false;
                article.setAuthor(tagContent);
            }
            case TAG_URL -> {
                assert false;
                article.setUrl(tagContent);
            }
            case TAG_HOTKEY -> {
                assert false;
                hotkey.setHotkey(tagContent);
                hotkeysList.add(hotkey);
                article.setHotkeys(hotkeysList);
            }
        }
    }
}
