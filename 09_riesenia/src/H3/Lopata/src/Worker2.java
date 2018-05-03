import java.util.Random;

public class Worker2 extends Thread{

    Random rnd = new Random();
    Lopata lopata;
    int counter = 0;

    public Worker2(String name, Lopata l){
        super(name);
        this.lopata = l;
    }

    public void run(){

        try {
            while (counter < 5000) {
                System.out.println(getName() + " chce lopatu");
                long startTime = System.currentTimeMillis();
                //sf.acquire();

                synchronized (lopata){
                    if(lopata.aktualnyPocet == 0){
                        lopata.wait();
                    }
                    lopata.aktualnyPocet--;
                }

                //pracuje
                long cakal = System.currentTimeMillis() - startTime;
                System.out.println(getName() + " ziskal lopatu po "+ cakal +" milisekundach a ide pracovat");
                int workTime = rnd.nextInt(1000);
                sleep(workTime);
                counter += workTime;

                System.out.println(getName() + " robotnik vratil lopatu");
                //sf.release();

                synchronized (lopata){
                    lopata.aktualnyPocet++;
                    lopata.notify();
                }

                //oddychuje
                sleep(rnd.nextInt(1000));
            }
            System.out.println(getName() + " robotnik skoncil");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
