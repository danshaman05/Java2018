import java.util.Random;

public class Rieka extends Thread{
	public int stlpec;
	public Rieka() {
		Random rand = new Random();
		stlpec = rand.nextInt(20);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		try {
			while(true) {
					stlpec+=rand.nextInt(3)-1;
					if (stlpec < 0) {
						stlpec = 0;
					}
					if (stlpec > 19) {
						stlpec = 19;
					}
//					System.out.println(getName()+" "+stlpec);
					sleep(rand.nextInt(2000));
				} 
			}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

}
