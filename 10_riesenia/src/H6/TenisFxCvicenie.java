package application;

import java.awt.event.KeyEvent;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

class MojThread extends Thread {
	boolean running = true;
	double vx;
	double vy;
	double y1;
	double y2;
	double bx;
	double by;
	int width;
	int height;
	final int h = 50;
	final int wr = 5;
	final int rad = 5;
	public MojThread(int width, int height) {
		super();
		Random rand = new Random();
		this.vx = (rand.nextDouble()*2-1)*5;
		this.vy = (rand.nextDouble()*2-1)*5;
		this.y1 = height/2;
		this.y2 = height/2;
		this.bx = width/2;
		this.by = height/2;
		this.width = width;
		this.height = height;
	}

	public void run() {
		while (running) {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			bx += vx;
			by += vy;
			if (by > y1 && by < y1+h && bx <= 50+wr ) {
				bx = 50+wr;
				vx*=-1;
			}
			if (by > y2 && by < y2+h && bx >= width-50 ) {
				bx = width-50;
				vx*=-1;
			}
			
			if (bx < 0 || bx > width) {
				
				running = false;
			}
			if (by < 0 || by > height) {
				vy *= -1;
			}
		}
	}
}

public class TenisFxCvicenie extends Application {
	static PlayGround pg;
	MojThread thread;
	boolean gameOver;
	int width = 600;
	int height = 400;
	@Override
	public void start(Stage primaryStage) {
		pg = new PlayGround();
		thread = new MojThread(600,400);
		Scene scene = new Scene(new Pane(pg),width,height);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tenis");
		primaryStage.show();
		pg.paint();
		Timeline tl = new Timeline(new KeyFrame(new Duration(50), e -> { pg.paint(); }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
        thread.start();
        pg.setOnMouseMoved(e -> {
        	thread.y2 = e.getY() - (double)(thread.h/2);
        });
        pg.requestFocus();
        pg.setOnKeyPressed(e -> {
        	if (e.getCode() == KeyCode.UP) {
        		thread.y1-=10;
        	}
        	if (e.getCode() == KeyCode.DOWN) {
        		thread.y1+=10;
        	}
        });
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void stop() {
		gameOver = true;
		thread.running = false;
		try {
			thread.join();
		} catch (InterruptedException e) { }
	}

	
	class PlayGround extends Canvas {
		public PlayGround() {
			setWidth(width);
			setHeight(height);
		}

		public void paint() {
			GraphicsContext gc = getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.fillRect(0,0,getWidth(),getHeight());
			gc.setFill(Color.WHITE);
			gc.fillRect(50, thread.y1, thread.wr, thread.h);
			gc.fillRect(width-50, thread.y2, thread.wr, thread.h);
			gc.fillOval(thread.bx-thread.rad, thread.by-thread.rad
					, thread.rad, thread.rad);
		}
	}
}
