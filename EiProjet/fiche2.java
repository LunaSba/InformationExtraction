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
import org.w3c.dom.Element;

public class fiche2 {
	public static void fiche2xml(String txtFile) throws Exception{
		FileInputStream fiche = new FileInputStream(txtFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fiche, "UTF8"));
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder parseur = factory.newDocumentBuilder();
			
		DOMImplementation domimp = parseur.getDOMImplementation(); 
		org.w3c.dom.Document doc = domimp.createDocument(null,"FICHES",null);
		doc.setXmlStandalone(true);
		Element rac = doc.getDocumentElement();  
		org.w3c.dom.ProcessingInstruction pi = doc.createProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"fiche.xsl");
		doc.insertBefore(pi, rac);
		Element ele1 = null,lang = null,lan =null;
		String ligne;
		int counter = -1;
		while ((ligne = br.readLine()) != null  ) {
		counter ++;
		String chaine = ligne;
		if (counter == 0){		
			ele1 = doc.createElement("FICHES");    
		    rac.appendChild(ele1);
		    ele1.setAttribute("id", "1");}
		if (counter >= 0& counter<=21)
		{ 
			int tailleDroite = chaine.length()-2;		
			String balise = chaine.substring(tailleDroite,chaine.length());
			String path = chaine.substring(0,tailleDroite);	
			if (counter >= 0& counter<= 4){
				 Element ele2 = doc.createElement(balise);    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     if(counter == 0)
			     ele2.appendChild((doc.createTextNode(path))); 
			     else 
				     ele2.appendChild((doc.createTextNode(balise+" : "+path)));
			}else {if (counter == 5 ){
					 lang = doc.createElement("Langue");    
				     rac.appendChild(lang);
				     ele1.appendChild(lang);
				     lang.setAttribute("id", "AR"); 
					}else if (counter >= 6 & counter <= 9 ){
						tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));     
				}else if (counter == 10){
					tailleDroite = chaine.length()-14;	
					balise = chaine.substring(tailleDroite,chaine.length());
				    path = chaine.substring(0,tailleDroite);
				    Element ele2 = doc.createElement("RF");    
				     rac.appendChild(ele2);
				     ele1.appendChild(ele2);
				     lang.appendChild(ele2);
				     ele2.appendChild((doc.createTextNode("RF | DF : VE : "+path))); 
			}else if (counter == 11){
				tailleDroite = chaine.length()-5;	
				balise = chaine.substring(tailleDroite,chaine.length());
			    path = chaine.substring(0,tailleDroite);
			    Element ele2 = doc.createElement("RF");    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     lang.appendChild(ele2);
			     ele2.appendChild((doc.createTextNode("RF | PH : "+path))); 
					}else if (counter == 12){
						tailleDroite = chaine.length()-5;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement("RF");    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode("RF | NT : "+path))); 
					}else{ if(counter==13)
						{
					     lan = doc.createElement("Langue");    
					     rac.appendChild(lan);
					     ele1.appendChild(lan);
					     lan.setAttribute("id", "FR");
						}else{ if((counter>=14) & (counter <=17))
						{tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lan.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));  
					     }else{
					    	 if(counter == 18){
					    		 tailleDroite = chaine.length()-14;	
									balise = chaine.substring(tailleDroite,chaine.length());
								    path = chaine.substring(0,tailleDroite);
								    Element ele2 = doc.createElement("RF");    
								     rac.appendChild(ele2);
								     ele1.appendChild(ele2);
								     lan.appendChild(ele2);
								     ele2.appendChild((doc.createTextNode("RF | VE : "+path))); 
								     }else{
								    	 if (counter == 19 |counter == 20 | counter == 21)
								    		 {
								    			tailleDroite = chaine.length()-5;	
												balise = chaine.substring(tailleDroite,chaine.length());
											    path = chaine.substring(0,tailleDroite);
											    Element ele2 = doc.createElement("RF");    
											     rac.appendChild(ele2);
											     ele1.appendChild(ele2);
											     lan.appendChild(ele2);
											     ele2.appendChild((doc.createTextNode("RF | "+balise+path))); }}}}}}
		}else{if (counter >=29 & counter <= 50){
			int tailleDroite = chaine.length()-2;
			String balise = chaine.substring(tailleDroite,chaine.length());
			String path = chaine.substring(0,tailleDroite);	
			if(counter ==29){
				ele1 = doc.createElement("FICHES");    
			    rac.appendChild(ele1);
			    ele1.setAttribute("id", "2");
			}
			if (counter >= 29& counter<= 33){
				 Element ele2 = doc.createElement(balise);    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     if(counter == 29)
			     ele2.appendChild((doc.createTextNode(path))); 
			     else 
				     ele2.appendChild((doc.createTextNode(balise+" : "+path)));
			}else {if (counter == 34 ){
					 lang = doc.createElement("Langue");    
				     rac.appendChild(lang);
				     ele1.appendChild(lang);
				     lang.setAttribute("id", "AR");
					}else if (counter >= 35 & counter <= 38){
						tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));     
				}else if (counter == 39){
					tailleDroite = chaine.length()-14;	
					balise = chaine.substring(tailleDroite,chaine.length());
				    path = chaine.substring(0,tailleDroite);
				    Element ele2 = doc.createElement("RF");    
				     rac.appendChild(ele2);
				     ele1.appendChild(ele2);
				     lang.appendChild(ele2);
				     ele2.appendChild((doc.createTextNode("RF | DF : VE : "+path))); 
			}else if (counter == 40){
				tailleDroite = chaine.length()-5;	
				balise = chaine.substring(tailleDroite,chaine.length());
			    path = chaine.substring(0,tailleDroite);
			    Element ele2 = doc.createElement("RF");    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     lang.appendChild(ele2);
			     ele2.appendChild((doc.createTextNode("RF | PH : "+path))); 
					}else if (counter == 41){
						tailleDroite = chaine.length()-5;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement("RF");    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode("RF | NT : "+path))); 
					}else{ if(counter==42)
						{
					    lan = doc.createElement("Langue");    
					     rac.appendChild(lan);
					     ele1.appendChild(lan);
					     lan.setAttribute("id", "FR");
				
						}else{ if((counter>=43) & (counter <=46))
						{tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lan.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));  
					     }else{
					    	 if(counter == 47){
					    		 tailleDroite = chaine.length()-14;	
									balise = chaine.substring(tailleDroite,chaine.length());
								    path = chaine.substring(0,tailleDroite);
								    Element ele2 = doc.createElement("RF");    
								     rac.appendChild(ele2);
								     ele1.appendChild(ele2);
								     lan.appendChild(ele2);
								     ele2.appendChild((doc.createTextNode("RF | VE : "+path))); 
								     }else{
								    	 if (counter == 48 |counter == 49 | counter == 50)
								    		 {
								    			tailleDroite = chaine.length()-5;	
												balise = chaine.substring(tailleDroite,chaine.length());
											    path = chaine.substring(0,tailleDroite);
											    Element ele2 = doc.createElement("RF");    
											     rac.appendChild(ele2);
											     ele1.appendChild(ele2);
											     lan.appendChild(ele2);
											     ele2.appendChild((doc.createTextNode("RF | "+balise+path))); }}
								    		 }}}}	
		}else{if (counter >=54 & counter <= 73){
			int tailleDroite = chaine.length()-2;
			String balise = chaine.substring(tailleDroite,chaine.length());
			String path = chaine.substring(0,tailleDroite);	
			if(counter ==54){
				ele1 = doc.createElement("FICHES");    
			    rac.appendChild(ele1);
			    ele1.setAttribute("id", "3");
			}
			if (counter >= 54& counter<= 58){
				 Element ele2 = doc.createElement(balise);    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     if(counter == 53)
			     ele2.appendChild((doc.createTextNode(path))); 
			     else 
				     ele2.appendChild((doc.createTextNode(balise+" : "+path)));
			}else {if (counter == 59 ){
					 lang = doc.createElement("Langue");    
				     rac.appendChild(lang);
				     ele1.appendChild(lang);
				     lang.setAttribute("id", "AR"); 	 
					}else if (counter >= 60 & counter <= 63){
						tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));     
				}else if (counter == 64){
					tailleDroite = chaine.length()-24;	
					balise = chaine.substring(tailleDroite,chaine.length());
				    path = chaine.substring(0,tailleDroite);
				    Element ele2 = doc.createElement("RF");    
				     rac.appendChild(ele2);
				     ele1.appendChild(ele2);
				     lang.appendChild(ele2);
				     ele2.appendChild((doc.createTextNode("RF | "+balise.substring(15,19)+balise.substring(9,15)+balise.substring(4,10)+balise.substring(0,4)+path))); 
			}else{ if(counter==65)
						{
					     lan = doc.createElement("Langue");    
					     rac.appendChild(lan);
					     ele1.appendChild(lan);
					     lan.setAttribute("id", "FR");
						
						}else{ if((counter>=66) & (counter <=69))
						{tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lan.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));  
					     }else{
					    	 if(counter==70){
					    		    tailleDroite = chaine.length()-10;	
									balise = chaine.substring(tailleDroite,chaine.length());
								    path = chaine.substring(0,tailleDroite);
								    String r = balise.substring(1,3);
								    Element ele2 = doc.createElement(r);    
								     rac.appendChild(ele2);
								     ele1.appendChild(ele2);
								     lan.appendChild(ele2);
								     ele2.appendChild((doc.createTextNode("RF | "+r+" : "+path))); 
					    	 }else{
					    		 if(counter >= 71 & counter <= 73){
					    			 	tailleDroite = chaine.length()-5;	
										balise = chaine.substring(tailleDroite,chaine.length());
									    path = chaine.substring(0,tailleDroite);
									    Element ele2 = doc.createElement(balise.substring(0,2));    
									     rac.appendChild(ele2);
									     ele1.appendChild(ele2);
									     lan.appendChild(ele2);
									     ele2.appendChild((doc.createTextNode("RF | "+balise+path)));  
					    		 }}}}}}
		}else{if (counter >=79 & counter <= 98){
			
			int tailleDroite = chaine.length()-2;
			String balise = chaine.substring(tailleDroite,chaine.length());
			String path = chaine.substring(0,tailleDroite);	
			if(counter ==79){
				ele1 = doc.createElement("FICHES");    
			    rac.appendChild(ele1);
			    ele1.setAttribute("id", "4");
			}
			if (counter >= 79& counter<=83){
				 Element ele2 = doc.createElement(balise);    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     if(counter == 79)
			     ele2.appendChild((doc.createTextNode(path))); 
			     else 
				     ele2.appendChild((doc.createTextNode(balise+" : "+path)));
			}else {if (counter == 84 ){
					 lang = doc.createElement("Langue");    
				     rac.appendChild(lang);
				     ele1.appendChild(lang);
				     lang.setAttribute("id", "AR");	 
					}else if (counter >= 85 & counter <= 88){
						tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));     
				}else if (counter == 89){
					tailleDroite = chaine.length()-14;	
					balise = chaine.substring(tailleDroite,chaine.length());
				    path = chaine.substring(0,tailleDroite);
				    Element ele2 = doc.createElement("RF");    
				     rac.appendChild(ele2);
				     ele1.appendChild(ele2);
				     lang.appendChild(ele2);
				     ele2.appendChild((doc.createTextNode("RF | VE : "+path))); 
			}else if (counter == 90){
				tailleDroite = chaine.length()-5;	
				balise = chaine.substring(tailleDroite,chaine.length());
			    path = chaine.substring(0,tailleDroite);
			    Element ele2 = doc.createElement("RF");    
			     rac.appendChild(ele2);
			     ele1.appendChild(ele2);
			     lang.appendChild(ele2);
			     ele2.appendChild((doc.createTextNode("RF | PH : DF : VE : "+path))); 
					}else if (counter == 91){
						tailleDroite = chaine.length()-5;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement("RF");    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lang.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode("RF | NT : "+path))); 
					}else{ if(counter==92)
						{
					     lan = doc.createElement("Langue");    
					     rac.appendChild(lan);
					     ele1.appendChild(lan);
					     lan.setAttribute("id", "FR");
						
						}else{ if((counter>=93) & (counter <=96))
						{tailleDroite = chaine.length()-4;	
						balise = chaine.substring(tailleDroite,chaine.length());
					    path = chaine.substring(0,tailleDroite);
					    Element ele2 = doc.createElement(balise.substring(0,2));    
					     rac.appendChild(ele2);
					     ele1.appendChild(ele2);
					     lan.appendChild(ele2);
					     ele2.appendChild((doc.createTextNode(balise+path)));  
					     }else{
					    	 if(counter == 97){
					    		 //System.out.println(counter);
					    		 tailleDroite = chaine.length()-19;	
									balise = chaine.substring(tailleDroite,chaine.length());
								    path = chaine.substring(0,tailleDroite);
								    Element ele2 = doc.createElement("RF");    
								     rac.appendChild(ele2);
								     ele1.appendChild(ele2);
								     lan.appendChild(ele2);
								     ele2.appendChild((doc.createTextNode("RF |	PH : DF : VE : "+path))); 
								     }else{
								    	 if (counter == 98)
								    		 {
								    			tailleDroite = chaine.length()-5;	
												balise = chaine.substring(tailleDroite,chaine.length());
											    path = chaine.substring(0,tailleDroite);
											    Element ele2 = doc.createElement("RF");    
											     rac.appendChild(ele2);
											     ele1.appendChild(ele2);
											     lan.appendChild(ele2);
											     ele2.appendChild((doc.createTextNode("RF | "+balise+path))); }}
								    		 }}}}}}}}}
		DOMSource ds = new DOMSource(doc); 
		
		StreamResult res = new StreamResult(new File("fiche2.xml")); 
		TransformerFactory transform = TransformerFactory.newInstance();
		Transformer tr = transform.newTransformer();
		
		tr.setOutputProperty(OutputKeys.INDENT, "yes");
		
		tr.transform(ds, res);  

		
		System.out.println("Le fichier fiches.txt est transformer avec succes \"fiche2.xml\"");   
		}
	

}
