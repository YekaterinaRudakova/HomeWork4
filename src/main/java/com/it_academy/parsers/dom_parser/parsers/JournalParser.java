package com.it_academy.parsers.dom_parser.parsers;

import com.it_academy.parsers.dom_parser.model.Articles;
import com.it_academy.parsers.dom_parser.model.Contacts;
import com.it_academy.parsers.dom_parser.model.Hotkeys;
import com.it_academy.parsers.dom_parser.providers.ITagProvider;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class JournalParser implements ITagProvider {

    public Contacts parseContacts(Node contactsNode) {
        NodeList contactsChildren = contactsNode.getChildNodes();
        String address = null;
        String tel = null;
        String email = null;
        String url = null;
        for (int i = 0; i < contactsChildren.getLength(); i++) {
            if (contactsChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (contactsChildren.item(i).getNodeName()) {
                case TAG_ADDRESS -> address = contactsChildren.item(i).getTextContent();
                case TAG_TEL -> tel = contactsChildren.item(i).getTextContent();
                case TAG_EMAIL -> email = contactsChildren.item(i).getTextContent();
                case TAG_URL -> url = contactsChildren.item(i).getTextContent();
            }
        }
        return new Contacts(address, tel, email, url);
    }

    public List<Articles> parseArticlesList(Node articlesNode) {
        List<Articles> articlesList = new ArrayList<>();
        NodeList articlesChildren = articlesNode.getChildNodes();
        for (int i = 0; i < articlesChildren.getLength(); i++) {
            if (articlesChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!articlesChildren.item(i).getNodeName().equals(TAG_ARTICLE)) {
                continue;
            }
            Articles article = parseArticle(articlesChildren.item(i));
            articlesList.add(article);
        }
        return articlesList;
    }

    public Articles parseArticle(Node article) {
        String articleTitle = null;
        String author = null;
        String urlArticle = null;
        Node hotkeysNode = null;
        NodeList articleChildren = article.getChildNodes();
        for (int j = 0; j < articleChildren.getLength(); j++) {
            if (articleChildren.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (articleChildren.item(j).getNodeName()) {
                case TAG_TITLE -> articleTitle = articleChildren.item(j).getTextContent();
                case TAG_AUTHOR -> author = articleChildren.item(j).getTextContent();
                case TAG_URL -> urlArticle = articleChildren.item(j).getTextContent();
                case TAG_HOTKEYS -> hotkeysNode = articleChildren.item(j);
            }
        }
        return new Articles(articleTitle, author, urlArticle, parseHotkeys(hotkeysNode));
    }

    public List<Hotkeys> parseHotkeys(Node hotkeysNode) {
        if (hotkeysNode == null) {
            return new ArrayList<>();
        }
        NodeList hotkeyChildren = hotkeysNode.getChildNodes();
        if (hotkeyChildren == null || hotkeyChildren.getLength() == 0) {
            return new ArrayList<>();
        }
        List<Hotkeys> hotkeysList = new ArrayList<>();
        String hotkeyString;
        for (int i = 0; i < hotkeyChildren.getLength(); i++) {
            if (hotkeyChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (hotkeyChildren.item(i).getNodeName().equals(TAG_HOTKEY)) {
                hotkeyString = hotkeyChildren.item(i).getTextContent();
                hotkeysList.add(new Hotkeys(hotkeyString));
            }
        }
        return hotkeysList;
    }
}
