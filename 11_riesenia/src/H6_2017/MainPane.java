package H6_2017;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	final int SIZE = 6;
	TopPane tp;
	BottomPane bp;
	PexesoPane pp;
	PexesoState ps;
	
	public MainPane(){
		tp = new TopPane();
		ps = new PexesoState(SIZE);
		bp = new BottomPane(ps);
		pp = new PexesoPane(ps, SIZE);

		setTop(tp);
		setBottom(bp);
		setCenter(pp);
		layoutBoundsProperty().addListener((observable, oldB, newB)->{
			for (Node n : pp.getChildren()) {
				Control c = (Control)n;
				c.setPrefSize(getWidth() / SIZE, getHeight() / SIZE);
			}
		});
	}
}
