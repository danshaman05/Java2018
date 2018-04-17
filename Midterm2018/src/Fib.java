import java.util.HashSet;
import java.util.Set;

// 2.priklad
public class Fib {
    Fib lavy;
    long kluc;
    Fib pravy;

    public Fib(Fib lavy, long kluc, Fib pravy) {
        super();
        this.lavy = lavy;
        this.kluc = kluc;
        this.pravy = pravy;
    }
    @Override
    public String toString() {
        return "[" + lavy + ", " + kluc + ", " + pravy + "]";
    }
    //------------------------- 1 bod
    public Fib(int n) {
        if (n <= 1) {
            lavy = pravy = null;
            kluc = 1;
        } else {
            lavy = new Fib(n-1);
            pravy = new Fib(n-2);
            kluc = lavy.kluc + pravy.kluc;
        }
    }
    //------------------------- 1 bod
    public int hlbka() {
        return 1+Math.max((pravy != null)? pravy.hlbka():0, (lavy != null)? lavy.hlbka():0);
    }
    public int hlbkaE() {
        return (lavy != null)? lavy.hlbkaE()+1:1;
    }
    //------------------------- 1 bod
    public long listy() {
        if (lavy == pravy)
            return 1;
        else
            return ((lavy !=null)? lavy.listy():0) + ((pravy !=null)? pravy.listy():0);
    }
    public long listyE() {
        return kluc;
    }
    //------------------------- 1 bod
    public Set<Long> rozne() {
        if (lavy == pravy)
            return Set.of(kluc);
        else {
            Set<Long> l = (lavy !=null)? lavy.rozne():Set.of();
            Set<Long> r = (pravy !=null)? pravy.rozne():Set.of();
            HashSet<Long>res = new HashSet<>();
            res.addAll(l);
            res.addAll(r);
            res.add(kluc);
            return res;
        }
    }
    public long sucetRoznych() {
        return rozne().stream().reduce(0L, (a,b)->a+b);
    }
    public long sucetRoznychE() {
        return (lavy==null)?1:2* kluc + lavy.kluc-2;
    }
    //------------------------------
    private int isFib() {
        if (lavy == null && pravy == null && kluc == 1)
            return 1;
        else if (lavy != null && pravy != null) {
            int l = lavy.isFib();
            int r = pravy.isFib();
            if (l == 1 && r == 1 && kluc == 2) return 2;
            else return (l != -1 && r != -1 && l == r+1 && kluc == lavy.kluc+pravy.kluc )?l+1:-1;
        } return -1;
    }
    private boolean jeFib() {
        return isFib() != -1;
    }
    //-------------------------------------------------------------------
    public static void main(String[] args) {
        {
            Fib ft = new Fib(6);
            System.out.println(ft);
            System.out.println(ft.hlbka());
            System.out.println(ft.listy());
            System.out.println(ft.sucetRoznych());
            System.out.println(ft.jeFib()
            );
        }
        {
            for (int i = 1; i < 30; i++) {
                Fib ft = new Fib(i);
                if (ft.hlbka() != ft.hlbkaE())
                    System.out.println("rozne vysky");
                if (ft.listy() != ft.listyE())
                    System.out.println("rozne listy");
                if (ft.sucetRoznych() != ft.sucetRoznychE())
                    System.out.println("rozne sucty" + ft.sucetRoznych());
                if (!ft.jeFib()) {
                    System.out.println("nie je fib" + ft);
                    break;
                }
            }
        }
    }
}