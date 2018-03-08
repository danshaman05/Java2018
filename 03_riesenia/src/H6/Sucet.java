
public class Sucet extends Polynom{
	private Polynom p1;
	private Polynom p2;
	@Override
	double valueAt(String[] vars, double[] values) {
		return p1.valueAt(vars, values) + p2.valueAt(vars, values);
	}

	@Override
	Polynom derive(String var) {
		return new Sucet(p1.derive(var), p2.derive(var));
	}
	
	@Override
	public String toString() {
		return "(" + p1 + " + " + p2 + ")";
	}

	public Sucet(Polynom p1, Polynom p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
}
