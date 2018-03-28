public class Pravouholnik extends Utvar {
	private double x, y, sx, sy;
	
	public Pravouholnik(Bod lh, double sx, double sy) {
		super();
		this.x = lh.getX();
		this.y = lh.getY();
		this.sx = sx;
		this.sy = sy;
	}

	@Override
	double obsah() {
		return sx * sy;
	}

	@Override
	double obvod() {
		return 2*(sx+sy);
	}

	@Override
	boolean obsahuje(Bod p) {
		return x <= p.getX() && p.getX() <= x+sx && y <= p.getY() && p.getY() <= y+sy;
	}
}
