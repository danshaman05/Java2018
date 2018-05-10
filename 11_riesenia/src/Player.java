import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Player {
	public double x, y;
	Image img;

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		img = new Image("player.png");
	}

	public void update(KeyHandler handler, WritableImage canvas) {
		double prevX = x, prevY = y;

		if (handler.up) {
			y -= 1;
		}
		if (handler.down) {
			y += 1;
		}
		if (handler.left) {
			x -= 1;
		}
		if (handler.right) {
			x += 1;
		}
		int[] suradniceX = {(int)(x + img.getWidth() / 2),
							(int)(x + img.getWidth() / 2),
							(int) x,
							(int) (x + img.getWidth())};
		int[] suradniceY = {(int) y,
							(int) (y + img.getHeight()),
							(int) (y + img.getHeight() / 2),
							(int) (y + img.getHeight() / 2)};


		for(int i = 0; i < suradniceX.length; i++){
			if (canvas.getPixelReader().getColor(suradniceX[i], suradniceY[i]).equals(Color.BLACK)) {
				x = prevX;
				y = prevY;
				break;
			}
		}
	}

	public void paint(GraphicsContext gc) {
		gc.drawImage(img, x, y);
	}
}
