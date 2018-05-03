import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Lopata l = new Lopata();
        for (int i = 0; i < 5; i++) {
            new Worker2(i + "", l).start();
        }
    }
}
