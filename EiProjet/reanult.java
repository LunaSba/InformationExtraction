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

public class reanult {
	public static int cu = 0;
	public static int tel = 0;
	public static void renaultxml(String htmlFile) throws Exception{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
        factory.setNamespaceAware(false);
        factory.setValidating(false);
        factory.setFeature("http://xml.org/sax/features/namespaces", false);
        factory.setFeature("http://xml.org/sax/features/validation", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);       
        
		DocumentBuilder parseur = factory.newDocumentBuilder();
		Document document = parseur.parse(htmlFile);
		
		NodeList sections = document.getElementsByTagName("div");
		 
		DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder parseur2 = factory2.newDocumentBuilder();
		DOMImplementation domimp = parseur2.getDOMImplementation();
		org.w3c.dom.Document doc = domimp.createDocument(null,"Concessionnaires",null);//
		doc.setXmlStandalone(true);
		Element rac = doc.getDocumentElement();
		int y =1;
		for (int i = 1; i < sections.getLength(); i++) {
		      Element section = (Element) sections.item(i);
		  	if(section.hasAttributes()) {
		  		
				NamedNodeMap attributes = section.getAttributes();
					Attr attribute = (Attr) attributes.item(0);
					 y=y+1;
					if((attribute.getName() == "class") && y==11 ){
						Extraire(section,document,rac,doc);
						}}}
		 DOMSource ds = new DOMSource(doc); 
		 StreamResult res = new StreamResult(new File("renault.xml")); 
		 TransformerFactory transform = TransformerFactory.newInstance();
		 Transformer tr = transform.newTransformer();
		 tr.setOutputProperty(OutputKeys.INDENT, "yes");
		 tr.transform(ds, res);  
		 System.out.println("Le fichier renault.html est transforme avec succes"); 
	}
	public static void Extraire(Node node,Document document,Element rac,Document doc) {
		if (!(node.hasAttributes())){ 
			if(node.getFirstChild() != null & node.getNodeName() == "strong") {
				String chaine = node.getFirstChild().getNodeValue().trim();
				if((chaine.length() != 0)  ){
					if(( !(chaine.equals("Tél"))) ){
						if(!(chaine.equals("Adresse"))){
							Element texte = doc.createElement("Nom"); 
							rac.appendChild(texte); 
							texte.appendChild(doc.createTextNode(node.getFirstChild().getNodeValue().replaceAll("\n","")));
							}}}}
			if(node.getNextSibling() != null  ){
				String chaine=node.getNextSibling().getNodeValue();
				if(chaine.length() !=0 & chaine.trim().length() != 0 ){
				if(!(chaine.trim().equals(":")) & !(chaine.trim().equals("Fax :")) & (chaine.indexOf("021") == -1 | cu ==0)){
					if(chaine.indexOf("021") == -1){
					Element texte = doc.createElement("Adresse"); 
				    rac.appendChild(texte); 
				    if(chaine.indexOf(": ")!=-1)
				    	 texte.appendChild(doc.createTextNode(chaine.trim().replaceAll(": ","")));
				    else
				         texte.appendChild(doc.createTextNode(chaine.trim().replaceAll("\n"," ")));
						}
						if(chaine.indexOf("021") != -1){
							Element texte = doc.createElement("Num_téléphone"); 
						    rac.appendChild(texte); 
						    texte.appendChild(doc.createTextNode(node.getNextSibling().getNodeValue().replaceAll("\n|: ","")));
					}
				}else{if (chaine.indexOf("021") != -1){
					if(cu!=0){
						switch(tel){
							case 1: tel = 0;
								break;
							case 0: tel= 1;
									Element num = doc.createElement("Num_téléphone"); 
									rac.appendChild(num); 
									num.appendChild(doc.createTextNode(node.getNextSibling().getNodeValue().trim().replaceAll("\n"," ")));		
									break;
							}}}else {if(cu==0)cu=1;}}}}
			}
		if(node.hasChildNodes()) {
			NodeList childNodes = node.getChildNodes();
			for(int i=0; i< childNodes.getLength(); i++) {
				Node childNode = childNodes.item(i);
				if(Filtrer(childNode)) Extraire(childNode,document,rac,doc);	
			}
		}
	}
	public static boolean Filtrer (Node noeud){		
		return (noeud.getNodeName() != "#text");
	}
}
