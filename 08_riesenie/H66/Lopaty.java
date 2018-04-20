import java.util.concurrent.Semaphore;

public class Lopaty {
	
	private static int pocetL= 1;
	private static int pocetR = 2;
	private static Robotnik[] robotnici= new Robotnik[pocetR];
	public static Semaphore semafor = new Semaphore(pocetL, true);
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int i = 0; i< pocetR;i++) {
			robotnici[i]= new Robotnik("Robo"+i);
			robotnici[i].start();
		}
		for (int i = 0; i< pocetR;i++) {
			robotnici[i].join();
		}
		
		System.out.println("Praca skoncila");		
	}	
	

}
