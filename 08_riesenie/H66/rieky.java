
public class rieky {
	private static int w = 20;
	private static int pocet = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rieka[] rieky = new Rieka[pocet];
		for (int i =0; i < pocet; i++) {
			rieky[i] = new Rieka();
			rieky[i].start();
		}
		
		
		
		Thread vykreslovac = new Thread(
				() -> {
					try {
						while(true) {
							StringBuilder riadok = new StringBuilder();
							for(int s = 0; s < w; s++) {
								boolean bolaRieka = false;
								for(Rieka r : rieky) {
									if(r.stlpec == s) {
										riadok.append('o');
										bolaRieka = true;
										break;
									}
									
								}
								
								if(!bolaRieka) {
									riadok.append(' ');
								}
								
							}
							System.out.println(riadok);
							Thread.sleep(250);
						}
					}
					catch(InterruptedException e) {}
				});
		vykreslovac.start();
	}

}
