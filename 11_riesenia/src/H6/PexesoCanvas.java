package H6;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PexesoCanvas extends Canvas{
	int imgId;
	int posX;
	int posY;
	boolean hide = true;
	Main main;
	
	public PexesoCanvas(int imgId, int posX, int posY, Main main) {
		//super();
		this.imgId = imgId;
		this.posX = posX;
		this.posY = posY;
		this.main = main;
		
		setWidth(50);
		setHeight(50);
		
		setOnMouseClicked(event -> {
			hide = !hide;
			paint();
		});
		
		
		paint();
	}
	
	public void paint() {
		GraphicsContext gc = getGraphicsContext2D();
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.GRAY);
		gc.fillRect(0, 0, getWidth(), getHeight());
		gc.strokeRect(0, 0, getWidth(), getHeight());
		if (!hide) gc.drawImage(main.obrazky.get(imgId), 0, 0, getWidth(), getHeight());
		
	};
	
	
}
