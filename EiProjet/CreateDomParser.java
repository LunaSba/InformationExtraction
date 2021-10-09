package EiProjet;

import javax.xml.parsers.*;
import org.w3c.dom.DOMImplementation; 
import org.w3c.dom.DocumentType;
 
public class CreateDomParser{  
	static DocumentBuilder parseur;
	public static  DocumentBuilder parseur() throws ParserConfigurationException 
	{  
		parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
		return parseur; 
	}   
	public static  DOMImplementation cons() throws ParserConfigurationException { 
		DOMImplementation 
		cons =parseur.getDOMImplementation();
		DOMImplementation domimp = parseur.getDOMImplementation();
		DocumentType dtd = domimp.createDocumentType("Racine",null,"exemple-dom.dtd"); 
		//DOMImplementation domi_bis = CreateDomParser.cons();
        org.w3c.dom.Document doc = domimp.createDocument(null,"TEI_S",dtd);
        doc.setXmlStandalone(true);
		return cons;  } } 
 