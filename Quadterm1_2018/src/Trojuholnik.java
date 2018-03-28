public class Trojuholnik extends Utvar {
	private Bod a, b, c;

	public Trojuholnik(Bod a, Bod b, Bod c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	double obsah() {	// Heronova formula
		return heron(a, b, c);
	}

	@Override
	double obvod() {
		double x1 = a.getX();
		double y1 = a.getY();
		double x2 = b.getX();
		double y2 = b.getY();
		double x3 = c.getX();
		double y3 = c.getY();
		double a = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		double b = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3));
		double c = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
		return a+b+c;
	}

	private static double heron(Bod a, Bod b, Bod c) {
		double x1 = a.getX();
		double y1 = a.getY();
		double x2 = b.getX();
		double y2 = b.getY();
		double x3 = c.getX();
		double y3 = c.getY();
		double s1 = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		double s2 = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3));
		double s3 = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
		double s = (s1+s2+s3)/2;
		return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	}
	@Override
	boolean obsahuje(Bod p) {
        double A = heron(a, b, c);
        double A1 = heron(p, b, c);
        double A2 = heron(a, p, c);
        double A3 = heron(a, b, p);
        return Math.abs(A - (A1 + A2 + A3)) < 0.0005;
    }
}
