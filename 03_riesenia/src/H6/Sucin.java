
public class Sucin extends Polynom {
	private Polynom p1;
	private Polynom p2;
	
	@Override
	double valueAt(String[] vars, double[] values) {
		return p1.valueAt(vars, values) * p2.valueAt(vars, values);
	}

	@Override
	Polynom derive(String var) {
		
		return new Sucet(
				new Sucin(p1.derive(var), p2),
				new Sucin(p2.derive(var), p1));
	}

	@Override
	public String toString() {
		return "(" + p1 + " * " + p2 + ")";
	}

	public Sucin(Polynom p1, Polynom p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public static void main(String[] args) {
		Polynom p1 = new Sucet(new Sucin(new Premenna("x"), new Premenna("x")), new Konstanta(1) );
		
		System.out.println(p1);
		System.out.println(p1 + "..." +p1.valueAt(new String[]{"x"}, new double[]{3}));
		
		Polynom p2 = p1.derive("x"); // 2*x
		System.out.println(p2); // 6
	}
}
