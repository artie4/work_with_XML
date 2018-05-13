import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class xPathDemo {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("E:\\Projects\\JavaServerWebApp\\parseXML\\exampleParseXML\\src\\main\\resources\\usage.statistics.xml"));

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();

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

//        E:\Projects\JavaServerWebApp\parseXML\exampleParseXML\src\main\resources\ usage.statistics.xml
//        count(/application/component[@name='ActionsCollector']/counts/child::*)
//        //component[@name='ActionsCollector']/counts/entry[1]/@action

//        E:\Projects\JavaServerWebApp\parseXML\exampleParseXML\src\main\resources\biblStruct.xml
//        //surname/ancestor::biblStruct/@type
//        name(//*[attribute::when=2006])
//        name(//surname/ancestor::*[name() = 'author'])


        System.out.println(xpath.evaluate("count(//*[starts-with(@action, 'Show')])", document));


//        System.out.println(xpath.evaluate("", document, XPathConstants.NODESET));
//        System.out.println(xpath.evaluate("", document, XPathConstants.NODE));
//        System.out.println(((Number) xpath.evaluate("", document, XPathConstants.NUMBER)).intValue());

    }
}
