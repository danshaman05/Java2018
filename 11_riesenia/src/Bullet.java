import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bullet {
	public double x, y, dx, dy;

	public Bullet(double x, double y, double dx, double dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}

	public void update(){
		System.out.println(x +" "+ y);
		x += dx;
		y += dy;
	}

	public void paint(GraphicsContext gc) {
		gc.setFill(Color.RED);
		gc.fillOval(x, y, 3, 3);
	}
}
