import java.util.Random;
import java.util.concurrent.Semaphore;

public class Worker extends Thread {

    Random rnd = new Random();
    Semaphore sf;
    int counter = 0;

    public Worker(String name, Semaphore s){
        super(name);
        sf = s;
    }

    public void run(){
        try {
            while (counter < 10000) {
                System.out.println(getName() + " chce lopatu");
                long startTime = System.currentTimeMillis();
                sf.acquire();

                //pracuje
                long cakal = System.currentTimeMillis() - startTime;
                System.out.println(getName() + " ziskal lopatu po "+ cakal +" milisekundach a ide pracovat");
                int workTime = rnd.nextInt(1000);
                sleep(workTime);
                counter += workTime;

                System.out.println(getName() + " robotnik vratil lopatu");
                sf.release();

                //oddychuje
                sleep(rnd.nextInt(1000));
            }
            System.out.println(getName() + " robotnik skoncil");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
