import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XPathDemo {

    private static String xmlFileName;
    private static String xPathExpression;

    public static void main(String[] args) {

        xmlFileName = "";
        xPathExpression = "";
        xPathQuery(xmlFileName, xPathExpression);

//        E:\Projects\JavaServerWebApp\parseXML\exampleParseXML\src\main\resources\books.xml
//        /catalog/book
//        //child::*
//        count(//book[@id='bk101']/child::*)
//        count(//book[@id]/child::*)
//        count(//book[@id='bk101']/price/ancestor::*)
//        price='49.9'
//        descendant::book
//        preceding-sibling:://book[1]/price
//        generate-id(//book)
//        //book[last()]/author/following-sibling::*[name() = 'genre']

//        E:\Projects\JavaServerWebApp\parseXML\exampleParseXML\src\main\resources\ usage.statistics.xml
//        count(/application/component[@name='ActionsCollector']/counts/child::*)
//        //component[@name='ActionsCollector']/counts/entry[1]/@action

//        E:\Projects\JavaServerWebApp\parseXML\exampleParseXML\src\main\resources\biblStruct.xml
//        //surname/ancestor::biblStruct/@type
//        name(//*[attribute::when=2006])
//        name(//surname/ancestor::*[name() = 'author'])
//        count(//*[starts-with(@action, 'Show')])

    }

    static void xPathQuery(String fileName, String query) {

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            try {
                NodeList nodeList = (NodeList) xpath.evaluate(query, document, XPathConstants.NODESET);
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getTextContent());
                }
            }
            catch (XPathExpressionException xpee) {
                String output = xpath.evaluate(query, document);
                System.out.println(output);
            }
        }
        catch (ParserConfigurationException pce) { pce.getStackTrace();}
        catch (IOException ioe) { ioe.getStackTrace();}
        catch (SAXException saxe) { saxe.getStackTrace();}
        catch (XPathExpressionException xpathee) { xpathee.getStackTrace();}
    }
}

