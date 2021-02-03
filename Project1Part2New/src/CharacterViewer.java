import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class CharacterViewer extends DefaultHandler {

    static Character myCharacter;
    static String currentTag;


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        {
            Character myCharacter = null;
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

            File file = new File("characters.xml");
            Document doc = docBuilder.parse(file);
            Element root = doc.getDocumentElement();

// This code processes the Child elements of the root.

            NodeList nodes = root.getChildNodes();
            int numChar = 0;
            for (int i = 0; i < nodes.getLength(); i++) {

                Node childNode = nodes.item(i);
                if (childNode instanceof Element) {
                    numChar++;
                    if (numChar != 1)
                        System.out.println(myCharacter.toString());
                    myCharacter = new Character();
                    Element childElement = (Element) childNode;
                    NodeList nodes2 = childElement.getChildNodes();
                    for (int j = 0; j < nodes2.getLength(); j++) {
                        Node childNode2 = nodes2.item(j);
                        if (childNode2 instanceof Element) {
                            Element childElement2 = (Element) childNode2;
                            Text textNode2 = (Text) childElement2.getFirstChild();
                            String tagName = childElement2.getTagName();
                            String data = textNode2.getData();
//                System.out.print("\t"+ tagName);
//                System.out.println(": " + data);
                            switch (tagName) {
                                case "name":
                                    Character.setName(data);
                                    break;
                                case "age":
                                    Character.setAge(Integer.parseInt(data));
                                    break;
                                case "gender":
                                    Character.setGender(data);
                                    break;
                                case "creator":
                                    Character.setCreator(data);
                                    break;
                                case "desc":
                                    Character.setDescription(data);
                                    break;
                                case "fanmade":
                                    Character.setFanmade(Boolean.parseBoolean(data));
                                    break;
                            } // End of case
                        }  // End of if for children elements
                    }  // End of for next loop
                }  // End of if for Student element
            } // End of first for next loop
            // Print out the last object.
            System.out.println(myCharacter.toString());
        }  // End of main
    }
}



