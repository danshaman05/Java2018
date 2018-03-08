public abstract class Polynom {

    public static void main(String[] args) {
        Premenna x = new Premenna("x");
        Premenna y = new Premenna("y");
        Konstanta k = new Konstanta(1);

        Sucet s1 = new Sucet(x,y);
        Sucet s2 = new Sucet(s1,k);

        System.out.println(s2.valueAt(new String[] {"x","y"}, new double[]{-2,6}));
    }


    abstract double valueAt(String[] vars, double[] values);
    abstract Polynom derive(String var);

    //abstract Polynom simplify();


}

class Premenna extends Polynom{

    String p;
    public Premenna(String s){
        p = s;
    }

    @Override
    double valueAt(String[] vars, double[] values) {
        for(int i = 0; i < vars.length; i++){
            if (vars[i].equals(p)) return values[i];
        }
        return 0;
    }

    @Override
    Polynom derive(String var) {
        return null;
    }

}

class Konstanta extends Polynom{

    double konst;
    public Konstanta(double k){
        konst = k;
    }

    @Override
    double valueAt(String[] vars, double[] values) {
        return konst;
    }

    @Override
    Polynom derive(String var) {
        return null;
    }
}

class Sucet extends Polynom{

    Polynom p1 ,p2;
    public Sucet(Polynom a, Polynom b){
        p1 = a;
        p2 = b;
    }

    @Override
    double valueAt(String[] vars, double[] values) {
        return p1.valueAt(vars, values) + p2.valueAt(vars, values);
    }

    @Override
    Polynom derive(String var) {
        return null;
    }
}