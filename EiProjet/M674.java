package EiProjet;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class M674 {
	public static void M674xml(String xmlFile) throws Exception{
		DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
		DocumentBuilder parseur2 = factory2.newDocumentBuilder();
         
		Document document = parseur2.parse(xmlFile);
		Node liste = document.getDocumentElement();

		DocumentBuilder one_parser = CreateDomParser.parseur();
		DOMImplementation domi_bis = CreateDomParser.cons();
		Document document_but =domi_bis.createDocument(null,"TEI_S", null);
		Element rac_but= document_but.getDocumentElement(); 
	    
		Element m457 = document_but.createElement("M674.xml"); 
		rac_but.appendChild(m457);
	    
	    Document document_but1 = transformer(liste,document,document_but,m457,rac_but); 
	
	    DOMSource ds = new DOMSource(document_but1); 
	    StreamResult res = new StreamResult(new File("sortie1.xml"));
	    TransformerFactory transform = TransformerFactory.newInstance(); 
	    Transformer tr = transform.newTransformer();  
	    document_but1.setXmlStandalone(true);  
	    tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    tr.setOutputProperty(OutputKeys.INDENT, "yes");
		tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "dom.dtd");
	    tr.transform(ds, res);
	    System.out.println("Le fichier M674.xml est transforme avec succes");
	}
	 public static Document transformer (Node node,Document doc,Document doc_but,Element m457,Element rac_but) throws Exception{ 
			
			if(node.hasAttributes() & node.getNodeName() == "pb" ) {
				String h = node.getNextSibling().getNodeValue();
				if (h.trim().length() != 0)
				{
					String contenu = node.getNextSibling().getNodeValue();   
				    Element texte = doc_but.createElement("texte"); 
				    rac_but.appendChild(texte); 
				    m457.appendChild(texte);
				    texte.appendChild(doc_but.createTextNode(contenu.trim()));
					}
			}else {
				if((node.cloneNode(true) != null)){
					if ( node.getNextSibling() != null )
					{
						
						String h = node.getNextSibling().getNodeValue();
						if (h.trim().length() != 0)
						{
							if(h.indexOf("&") != -1){
								h=node.getNextSibling().getNodeValue().trim();
								h=h.substring(9,h.length());
							}
							String contenu = h;   
						    Element texte = doc_but.createElement("texte"); 
						    rac_but.appendChild(texte); 
						    m457.appendChild(texte);
						    texte.appendChild(doc_but.createTextNode(contenu.trim()));}}}
				if(node.getFirstChild() != null & node.getNodeName() == "p" ) {
					String contenu = node.getFirstChild().getNodeValue(); 
					Element texte = doc_but.createElement("texte"); 
				    rac_but.appendChild(texte); 
				    m457.appendChild(texte);
				    texte.appendChild(doc_but.createTextNode(contenu));
				}
			}
			if(node.hasChildNodes()) {
				
				NodeList childNodes = node.getChildNodes();
				for(int i=0; i< childNodes.getLength(); i++) {
					Node childNode = childNodes.item(i);
					if(Filtrer(childNode)) transformer(childNode,doc,doc_but,m457,rac_but);
				}
			}
			
			return doc_but;
		}
		public static boolean Filtrer (Node noeud){		
			return (noeud.getNodeName() != "#text");
		}
}
