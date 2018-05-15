package Client;
import java.util.HashSet;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler implements EventHandler<KeyEvent>{

	HashSet<KeyCode> pressed = new HashSet<>();

	@Override
	public void handle(KeyEvent key) {
		if (key.getEventType() == KeyEvent.KEY_PRESSED) pressed.add(key.getCode());
		if (key.getEventType() == KeyEvent.KEY_RELEASED) pressed.remove(key.getCode());
	}
}
