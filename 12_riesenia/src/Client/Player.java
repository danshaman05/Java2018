package Client;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player {
	public double x, y;
	MouseHandler mouseHandler;
	KeyHandler keyHandler;
	ArrayList<Bullet> bullets;
	Image img;

	public Player(double x, double y, MouseHandler mouseHandler, KeyHandler keyHandler) {
		this.x = x;
		this.y = y;
		
		this.mouseHandler = mouseHandler;
		this.keyHandler = keyHandler;
		
		img = new Image("player.png");
	}
	
	public void handleMouse() {
		if (mouseHandler.clickProcessed) return;
		
		double dx = mouseHandler.x - x;
		double dy = mouseHandler.y - y;
		double angle = Math.atan2(dy, dx);

		Bullet bullet = new Bullet(x, y, Math.cos(angle), Math.sin(angle));
		synchronized (bullets){
			bullets.add(bullet);
		}
		
		mouseHandler.clickProcessed = true;
	}
	
	public void handleKeys(WritableImage canvas) {
		double prevX = x, prevY = y;

		if (keyHandler.pressed.contains(KeyCode.UP)) y -= 1;
		if (keyHandler.pressed.contains(KeyCode.DOWN)) y += 1;
		if (keyHandler.pressed.contains(KeyCode.LEFT)) x -= 1;
		if (keyHandler.pressed.contains(KeyCode.RIGHT)) x += 1;
		
		ArrayList<Integer> suradniceX = new ArrayList<>();
		ArrayList<Integer> suradniceY = new ArrayList<>();
		
		for (int i = 0; i < img.getWidth(); i++) {
			// horny okraj
			suradniceX.add((int)(x + i));
			suradniceY.add((int)(y));
			// dolny okraj
			suradniceX.add((int)(x + i));
			suradniceY.add((int)(y + img.getHeight()));
			// lavy okraj
			suradniceX.add((int)(x));
			suradniceY.add((int)(y + i));
			// pravy okraj
			suradniceX.add((int)(x + img.getWidth()));
			suradniceY.add((int)(y + i));
		}

		for(int i = 0; i < suradniceX.size(); i++){
			if (canvas.getPixelReader().getColor(suradniceX.get(i), suradniceY.get(i)).equals(Color.BLACK)) {
				x = prevX;
				y = prevY;
				break;
			}
		}
	}

	public void update(KeyHandler handler, WritableImage canvas) {
		handleMouse();
		handleKeys(canvas);
	}

	public void paint(GraphicsContext gc) {
		gc.drawImage(img, x, y);
	}
}
