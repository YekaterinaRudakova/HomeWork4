package com.it_academy.parsers.dom_parser.utils;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DocumentOpener {
    public static Document buildDocument() throws Exception {
        File file = new File("journal.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}
