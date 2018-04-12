import java.io.*;
import java.util.*;

public class Sudoku {
static int N = 9;
static int[][]p = new int[N][N];
	/**
	 *  okH(r,x) = true, ak sa v riadku r nenachadza x
	 */
	public static boolean okH(int r, int x){
		for(int i= 0; i<9; i++)
			if (p[r][i] == x)
				return false;
		return true;
	}	
	/**
	 *  okV(s,x) = true, ak sa v slpci s nenachadza x
	 */
	public static boolean okV(int s, int x){
		for(int i= 0; i<9; i++)
			if (p[i][s] == x)
				return false;
		return true;
	}
	/**
	 *  okS(r,s,x) = true ak sa v stvorci 3x3, v ktorom sa nachadza r,s nenachadza x
	 *  pod stvorcom sa mysli jeden z 9tich zakladnych sudoku stvorcov, ktoreho
	 *  suradnice si laveho horneho rozku vypocitame v premennych a,b
	 */
	public static boolean okS(int r, int s, int x){
		int a = (int)(r-(r%3));
		int b = (int)(s-(s%3));
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(p[a+i][b+j] == x)
					return false;
		return true;
	}
	/**
	 *  mozem(r,s) v povodom rieseni testovalo korektnost tahu na policko so suradnicami r,s
	 *  mozem(r,s) = true, ak hodnota na policku r,s nesposobuje koliziu v zmysle sudoku
	 */
	public static boolean mozem(int r, int s){
		int x = p[r][s];
		p[r][s] = 0;
		boolean ret = (okV(s, x) && okH(r, x) && okS(r,s,x));
		p[r][s] = x;
		return ret;
	}
	/**
	 *  toto je mimoriadne neefektivny kod, vela testov sa tu robi zbytocne,
	 * kod je zrecyklovany z nejakeho studentskeho riesenia,
	 * lebo sa mi nechcelo pisat 4 predchadzajuce procedury.
	 * jednoducho, testujem korektnost vsekych hodnot v poli 9x9 pomocou mozem 
     * @param args program nevyuziva argumenty prikazoveho riadku
	 */
  public static void main(String[] args) {
	  try {
		  BufferedReader in = new BufferedReader(new FileReader("sudoku.txt"));
		  Scanner sc = new Scanner(in);
		  for (int i=0; i<N; i++)
			  for (int j=0; j<N; j++)
				  p[i][j] = sc.nextInt();
		  boolean ok = true;
		  for (int i=0; i<N; i++)
			  for (int j=0; j<N; j++)
				  if (!mozem(i,j)) { 
					  System.out.println(p[i][j]+" nemoze byt v riadku "+ (i+1) + " a stlpci "+ (j+1));
					  ok = false; 
				  }
		  if (ok)
			  System.out.println("vyrera to tak, ze riesenie sudoku je ok !");
	  } catch (Exception E) {
		  System.err.println("Error:" + E.getMessage());
	  }		
  }
}