import java.util.Random;

public class Pole2D {
    public static void main(String[] args) {
        String a[][] = new String[][]{{"yes", "YEs", "asd"}, {"no", "nO", "noo"}};
        String b[][] = new String[][]{{"yes", "YEs", "asd"}, {"no", "nO"}};
        String c[][] = new String[][]{{"yes", "YEs", "asd"}, null};
        String d[][] = new String[][]{null, null};
        String e[][] = new String[][]{{null}};
        //System.out.println(pocet(c));
        for(int i=0;i<10;i++)
            System.out.println(nahodnyRetazec());
    }
    public static int pocet(String[][] a) {
        int p = 0;
        String tmp;
        if(a == null) return 0;
        for(int i=0; i < a.length; i++) {
            if(a[i] != null) {
                for (int j = 0; j < a[i].length; j++) {
                    if(a[i][j] != null) {
                        /*if (a[i][j].equalsIgnoreCase("yes") || a[i][j].equalsIgnoreCase("no")) {
                            p += 1;
                        }*/
                        tmp = a[i][j].toLowerCase();
                        if (tmp.indexOf("yes") != -1 || tmp.indexOf("no") != -1) {
                            p += 1;
                        }
                    }
                }
            }
        }
        return p;
    }

    public static String nahodnyRetazec() {
        Random rnd = new Random();
        String res = "";
        int len = rnd.nextInt(20);
        int rnd_i = 0;
        for(int i=0; i < len; i++) {
            rnd_i = rnd.nextInt('z' - 'a' + 1);
            res += (char)(rnd_i + 'a');
        }
        return res;
    }


}
