package EiProjet;

import java.io.File;
import java.io.IOException;

public class mainProjet {

	public static void main(String[] argv) throws IOException, Exception {
		if(argv.length != 0)
		try{
			  String dir = argv[0];
		      scanDir(dir) ;
			 
	    }catch(Exception e){
			System.out.println("ERROR : Le repertoire n'existe pas verifiez le path");
		}
	   else
	    	System.out.println("Attention vous avez oublie de specifier le nom du repertoire a traiter ! ");
	}
	public static void scanDir(String d) throws Exception { 
		File currDir = new File(d);
		String[] List = currDir.list();
		String rep;	
		for (int i = 0; i < List.length; i++) {
			rep = d+File.separator+List[i];
			File repe = new File(rep);
			if(repe.isDirectory())
			{
				scanDir(rep) ;
			}else{
				if ("M674.xml".equals(List[i])) {
				  //  method1;
					deplacerDTD.DTD(repe.toString().substring(0,repe.toString().length()-List[i].length()));
					M674.M674xml(repe.toString());
					File fichier = new File(repe.toString().substring(0,repe.toString().length()-List[i].length())+"TEIFrantext.dtd");
					//supprimer le fichier DTD utilisé durant la lecture
					fichier.delete();
				}
				else if ("M457.xml".equals(List[i])) {
				    //method2;
					M457.M457xml(repe.toString());
					File fichier = new File(repe.toString().substring(0,repe.toString().length()-List[i].length())+"TEIFrantext.dtd");
					//supprimer le fichier DTD utilisé durant la lecture
					fichier.delete();
				}else if ("fiches.txt".equals(List[i])) {
				    //method3;
					fiche1.fiche1xml(repe.toString());
					fiche2.fiche2xml(repe.toString());
				}
				else if ("boitedialog.fxml".equals(List[i])) {
				    //method4;
					fxml.fxmll(repe.toString());
				}
				else if ("renault.html".equals(List[i])) {
				    //method5;
					reanult.renaultxml(repe.toString());
				}else if ("poeme.txt".equals(List[i])) {
				   // method6;
					poeme.poemexml(repe.toString());
				}
			
		}}}
}
