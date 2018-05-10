package H6_2017;

import java.io.Serializable;

public class PexesoState implements Serializable {

	int[][] pole;
	boolean[][] odkryte;
	int time;
	boolean firstPlayer;

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
