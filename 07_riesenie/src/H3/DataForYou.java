import java.io.*;
import java.util.*;

public class DataForYou {
    public static void main(String[] args) {
        Scanner s = null;
        List<String> vsetkyMena = new ArrayList<>();
        try{
            s = new Scanner(new FileInputStream(
                    new File("DataForYou2.txt")));
            while(s.hasNextLine()){
                String riadok = s.nextLine().trim();
                String[] pole = riadok.split(" +");
                vsetkyMena.addAll(Arrays.asList(pole));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenasiel som subor." + e.getMessage());
        } finally {
            if (s != null) s.close();
        }
        System.out.println(vsetkyMena);

        Set<String> mnozina = new TreeSet<>();
        mnozina.addAll(vsetkyMena);
        System.out.println(mnozina.size());
        System.out.println(mnozina);

        Comparator<String> cmp = (o1, o2) -> Integer.compare(o1.length(), o2.length());
        Set<String> mnozina2 = new TreeSet<>(cmp);
        Set<String> mnozina1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        mnozina1.addAll(mnozina);
        //System.out.println("mnozina1" +mnozina1);

        List<String> podlaDlzky = new ArrayList<>(mnozina);
        podlaDlzky.sort(cmp);
        System.out.println(podlaDlzky);

        Map<String, Integer> frekTab = new TreeMap<>();

        for (String meno : vsetkyMena) {
            Integer pocet = frekTab.get(meno);
            frekTab.put(meno, (pocet == null)?1:pocet+1);
        }
        System.out.println(frekTab);
        int maxPocet = 0;
        String najviac = "";
        for (String kluc : frekTab.keySet()) {
            if (frekTab.get(kluc) > maxPocet) {
                maxPocet = frekTab.get(kluc);
                najviac = kluc;
            }
        }
        System.out.println(najviac);
        //frekTab.forEach((kluc, value) -> {maxPocet = 1});
    }
}
