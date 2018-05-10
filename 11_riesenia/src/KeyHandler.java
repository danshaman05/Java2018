import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent>{

	boolean up, down, left, right;

	@Override
	public void handle(KeyEvent key) {

		if(key.getEventType() == KeyEvent.KEY_PRESSED) {
			if (key.getCode() == KeyCode.UP) {
				up = true;
			}
			if (key.getCode() == KeyCode.DOWN) {
				down = true;
			}
			if (key.getCode() == KeyCode.LEFT) {
				left = true;
			}
			if (key.getCode() == KeyCode.RIGHT) {
				right = true;
			}
		}
		if(key.getEventType() == KeyEvent.KEY_RELEASED) {
			if (key.getCode() == KeyCode.UP) {
				up = false;
			}
			if (key.getCode() == KeyCode.DOWN) {
				down = false;
			}
			if (key.getCode() == KeyCode.LEFT) {
				left = false;
			}
			if (key.getCode() == KeyCode.RIGHT) {
				right = false;
			}
		}
	}
}
