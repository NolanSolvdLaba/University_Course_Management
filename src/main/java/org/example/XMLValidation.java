package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLValidation {
    public static void main(String[] args) {
        String xmlFilePath = "student.xml";
        String xsdFilePath = "student.xsd";

        // Validate the XML file against the XSD schema
        boolean isValid = validateXMLSchema(xmlFilePath, xsdFilePath);
        if (isValid) {
            System.out.println("XML is valid against the XSD schema.");
        } else {
            System.out.println("XML is not valid against the XSD schema.");
        }

        // Parse the XML file using DOM
        parseXMLWithDOM(xmlFilePath);
    }

    private static boolean validateXMLSchema(String xmlFilePath, String xsdFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(null);
            builder.parse(xmlFilePath);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void parseXMLWithDOM(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // TODO: Implement parsing logic using DOM
            // Traverse the XML document and extract the required data

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
