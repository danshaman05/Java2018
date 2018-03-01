import java.util.Arrays;
import java.util.Random;

public class Pole2D {

	public static int pocet(String[][] a)
	{
		int pocet = 0;
		if (a == null) {
			return 0;
		}
		for(int i=0; i<a.length;i++)
		{
			if (a[i] == null) {
				continue;
			}
			for(int j=0; j<a[i].length; j++)
			{
				if (a[i][j] == null) {
					continue;
				}
				if(a[i][j].toLowerCase().contains("yes")
				|| a[i][j].toLowerCase().contains("no"))
				{
					pocet++;
				}
			}
		}		
		return pocet;
	}
	public static String nahodnyRetazec() {
		String vysl = "";
		Random rand = new Random();
		int cis = rand.nextInt(20);
		StringBuffer ss = new StringBuffer();
		for (int i = 0; i < cis; i++) {
			int pom = rand.nextInt('Z'-'A'+1);
			pom += 'A';
			char a = (char) pom;
			ss.append(a);
		}
		vysl = ss.toString();
		return vysl;
	}
	public static String[] nahodnePole1D() {
		Random rand = new Random();
		int cis = rand.nextInt(10);
		String[] vys  = new String[cis];
		for (int i = 0; i < cis; i++) {
			vys[i] = nahodnyRetazec();
		}
		return vys;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pocet(Polia.pole1));	
		System.out.println(nahodnyRetazec());
		
		System.out.println(Arrays.deepToString(nahodnePole1D()));
	}

}
