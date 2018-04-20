import java.util.Random;

public class Robotnik extends Thread{
	private int odrobene=0;
	private int sichta = 3000;
	
	public Robotnik(String meno) {
		super(meno);
	}
	
	@Override
	public void run() {
		try {
			while(sichta >= odrobene) {
				Random rand = new Random();
				// spanok
				System.out.println(this.getName()+" zaspava");
				sleep(rand.nextInt(1000));
				System.out.println(this.getName()+" sa zobudza, hlada lopatu");
				
				// praca
				int praca = rand.nextInt(1000); 
				Lopaty.semafor.acquire();
				System.out.println(this.getName()+" zacina pracovat");
				sleep(praca);
				odrobene += praca;
				Lopaty.semafor.release();
				System.out.println(this.getName()+" skoncil pracovat");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
