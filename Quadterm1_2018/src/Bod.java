public class Bod {
	private double x, y;

	public Bod() {
		this(0,0);
	}
	public Bod(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Bod [x=" + x + ", y=" + y + "]";
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
