import java.util.Random;

public class Rieky2 {
	Rieka[] rieky;
	Printer p;
	private Random rnd = new Random();

	public Rieky2(final int POCET) {
		rieky = new Rieka[POCET];
		for(int i = 0; i<POCET; i++) {
			rieky[i] = new Rieka();
			rieky[i].start();
		}
		p = new Printer();
		p.start();
	}
	synchronized public int alive() {
		int counter = 0;
		for(int i = 0; i < rieky.length; i++) {
			if (rieky[i] == null)
				continue;
			if (rieky[i].isAlive)
				counter++;
		}
		return counter;
	}
	synchronized public void killAll() {
		int counter = 0;
		for(int i = 0; i < rieky.length; i++) {
			if (rieky[i] != null)
				rieky[i].isAlive = false;
		}
	}
	synchronized public void checkCollision(Rieka r) {
		if (rieky == null)
			return;
		for(int i = 0; i < rieky.length; i++) {
			if (rieky[i] == null)
				continue;
			if (rieky[i] != r &&
					rieky[i].index == r.index) {
				r.isAlive = false;
				System.out.println("collistion");
			}
		}
	}
	class Rieka extends Thread {
		private int index;
		private boolean isAlive = true;
		
		public Rieka(int index) {
			super();
			this.index = index;
			this.isAlive = true;
		};
		// nahodna rieka
		public Rieka() {
			super();
			this.isAlive = true;
			this.index = rnd.nextInt(80);
		};
		public void update() {
			int delta = rnd.nextInt(3)-1;
			index += delta;
			if (index < 0)
				index = 0;
			if (index >= 80)
				index = 79;
		}
		public void run() {
			while (isAlive) {
				update();
				checkCollision(this);
				int delay = rnd.nextInt(500)+300;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("dead");
		}
	}
	class Printer extends Thread {
		public Printer() {
			
		}
		public void run() {
			int finito = 10;
			while (finito > 0) {
				StringBuffer sb = new StringBuffer(
					"                                                                                "	
						);
				for(int i = 0; i < rieky.length; i++) {
					if (rieky[i].isAlive) {
						sb.setCharAt(rieky[i].index, 'o');
					}
				}
				System.out.println(sb.toString());
				if (alive() == 1)
					finito--;
				int delay = rnd.nextInt(250);
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			killAll();
			System.out.println("finito");
		}
	}
	public static void main(String[] args) {
		Rieky2 r2 = new Rieky2(10);
		
	}
}
