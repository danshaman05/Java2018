public class Pole3D {
    public static boolean equalsIgnoreCase(String[][][] a, String[][][] b) {
        if (a==b) {
            return true;
        }
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i]==b[i]) {
                continue;
            }
            if (a[i] == null || b[i] == null || a[i].length != b[i].length) {
                return false;
            }
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]==b[i][j]) {
                    continue;
                }
                if (a[i][j] == null || b[i][j] == null || a[i][j].length != b[i][j].length) {
                    return false;
                }
                for (int k = 0; k < a[i][j].length; k++) {
                    if (a[i][j][k]==b[i][j][k]) {
                        continue;
                    }
                    if (a[i][j][k] == null || b[i][j][k] == null || !a[i][j][k].equalsIgnoreCase(b[i][j][k]) ) {
                        return false;
                    }
                }
            }


        }
        return  true;
    }

    public static void main(String[] args) {
        String p1[][][] = {{{"a"}}};
        String p2[][][] = {{{"A"}}};
        String p3[][][] = {{{null}}};
        String p4[][][] = {{{null}}};
        String p5[][][] = {{{"a"},{null}}};
        String p6[][][] = {{{"A"}}};
        String p7[][][] = null;
        String p8[][][] = {{{"A"}}};
        System.out.println(equalsIgnoreCase(p7, p8) );
    }
}
