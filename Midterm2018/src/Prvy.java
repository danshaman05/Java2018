// 1.priklad

public class Prvy {

	static long rekurzia(long n, long r) {
		if (n == 0)
			return r;
		else
			return rekurzia(n / 10, 10 * r + n % 10);
	}
	static long foo(long n) {
		return rekurzia(n, 0);
	}

	static long goo(long n) {
		long vysledok = 0;
		while (n != 0) {
			vysledok <<= 1; 
			vysledok +=  n & 1 ;
			n >>= 1;
		}
		return vysledok;
	}

	public static void main(String[] args) {
		System.out.println(foo(12345));
		System.out.println(goo(13));
		for (int max = 0; max < 11; max ++)
			System.out.printf("2^%d  = %5d, \t %12s\n" , max, (int)(Math.pow(2, max)), 
					Integer.toBinaryString((int)(Math.pow(2, max))));

		
		for (int max = 999; max > 0; max --)
			if (foo(max) == max) {
				System.out.println("maximalne 3-ciferne pre foo " + max);
				break;
			}
		for (int max = 999; max > 0; max --)
			if (goo(max) == max) {
				System.out.println("maximalne 3-ciferne goo " + max + ", " +  Integer.toBinaryString(max));
				break;
			}
		for(int i = 0; i<999; i++)
			if (foo(i) == i && i == goo(i))
				System.out.println(i);
	}
}
