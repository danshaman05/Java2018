import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Vstup {
	 /** 
	  * netradicne riesenie
	  * pouzivam TreeMap na utriedenie vstupneho pola neznameho rozmeru
	  * kluc je triedene cislo, value je jeho pocetnost...
	  * takze nakonci mam v tmp collection len neopakujuce sa cisla zo vstupneho suboru
	  * ale zase si pamatam, kolkokrat sa opakovalo
	  * z toho uz hravo vypisem vystupnu zostavu, lebo tolkokrat vypisem cislo,
	  * kolko je jeho pocetnost na vstupe
      * @param args program nevyuziva argumenty prikazoveho riadku
      */
	public static void main(String[] args) {
	  try {	 
		BufferedReader in = new BufferedReader(new FileReader("vstup.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("vystup.txt"));
		TreeMap<Integer,Integer> tmp = new TreeMap<Integer,Integer>();		
		for(;;) {
			String line = in.readLine();
			if (line == null) break;
			int c = Integer.parseInt(line);
			if (tmp.get(c) == null)
				tmp.put(Integer.parseInt(line), 1);
			else 
				tmp.put(Integer.parseInt(line), tmp.get(c)+1);
		}
		for(Integer elem:tmp.keySet()) {
			for (int i=0; i<tmp.get(elem); i++) {
				out.write(""+elem); out.newLine();
			}
		}
		in.close();
		out.close();
	  } catch (Exception E) {
		  System.err.println("Error:" + E.getMessage());
	  }		
	}
}
