import java.io.*;

public class BNode< E extends Comparable< E>> implements Serializable {
    BNode< E> left;		// ľavý podstrom
    BNode< E> right;		// pravý podstrom
    E kluc;  			// hodnota vrchola
    public BNode(BNode< E> left, E key, BNode< E>right) {  // konštruktor
        this.left=left; this.kluc =key; this.right = right;
    }

    @Override
    public String toString() {
        return "BNode{" +
                "left=" + left +
                ", kluc=" + kluc +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        /*
        BNode<Integer> strom = new BNode<>
                (new BNode<>(null, 1, null),
                4,
                new BNode<>(null, 3, null));
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream(
                    new File("tree.out")));
            o.writeObject(strom);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (o != null) try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        ObjectInputStream oi = null;
        BNode<Integer> strom2 = null;
        try {
            oi = new ObjectInputStream(new FileInputStream
                    (new File("tree.out")));
            strom2 = (BNode<Integer>) oi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(strom.toString());
        System.out.println(strom2.toString());

    }
}
