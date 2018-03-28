public class Kruh extends Utvar {
	private double x, y, r;

	public Kruh(Bod stred, double r) {
		super();
		this.x = stred.getX();
		this.y = stred.getY();
		this.r = r;
	}

	@Override
	double obsah() {
		return Math.PI*r*r;
	}

	@Override
	double obvod() {
		return 2*Math.PI*r;
	}

	@Override
	boolean obsahuje(Bod p) {
		return (x-p.getX())*(x-p.getX()) + (y-p.getY())*(y-p.getY()) <= r*r;
	}
}
