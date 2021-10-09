package EiProjet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CorrectionXml {
	public static String corriger(String File) throws IOException{
		  BufferedReader in = null; 
		  BufferedWriter out  = null;
		  BufferedWriter out1 = new BufferedWriter(new FileWriter(File.toString().substring(0,File.toString().length()-"M457.xml".length())+"TEIFrantext.dtd"));
		  out1.write(""); 
		  out1.close();
		  int counter = -1;
		  try{ in = new BufferedReader(new FileReader(File)); 
		  
		  out = new BufferedWriter(new FileWriter(File.toString().substring(0,File.toString().length()-"M457.xml".length())+"M457Corrige.xml")); 
		
		  String c; 
		  while((c = in.readLine()) != null)
		  {
			  counter ++;
			if(counter == 0){
				//System.out.println(c);
				if(c.indexOf("version=\"1.0\"") != -1){
					
			//		System.out.println(c);
					c= c.replaceAll("version=\"1.0\"","version=\"1.0\" encoding=\"windows-1256\"");
					out.write(c+"\n");
				}
				//
			}else {if(counter == 19){
				//System.out.println(c);
				out.write(c+"</p>"+"\n");
			}else{if(counter == 417)
			{
				c= c.replaceAll("&","&#38;");
				out.write(c+"\n");
			}else{
				out.write(c+"\n");
			}}}
		  }}
		  finally{ if (in != null)
			  in.close(); 
		  
		}
		  if (out != null) out.close();
		return File.toString().substring(0,File.toString().length()-"M457.xml".length())+"M457Corrige.xml";

	}}
