import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application implements Runnable {

	int width, height;
	WritableImage paintedCanvas;
	PlayGround playground;
	Player player;
	KeyHandler keyHandler;
	MouseHandler mouseHandler;
	ArrayList<Bullet> bullets;

	// vas kod

	Thread thread;
	boolean running;

	@Override
	public void start(Stage primaryStage) {
		width = 800;
		height = 600;
		paintedCanvas = new WritableImage(width, height);

		// vas kod
		playground = new PlayGround();

		keyHandler = new KeyHandler();
		playground.setOnKeyPressed(keyHandler);
		playground.setOnKeyReleased(keyHandler);

		mouseHandler = new MouseHandler();
		playground.setOnMouseClicked(mouseHandler);

		player = new Player(width / 2, height / 2);
		bullets = new ArrayList<>();

		mouseHandler.bullets = bullets;
		mouseHandler.player = player;

		running = true;
		thread = new Thread(this);
		thread.start();

		Scene scene = new Scene(new Pane(playground));
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hra");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
	}

	public void run() {
		while (running) {
			player.update(keyHandler, paintedCanvas);
			synchronized (bullets){
				for (Bullet b : bullets) {
					b.update();
				}
			}

			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					playground.paint();
					player.paint(playground.getGraphicsContext2D());
					synchronized (bullets){
						for (Bullet b : bullets) {
							b.paint(playground.getGraphicsContext2D());
						}
					}

				}
			});
		}
	}

	class PlayGround extends Canvas {


		public PlayGround() {
			// vas kod
			setWidth(width);
			setHeight(height);
			setFocusTraversable(true);
		}

		public void paint() {
			GraphicsContext gc = getGraphicsContext2D();
			gc.clearRect(0, 0, width, height);

			gc.setStroke(Color.BLACK);
			gc.setLineWidth(10);
			gc.strokeRect(0, 0, width, height);

			gc.strokeLine(width / 2, 0, width / 2, height / 2);

			snapshot(null, paintedCanvas);
		}
	}

}