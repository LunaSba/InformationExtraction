package EiProjet;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class fxml {
	public static void fxmll(String fxmlFile) throws Exception{
		// 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder parseur = factory.newDocumentBuilder();
		DOMImplementation domimp = parseur.getDOMImplementation();
		org.w3c.dom.Document doc = domimp.createDocument(null,"Racine",null);//
		doc.setXmlStandalone(true);
		Element rac = doc.getDocumentElement();
		rac.setAttribute("xmlns:fx","http://javafx.com/fxml");
		//
		DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
		DocumentBuilder parseur2 = factory2.newDocumentBuilder();
		Document document = parseur2.parse(fxmlFile);
		Node liste = document.getDocumentElement();
		
		EcrireXml(liste,doc,rac);
		
		DOMSource ds = new DOMSource(doc); 
		StreamResult res = new StreamResult(new File("javafx.xml")); 
		TransformerFactory transform = TransformerFactory.newInstance();
		Transformer tr = transform.newTransformer();
		tr.setOutputProperty(OutputKeys.INDENT, "yes");
		tr.transform(ds, res);  
		System.out.println("Le fichier boitedialog.fxml est transforme avec succes");
	}
	public static void EcrireXml(Node node,org.w3c.dom.Document doc,Node rac) {
		if(node.hasAttributes()) {
			NamedNodeMap attributes = node.getAttributes();
			for(int j=0 ;j<attributes.getLength();j++) {
				Attr attribute = (Attr) attributes.item(j);
			      Element texte = doc.createElement("texte"); 
		    	  rac.appendChild(texte); 
			      
			      texte.setAttribute(attribute.getName(), "x");
		    	  texte.appendChild(doc.createTextNode(attribute.getValue()));
			    }}
		if(node.hasChildNodes()) {
			NodeList childNodes = node.getChildNodes();
			for(int i=0; i< childNodes.getLength(); i++) {
				Node childNode = childNodes.item(i);
				EcrireXml(childNode,doc,rac);}}}
	public static boolean Filtrer (Node noeud){		
		return (noeud.getNodeName() != "#text");
	}
}
