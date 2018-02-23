
public class Binarne {
	/*
	 * Nap�te program, ktor� pre zadan� ��slo 
	 * vyp�e po�et jednotiek v jeho bin�rnom z�pise. 
	 * Napr�klad, pre 10 vyp�e 2.
	 */
	
	public static void bin(long cislo) {
		int pocet = 0;
		long tmp = cislo;
		while (tmp != 0) {
			if ((tmp & 1) == 1) {
				pocet++;
			}
			tmp = tmp >>> 1;
		}
		
		System.out.println(pocet);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bin(15);
		bin(14);
		bin(10);
		bin(-1);
	}

}
