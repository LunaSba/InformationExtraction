package EiProjet;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class deplacerDTD {
	public static void DTD(String path) throws Exception{
				BufferedWriter out = new BufferedWriter(new FileWriter(path+"TEIFrantext.dtd")); 
				out.write(""); 
		out.close();

	}

}
