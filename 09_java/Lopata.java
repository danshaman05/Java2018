import java.util.Random;
import java.util.concurrent.Semaphore;

public class Lopata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(5,true);
		for (int i = 0; i < 10; i++){
			Robotnik rob = new Robotnik(i, sem);
			rob.start();
		}

	}
	
	

}

class Robotnik extends Thread {
	private int id;
	private Semaphore sem;
	private int odrobene = 0;
	public Robotnik(int id, Semaphore sem){
		this.id = id;
		this.sem = sem;
		
	}
	public void run(){
		Random rnd = new Random();
		long celkovyCas = 0;
		while (odrobene < 1000){
			System.out.println("Spi "+id);
			int cas = rnd.nextInt(1000);
			
			try { 
				sleep(cas);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long cakam = System.currentTimeMillis();
			try {
				System.out.println("Cakam na lopatu "+id);
				sem.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			long cas2 = System.currentTimeMillis() - cakam;
			celkovyCas += cas2;
			System.out.println("Ide pracovat "+id+" cakal na lopatu "+cas2);
			
			cas = rnd.nextInt(1000);
			odrobene += cas;
			try {
				sleep(cas);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sem.release();
			
		}
		System.out.println("Celkovy cas cakania "+id+ " "+celkovyCas);
		
	}
}
