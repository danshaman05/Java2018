import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
	final int SIZE = 6;		// velkost hracej plochy
	TopPane tp;				// vrchne info
	BottomPane bp;			// sponde riadenie
	PexesoPane playground;			// playground
	PexesoState ps;
	
	public MainPane(){
		tp = new TopPane();
		ps = new PexesoState(SIZE);
		bp = new BottomPane(this, ps);
		playground = new PexesoPane(ps, SIZE);

		setTop(tp);
		setBottom(bp);
		setCenter(playground);
		layoutBoundsProperty().addListener((observable, oldB, newB)->{
			for (Node n : playground.getChildren()) {
				Control c = (Control)n;
				c.setPrefSize(getWidth() / SIZE, getHeight() / SIZE);
			}
		});
	}
}
