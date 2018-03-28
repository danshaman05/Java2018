public class Piskvorka {
	
	private static boolean piskvorka(char[][] pole, int dx, int dy) {
		final char[] X = { 'X', 'X', 'X', 'X', 'X' };
		final char[] O = { 'O', 'O', 'O', 'O', 'O' };
		return	piskvorka(pole, dx, dy, X) 
				||	// hambim sa, ze to prechadzam 2x, ale lepsie vrabec v hrsti ako vrana na streche 
				piskvorka(pole, dx, dy, O);
	}
	private static boolean piskvorka(char[][] pole, int dx, int dy, char[] pisk) {
		if (pole == null)
			return false;
		for (int i = 0; i < pole.length; i++) {
			if (pole[i] == null)
				continue;
			next:
			for (int j = 0; j < pole[i].length; j++) {
				for (int k = 0; k < pisk.length; k++) {
					int x = i+k*dx;
					int y = j+k*dy;
					if (x < 0 || x >= pole.length || pole[x] == null ||
						y < 0 || y >= pole[x].length || pole[x][y] != pisk[k])
						continue next;
				} // mam ju !
				return true;
			}
		}
		return false;
	}
	public static boolean vRiadku(char[][] pole) {
		return piskvorka(pole, 0, 1); 
	}
	public static boolean vStlpci(char[][] pole) {
		return	piskvorka(pole, 1, 0); 
	}
	public static boolean naDiagonale(char[][] pole) {
		return  piskvorka(pole, 1, 1)  || piskvorka(pole, 1, -1);
	}
}
