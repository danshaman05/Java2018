import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Mapa {
	/* toto je hruby odhad, krajsie riesenie by bolo take, ktore si
	 * maximalnu velkost matice zisti z poctu znakov prveho riadku
	 * a poctu znakov, az potom naalokuje pole.
	 */
static int SIZE = 100;		
static char more[][] = new char[SIZE][SIZE];

    /** velkost ostrova sa zistuje tak, ze v niektorom bode ostrova sa zacneme
     * rekurzivne sirit vsetkymi smermi po ostrove. Ale pozor, co mora naskaceme...
     * aby sme si mapatali, kde sme uz boli, to policko ostrova si oznackujeme
     * nejakym speci znakom, napr @. Vysledna velkost ostrova je potom sucet
     * rekurzivnych volani plus 1 za policko, z ktoreho sme vysli...
     */
	public static int velkostOstrova(int i, int j) {
    	if (0 <= i && i < SIZE && 0 <= j && j < SIZE && more[i][j] == '#') {
    	  more[i][j] = '@';	// specialny znak
    	  return 1+velkostOstrova(i,j+1)+velkostOstrova(i,j-1)+velkostOstrova(i-1,j)+velkostOstrova(i+1,j);
    	} else 
    	  return 0;
    }
	public static void main(String[] args) {
	  try {	
		// citanie mapy zo suboru
		// citanie po riadkoch
		BufferedReader in = new BufferedReader(new FileReader("mapa.in"));
		int r = 0;
		int l = 0;
		for(;;) {
		  String line = in.readLine();
		  if (line == null) break;
		  l = line.length();
		  for(int s=0; s<l; s++)
			  more[r][s] = line.charAt(s);
		  r++;
		}
		// more je uz nacitane, ideme pocitat velkosti ostovov
		int maxOstrov = -1;
		int maxOstrovX = -1;
		int maxOstrovY = -1;
		for(int i=0; i<r; i++)
			for(int j=0; j<l; j++)
				if (more[i][j] == '#') {
					int velkost = velkostOstrova(i,j);
					System.out.println("ostrov velkost:"+velkost + " na suradniciach: ["+i+","+j+"]");
					if (velkost > maxOstrov) {
						maxOstrov = velkost;
						maxOstrovX = i;
						maxOstrovY = j;
					}
				}			
		System.out.println("Najvacsi je ostrov velkosti:"+maxOstrov + " na suradniciach: ["+maxOstrovX+","+maxOstrovY+"]");
	  } catch (Exception E) {
		  System.err.println("Error:"+E.getMessage());
	  }
	 }
}
