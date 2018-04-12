import java.io.*;
import java.util.*;

public class Matica {
  public static void main(String[] args) {
	  try {
		  // citanie velkosti matice
		  BufferedReader in = new BufferedReader(new FileReader("matica.txt"));
		  String line = in.readLine();
		  int N = Integer.parseInt(line);
		  // naalokovanie matice
		  double[][] matica = new double[N][N];
		  // citanie matice 
		  Scanner sc = new Scanner(in);
		  for (int i=0; i<N; i++)
			  for (int j=0; j<N; j++)
				  matica[i][j] = sc.nextDouble();
		  // tlac trasnponovanej matice, staci vymenit indexy...
		  for (int i=0; i<N; i++) {
			  for (int j=0; j<N; j++) 
				// predpisany format realneho cisla  
			    System.out.printf("%7.2f", matica[j][i]);
			  System.out.println();
		  }		  
	  } catch (Exception E) {
		  System.err.println("Error:" + E.getMessage());
	  }		
  }
}
