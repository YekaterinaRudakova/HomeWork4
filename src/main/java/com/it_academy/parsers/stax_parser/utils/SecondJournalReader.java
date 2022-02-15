package com.it_academy.parsers.stax_parser.utils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SecondJournalReader {
    public static XMLStreamReader getXmlStreamReader() throws XMLStreamException, FileNotFoundException {
        return XMLInputFactory.newInstance().
                createXMLStreamReader("journal2.xml", new FileInputStream("journal2.xml"));
    }
}
