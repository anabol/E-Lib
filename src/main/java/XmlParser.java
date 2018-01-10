
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {

    private static Map<Integer, Account> accountsMap = new HashMap<Integer, Account>();

    public static void xmlRead(String fileName) {
        Document doc = docInit("account");
        NodeList nodeList = doc.getElementsByTagName("account");
        Map<Integer, Account> map = fillAccount(nodeList);
        for (Map.Entry<Integer, Account> accMap : map.entrySet()){
            System.out.println(accMap.getValue().toString());
        }
    }

    public static void xmlWrite(String fileName) {
        Document doc = null;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder db = factory.newDocumentBuilder();
                DOMImplementation domImplementation = db.getDOMImplementation();
                doc = domImplementation.createDocument(null, "accounts", null);

                buildTree(doc, doc.getDocumentElement());

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                Properties transfProps = new Properties();
                transfProps.put("method", "xml");
                transfProps.put("indent", "yes");
                transformer.setOutputProperties(transfProps);

                DOMSource source = new DOMSource(doc);
                OutputStream out = new FileOutputStream(new File(fileName));
                StreamResult result =  new StreamResult(out);
                //StreamResult result =  new StreamResult(System.out);
                transformer.transform(source, result);
                try {
                    out.close();
                } catch (Exception ex) {}

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void pushAccount(Account acc){
        accountsMap.put(acc.hashCode(), acc);
    }

    private static void buildTree(Document doc, Element root) {
        // setting up document
        doc.setXmlStandalone(true);
        doc.setStrictErrorChecking(true);
        doc.setXmlVersion("1.0");

        Element subRoot = createElement(doc, "accounts123", null);
        Element e;

        for(Map.Entry<Integer, Account> i:  accountsMap.entrySet()){
            String[] args = {"first_name", "last_name", "regist_date", "email"};
            e = createXmlObj(doc,"account", args,
                    i.getValue().getFirstName(),
                    i.getValue().getLastName(),
                    i.getValue().getDate(),
                    i.getValue().getEmail());
            e.setAttribute("account_id", i.getValue().getAccountId());
//            subRoot.appendChild(e);
            root.appendChild(e);
        }
//        root.appendChild(e);
//        root.appendChild(subRoot);
    }

    private static Element createXmlObj(Document doc, String root, String[] args, String ... values){
        Element e = createElement(doc, root, null);
        for(int i = 0; i < args.length; i++){
            e.appendChild(createElement(doc, args[i], values[i]));
        }
        return e;
    }

    private static Element createElement(Document doc, String name, String textContent) {
        Element elem = doc.createElement(name);
        if(textContent!=null)
            elem.setTextContent(textContent);
        return elem;
    }

    private static Document docInit(String fileName){
        try{
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            return doc;
        } catch(Exception e){
            return null;
        }
    }

    private static Map<Integer, Account> fillAccount(NodeList nodeList){
        Map<Integer, Account> mapAccount = new HashMap<Integer, Account>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            //System.err.println(nList.item(i).getNodeName());
            if (nodeList.item(i).getNodeName().equals("account")) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Account account = new Account();
                    Element element = (Element) nNode;
                    account.setAccountId(element.getAttribute("account_id"));
                    account.setLastName(element.getChildNodes().item(1).getTextContent());
                    account.setFirstName(element.getChildNodes().item(3).getTextContent());
                    account.setDate(element.getChildNodes().item(5).getTextContent());
                    account.setEmail(element.getChildNodes().item(7).getTextContent());
                    mapAccount.put(account.hashCode(), account);
                }
            }
        }
        return mapAccount;
    }
}
