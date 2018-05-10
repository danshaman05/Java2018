package H3;

import java.io.*;

public class PexesoState implements Serializable {
    static final int SIZE = 10;
    static final int POCETKARTICIEK = 39;
    /*boolean[][] otocene = new boolean[SIZE][SIZE];
    int[][] postava = new int[SIZE][SIZE];*/
    Karticka[][] plocha = new Karticka[SIZE][SIZE];

    public PexesoState() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                plocha[i][j] = new Karticka(POCETKARTICIEK);
            }
        }
    }

    public void save(String filePath) {
        File f = new File(filePath);
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PexesoState load(String filePath) {
        File f = new File(filePath);
        ObjectInputStream os = null;
        PexesoState state = null;
        try {
            os = new ObjectInputStream(new FileInputStream(f));
            state = (PexesoState) os.readObject();
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (state == null) System.out.println("State je null");
        else System.out.println("State je OK");
        return state;
    }
}
