package H3;
import java.io.Serializable;
import java.util.Random;

public class Karticka implements Serializable {
    int id;
    boolean otocena = false;

    public Karticka(int pocetKarticiek) {
        Random rand = new Random();
        this.id = rand.nextInt(pocetKarticiek) + 1;
    }
}
