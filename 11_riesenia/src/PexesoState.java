import java.io.Serializable;

public class PexesoState implements Serializable {

	int[][] pole;			// ktory obrazok je v policku
	boolean[][] odkryte;	// okryty, zakryty
	int time;				// ubehnuty cas
	boolean firstPlayer;	// je na tahu prvy hrac

	public PexesoState(int size){
		time = 0;
		firstPlayer = true;
		pole = new int[size][size];
		odkryte = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				pole[i][j] = (i * size + j) / 2;
				odkryte[i][j] = false;
			}
		}
	}

	public void prepni(int r, int s) {
		odkryte[r][s] = !odkryte[r][s];
	}
}
