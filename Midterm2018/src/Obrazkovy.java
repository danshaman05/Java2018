import java.util.HashSet;
import java.util.Set;

// 3.priklad
public class Obrazkovy {

    public static void main(String[] args) {
        { // kod 1
            int[] B = {0,1,2};
            int[][]A = {B,B};
        }
        { // kod 2 neexistuje, lebo int nemoze byt null
        }
        { // kod 3 neexistuje, lebo String nevzera ako pole
        }
        { // kod 4
            String mt = "Midterm";
            String[] B = {mt, mt};
            String[][]A = {B,B,{mt}};
        }
        { // kod 5
            Integer[][]p ={{},{1},null,{3,3,3}};
            //Integer[][]p =new Integer[][]{{},{1},null,{3,3,3}};
            Integer[][] clon = (Integer[][])p.clone();
            p[1] = p[3];
            p[2] = new Integer[]{2,2};
            System.out.println(clon[0].length);  // 0
            //System.out.println(clon[1][1]);  // AIOoB
            //System.out.println(clon[2].length);  // NPE
        }
        {
            // kod 6
            Ovocie[] p = { new Hruska(), new Jablko() };
        }
        { // kod 7
            System.out.println(new Pomelo().equals(new Pomelo()));
            HashSet<Pomelo> pp = new HashSet<>();
            pp.add(new Pomelo());
            pp.add(new Pomelo());
            System.out.println(pp.size() == 1);
        }
        { // kod 8
            String[] pole = {"java",null,"kava"};
            for(String p:pole) {
            	System.out.println(p+p); // javajava, nullnull, kavakava
        }
        }
        {  // kod 9
            String[] pole1 = { "Jezibaba" };
            String[] pole2 = pole1;

            pole2 = new String[]{"Janko", "Marienka"};
            //System.out.println(pole1[1]);  // Array index of of bounds .. R
            pole1 = pole2;
            pole2[1] = "Saxana";

            System.out.println(pole1[1].equals("Janko")); // false
            System.out.println(pole1[1] == new String("Janko")); // false
        }
        { // kod 10
            Set<String> ms = new HashSet<String>();
            //Set<String> ns = new Set<String>();  // cannot convert HashSet to MySet ...S
            //HashSet<String> hs = new Set<String>(); // set is abstract ...
            HashSet<String> gs = new HashSet<String>();
        }
        { // kod 11
            //MySet<String>[] pole5 = new HashSet<String>[5];  // cannot create generic array... S
            //MySet<String> xx = new HashSet<String>(); // cannot convert ArrayList<HashSet> to ArrayList<MySet> ...S
            //ArrayList<MySet<String>> al1 = new ArrayList<HashSet<String>>(); // cannot convert ArrayList<HashSet> to ArrayList<MySet> ...S
        }
        { // kod 12
            {
                int a = 123456;
                if (a % 8 > 0) a++;
                System.out.println(a);
                int b = (a / 256) % 256;
                System.out.println(b);
            }
            {
                int a = 123456;
                System.out.println(a);
                if ((a & 0b111) != 0) a++;
                int b = (a >> 8) & 0xFF;
                System.out.println(b);
            }
        }
    }
}
class MySet<E> extends HashSet<E> { }
class Hruska extends Ovocie {}
class Jablko extends Ovocie {}
class Ovocie{}
class Pomelo {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    @Override
    public int hashCode() {
        return 0;
    }
}