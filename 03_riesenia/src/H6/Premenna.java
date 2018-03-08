
public class Premenna extends Polynom{
	private String meno;
	@Override
	double valueAt(String[] vars, double[] values) {
		for (int i = 0; i < vars.length; i++) {
			if (vars[i].equals(meno)) {
				return values[i];
			}
		}
		return 0;
	}

	@Override
	Polynom derive(String var) {

		if (meno.equals(var)) {
			return new Konstanta(1);
		}
		
		return new Konstanta(0);
	}

	@Override
	public String toString() {
		return meno;
	}

	public Premenna(String meno) {
		super();
		this.meno = meno;
	}

}
