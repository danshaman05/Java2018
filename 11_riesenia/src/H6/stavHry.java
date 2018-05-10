package H6;
import java.util.ArrayList;
import java.util.Collections;

public class stavHry {

	int pocetRiadkov,pocetStlpcov;
	int[][] indexPokemonov;	
	
	public stavHry(int pocetR, int pocetS) {
		pocetRiadkov = pocetR;
		pocetStlpcov = pocetS;
		indexPokemonov = new int[pocetR][pocetS];
		
		ArrayList<Integer> cisloPokemonov = new ArrayList<Integer>();
		for(int i=0; i<pocetR*pocetS/2; i++)
		{
			cisloPokemonov.add(i);
			cisloPokemonov.add(i);
		}
		Collections.shuffle(cisloPokemonov);
		int k=0;
		for(int i=0; i<indexPokemonov.length; i++)
		{
			for(int j=0; j<indexPokemonov[i].length; j++)
			{
				indexPokemonov[i][j] = cisloPokemonov.get(k);
				k++;
			}
		}
	}
	
	public int getIndex(int r, int s) {
		return indexPokemonov[r][s];
	}
}
