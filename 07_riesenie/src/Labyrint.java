import java.io.BufferedReader;
import java.io.FileReader;

public class Labyrint {
static char[][] labo;	
static int thezeusX = -1;
static int thezeusY = -1;
	/** 
	 * cesta je rekurzivna metoda, ktora vrati najkratsi cestu z bodu x,y k Minotaurovi
	 * metoda je prehladavanie do sirky, preto je aj najkratsia
	 * ak cesta neexistuje, vysledok je -1
	 * ak existuje, vysledna hodnota je dlzka najkratsej cesty
	 * z bodu x,y sa rekurzivne rozsirim do 
	 * x+1,y
	 * x-1,y
	 * x,y-1
	 * x,y+1
	 * ak sa nenajde ziadna cesta (max(c1,c2,c3,c4)=-1), zrejme nie je
	 * ak sa najde, hladame tu najkratsiu, t.j. min(c1,c2,c3,c4),
	 * pri tom si vsak musime dat pozor, ak niektoe ci = -1, to by nam pokazilo minimum ;-)
	 * pouzijeme techniku velkej sajby, MAX_VALUE
	 */
    public static int cesta(int x, int y) {
      if (0 <= x && x < labo.length && 0 <= y && y < labo[x].length && 
    		  (labo[x][y] == '.'||labo[x][y] == 'T' || labo[x][y] == 'M')) {
    	  if (labo[x][y] == 'M')
    		  return 0;
    	  labo[x][y] = '@';
    	  int c1 = cesta(x+1,y);
    	  int c2 = cesta(x-1,y);
    	  int c3 = cesta(x,y-1);
    	  int c4 = cesta(x,y+1);
    	  if (c1 < 0 && c2 < 0 && c3 < 0 && c4 < 0)  // neexistuje cesta
    		  return -1;
    	  else //existuje cesta
        	  return 1+Math.min(Math.min((c1<0)?Integer.MAX_VALUE:c1,(c2<0)?Integer.MAX_VALUE:c2),
        			  			Math.min((c3<0)?Integer.MAX_VALUE:c3,(c4<0)?Integer.MAX_VALUE:c4));
      } else
    	  return -1;
    }
	 /** 
	  * hlavny program nacita labyrint, pricom si zapamata poziciu Thezea,
	  * po nacitani spusti metodu cesta od Thezea, podla vysledku vypise
	  * ci existuje, ci nie
      * @param args program nevyuziva argumenty prikazoveho riadku
      */
	public static void main(String[] args) {
	  try {	
		BufferedReader in = new BufferedReader(new FileReader("labyrint.txt"));
  	    String line = in.readLine();
  	    int l = Integer.parseInt(line); // pocet stlpcov
  	    line = in.readLine();
  	    int r = Integer.parseInt(line); // pocet riadkov
  	    labo = new char[r][l];
		for(int i=0; i<r; i++) {
		  line = in.readLine();
		  if (line == null) break;
		  for(int s=0; s<line.length(); s++) {
			 labo[i][s] = line.charAt(s);
			 if (labo[i][s] == 'T') {
				 thezeusX = i; 
				 thezeusY = s;
			 }
		  }
		}
		int tmp = cesta(thezeusX,thezeusY);
		if (tmp < 0)
   	      System.out.println("neexistuje cesta od Thezea k Minotaurovi");
		else
  	      System.out.println("existuje cesta od Thezea k Minotaurovi a ma dlzku "+tmp);
	  } catch (Exception E) {
		  System.err.println("Error:"+E.getMessage());
	  }
	 }
}
