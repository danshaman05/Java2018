import java.util.Arrays;

public class Matica {

    private double[][] m;

    public Matica(double[][] m) {
        this.m = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                this.m[i][j] = m[i][j];
            }
        }
    }

    public Matica(int r, int s) {
        this.m = new double[r][s];
    }

    public Matica(int size) {
        this.m = new double[size][size];
        for (int i = 0; i < size; i++) {
            this.m[i][i] = 1;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                str.append(this.m[i][j]).append(' ');
            }
            str.append('\n');
        }
        return str.toString();
    }

    public double hodnota(int r, int s){
        if(r < this.m.length && s < this.m[r].length) {
            return this.m[r][s];
        }
        return 0;
    }

    public Matica plus(Matica m){
        if(this.m.length == m.m.length && this.m[0].length == m.m[0].length) {
            Matica vysl = new Matica(this.m.length, this.m[0].length);
            for (int i = 0; i < this.m.length; i++) {
                for (int j = 0; j < this.m[i].length; j++) {
                    vysl.m[i][j] = this.m[i][j] + m.m[i][j];
                }
            }
            return vysl;
        }
        return null;
    }

    public Matica krat(Matica m2){
        if (this.m[0].length != m2.m.length ) return null;

        Matica m3 = new Matica(m.length, m2.m[0].length);
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m2.m[0].length; j++){
                for (int k = 0; k < m[0].length; k++){
                    m3.m[i][j] += m[i][k] * m2.m[k][j];
                }

            }
        }
        return m3;
    }

    public boolean rovnake(Matica m){
        return toString().equals(m.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matica matica = (Matica) o;

        return Arrays.deepEquals(m, matica.m);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(m);
    }

    public Matica transponuj(){
        Matica m2 = new Matica(m[0].length,m.length);
        for (int i=0;i<m[0].length;++i){
            for (int j=0;j<m.length;++j){
                m2.m[i][j] = m[j][i];
            }
        }
        return m2;
    }

    public static void main(String[] args) {
        double[][] matica = {{1,2,3},{4,5,6}};
        Matica m1 = new Matica(matica);
        Matica m2 = new Matica(4,2);
        Matica m3 = new Matica(5);
        System.out.println(m1.plus(m1));
        System.out.println(m1.plus(m2));
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);


        Matica m4 = new Matica(new double[][]{{1, 2},{3, 4}, {5, 6}});
        Matica m5 = new Matica(new double[][]{{7,9},{8,10}});
        Matica m6 = new Matica(new double[][]{{7}, {8}, {9}});

        System.out.println("m4 x m4");
        System.out.println(m4.krat(m4));
        System.out.println("m4 x m5");
        System.out.println(m4.krat(m5));
        System.out.println("m4 x m6");
        System.out.println(m4.krat(m6));

        System.out.println("m5 x m4");
        System.out.println(m5.krat(m4));
        System.out.println("m5 x m5");
        System.out.println(m5.krat(m5));
        System.out.println("m5 x m6");
        System.out.println(m5.krat(m6));

        System.out.println("m6 x m4");
        System.out.println(m6.krat(m4));
        System.out.println("m6 x m5");
        System.out.println(m6.krat(m5));
        System.out.println("m6 x m6");
        System.out.println(m6.krat(m6));

        System.out.println(m4.transponuj());

    }
}
