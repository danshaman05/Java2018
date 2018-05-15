package Client;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
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
	NetworkHandler networkHandler;
	
	ArrayList<Player> clients;

	Thread thread;
	boolean running;

	@Override
	public void start(Stage primaryStage) {
		width = 800;
		height = 600;
		paintedCanvas = new WritableImage(width, height);

		playground = new PlayGround();

		keyHandler = new KeyHandler();
		playground.setOnKeyPressed(keyHandler);
		playground.setOnKeyReleased(keyHandler);

		mouseHandler = new MouseHandler();
		mouseHandler.pg = playground;
		playground.setOnMouseClicked(mouseHandler);

		bullets = new ArrayList<>();

		player = new Player(width / 2, height / 2 + 20, mouseHandler, keyHandler);
		player.bullets = bullets;
		
		networkHandler = new NetworkHandler();

		running = true;
		thread = new Thread(this);
		thread.start();
		
		clients = new ArrayList<Player>();

		Pane pg = new Pane(playground);
		
		BorderPane bp = new BorderPane(pg);
		UI userInterface = new UI();
		userInterface.networkHandler = networkHandler;
		bp.setBottom(userInterface);
		
		Scene scene = new Scene(bp);
		
		
		
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
			
			if (networkHandler.running) networkHandler.sendPlayer(player);

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