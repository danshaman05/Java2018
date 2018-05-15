package Client;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MouseHandler implements EventHandler<MouseEvent>{
	
	public boolean clickProcessed = true;
	public double x, y;
	Canvas pg;

	@Override
	public void handle(MouseEvent event) {
		clickProcessed = false;
		x = event.getX();
		y = event.getY();
		
		pg.requestFocus();
		
	}
	
	

}
