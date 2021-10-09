package EiProjet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class poeme {
	public static void poemexml(String xmlFile) throws Exception{
		FileInputStream fiche = new FileInputStream(xmlFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fiche, "UTF8"));
		String ligne;
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		 DocumentBuilder parseur = factory.newDocumentBuilder();
		 DOMImplementation domimp = parseur.getDOMImplementation();
		 DocumentType dtd = domimp.createDocumentType("poema",null,"neruda.dtd"); 
		 org.w3c.dom.Document doc = domimp.createDocument(null,"poema",dtd);//
		 doc.setXmlStandalone(true);
		 Element rac = doc.getDocumentElement();  
		 Element ele2 = null, ele22 = null , ele222 = null,ele2222=null,ele22222=null;
		  int counter = -1;
			while ((ligne = br.readLine()) != null  ) {
		    counter++;
		    if (counter == 0)
		    {
		    	Element ele1 = doc.createElement("titulo");    
				rac.appendChild(ele1);  
				ele1.appendChild((doc.createTextNode(ligne))); 
				ele2 = doc.createElement("estrofa");    
				rac.appendChild(ele2);
				ele22 = doc.createElement("estrofa");    
				rac.appendChild(ele22);
				ele222 = doc.createElement("estrofa");    
				rac.appendChild(ele222);
				ele2222 = doc.createElement("estrofa");    
				rac.appendChild(ele2222);
				ele22222 = doc.createElement("estrofa");    
				rac.appendChild(ele22222);
				}
				else{
					if (counter == 4 |counter == 5|counter == 6|counter == 7 ){ 
						    Element ele3 = doc.createElement("verso");    
						    rac.appendChild(ele3);
						    ele3.appendChild((doc.createTextNode(ligne)));
						    ele2.appendChild(ele3);
					}else{
						if(counter == 13 |counter == 14|counter == 15|counter == 16 ){ 
							Element ele3 = doc.createElement("verso");    
							rac.appendChild(ele3);
							ele3.appendChild((doc.createTextNode(ligne)));
							ele22.appendChild(ele3);
					}else{
						if(counter == 20 |counter == 21|counter == 22|counter == 23 ){ 
							Element ele3 = doc.createElement("verso");    
							rac.appendChild(ele3);
							ele3.appendChild((doc.createTextNode(ligne)));
							ele222.appendChild(ele3);
					}else{
						if(counter == 27 |counter == 28|counter == 29|counter == 30 | counter == 31 ){ 
							Element ele3 = doc.createElement("verso");    
							rac.appendChild(ele3);
							ele3.appendChild((doc.createTextNode(ligne)));
							ele2222.appendChild(ele3);
					}else{
						if(counter == 35 |counter == 36|counter == 37|counter == 38){ 
							Element ele3 = doc.createElement("verso");    
							rac.appendChild(ele3);
							ele3.appendChild((doc.createTextNode(ligne)));
							ele22222.appendChild(ele3);
					}}}}}}
		    }  
			DOMSource ds = new DOMSource(doc); 
			StreamResult res = new StreamResult(new File("neruda.xml")); 
			TransformerFactory transform = TransformerFactory.newInstance();
			Transformer tr = transform.newTransformer();
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "neruda.dtd");//ligne obligatoire sinon pas de DTD 
			tr.transform(ds, res);     
			System.out.println("Le fichier poeme.xml est transforme avec succes");   
		}
}
