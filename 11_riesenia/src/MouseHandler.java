
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseHandler implements EventHandler<MouseEvent>{

	public ArrayList<Bullet> bullets;
	public Player player;

	@Override
	public void handle(MouseEvent event) {

		System.out.println("handler");
		double eX = event.getX();
		double eY = event.getY();

		double pX = player.x;
		double pY = player.y;

		double sideX = eX - pX;
		double sideY = eY - pY;

		double angle = Math.atan(sideY / sideX);

		double i = 1;
		if (pX > eX){
			i *= -1;
		}

		Bullet bul = new Bullet(pX, pY, i*Math.cos(angle), Math.sin(angle));
		synchronized (bullets){
			bullets.add(bul);
		}
	}

}
