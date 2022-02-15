package com.it_academy.parsers.dom_parser.managers;

import com.it_academy.parsers.dom_parser.model.Articles;
import com.it_academy.parsers.dom_parser.model.Contacts;
import com.it_academy.parsers.dom_parser.model.Journal;
import com.it_academy.parsers.dom_parser.parsers.JournalParser;
import com.it_academy.parsers.dom_parser.providers.ITagProvider;
import com.it_academy.parsers.dom_parser.utils.DocumentOpener;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class JournalManager implements ITagProvider {
    public Journal doParsingJournal() {
        JournalParser journalParser = new JournalParser();
        Journal journal = new Journal();

        Document document;
        try {
            document = DocumentOpener.buildDocument();
        } catch (Exception ex) {
            System.out.println("Open parsing error " + ex.getMessage());
            return null;
        }

        Node journalNode = document.getFirstChild();
        NodeList journalChildren = journalNode.getChildNodes();

        String journalTitle = null;
        Node contactsNode = null;
        Node articlesNode = null;

        for (int i = 0; i < journalChildren.getLength(); i++) {
            if (journalChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (journalChildren.item(i).getNodeName()) {
                case TAG_TITLE -> journalTitle = journalChildren.item(i).getTextContent();
                case TAG_CONTACTS -> contactsNode = journalChildren.item(i);
                case TAG_ARTICLES -> articlesNode = journalChildren.item(i);
            }
        }

        journal.setTitle(journalTitle);

        if (contactsNode == null) {
            return null;
        }

        Contacts contacts = journalParser.parseContacts(contactsNode);

        journal.setContacts(contacts);

        if (articlesNode == null) {
            return null;
        }

        List<Articles> articlesList = journalParser.parseArticlesList(articlesNode);
        journal.setArticles(articlesList);

        return journal;
    }
}
