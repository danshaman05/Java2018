package H6_2017;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopPane extends HBox{

	Label nextPlayer;
	Label time;
	Label score;

	public TopPane(){
		nextPlayer = new Label("Next Player");
		time = new Label("Time");
		score = new Label("Score");
		getChildren().add(nextPlayer);
		getChildren().add(time);
		getChildren().add(score);
		setSpacing(10);
	}
}
