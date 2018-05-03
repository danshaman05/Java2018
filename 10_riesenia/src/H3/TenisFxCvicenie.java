package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.util.Random;

public class TenisFxCvicenie extends Application implements Runnable {
    static PlayGround pg;
    Thread thread;
    boolean gameOver;
    int Width = 800;
    int Height = 600;

    Player p1 = new Player(50, Width/10, Height/2, Color.BLUE, KeyCode.W, KeyCode.S);
    Player p2 = new Player(50, 9*Width/10, Height/2, Color.RED, KeyCode.UP, KeyCode.DOWN);
    Ball b = null;

    @Override
    public void start(Stage primaryStage) {
        Random rnd = new Random();
        b = new Ball(Width/2, Height/2, 20, 3, 0, Color.YELLOW);

        pg = new PlayGround();
        pg.setOnMousePressed(event -> {
            System.out.println(event.getX() + " " + event.getY());
            System.out.println(event.getButton());
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                p1.x = event.getX();
                p1.y = event.getY();
            } else if (event.getButton().equals(MouseButton.SECONDARY)){
                p2.x = event.getX();
                p2.y = event.getY();
            }
            pg.paint();
        });
        pg.setFocusTraversable(true);

        pg.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            p1.move(event.getCode());
            p2.move(event.getCode());
            pg.paint();
        });

        Scene scene = new Scene(new Pane(pg));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tenis");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void stop() {
        gameOver = true;
        try {
            thread.join();
        } catch (InterruptedException e) { }
    }

    public void run() {
        System.out.println("started");
        while (!gameOver) {
            // simulacia
            // sleep
            // vykreslenie
        }
    }

    class Ball extends Thread{
        double x, y;
        int size;
        double dx, dy;
        Color c;

        public Ball(double x, double y, int size, int dx, int dy, Color c) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dx = dx;
            this.dy = dy;
            this.c = c;

        }

        @Override
        public void run() {
            super.run();
            while (x > 0 && x < Width){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (y-size < 0){
                    dy = -dy;
                }
                if (y+size > Height){
                    dy = -dy;
                }
                if (x - size <= p1.x && (y > p1.y - p1.size/2 && y < p1.y + p1.size/2)){
                    if (dx > 0){
                        dx = -dx-0.1;
                    } else {
                        dx = -dx+0.1;
                    }
                }
                if (x + size >= p2.x && (y > p2.y - p2.size/2 && y < p2.y + p2.size/2)){
                    if (dx > 0){
                        dx = -dx-0.1;
                    } else {
                        dx = -dx+0.1;
                    }
                }
                x += dx;
                y += dy;
                pg.paint();
            }
        }
    }

    class Player{
        double x, y;
        int size;
        Color c;
        final KeyCode up;
        final KeyCode down;
        final int distance = 10;

        Player(int size, double x, double y, Color c, KeyCode up, KeyCode down){
            this.size = size;
            this.x = x;
            this.y = y;
            this.c = c;
            this.up = up;
            this.down = down;
        }

        public void move(KeyCode code) {
            if (code.equals(up)){
                y -= distance;
            } else if (code.equals(down)) {
                y += distance;
            }
        }

    }

    class PlayGround extends Canvas {
        public PlayGround() {
            setWidth(Width);
            setHeight(Height);

            paint();
            b.start();
        }

        public void paint() {
            GraphicsContext gc = getGraphicsContext2D();

            // kreslenie do gc
//            gc.rect(0, 0, Width, Height);
            gc.setFill(Color.PINK);
            gc.fillRect(0 ,0 , Width, Height);
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(10);
            gc.strokeRect(1, 1 , Width - 1, Height - 1);

            gc.setLineWidth(2);
            gc.setStroke(Color.BLACK);
            gc.strokeLine(Width/2, 0, Width/2, Height);

            gc.setLineWidth(5);
            gc.setStroke(p1.c);
            gc.strokeLine(p1.x, p1.y - (p1.size/2), p1.x, p1.y + (p1.size/2));

            gc.setLineWidth(5);
            gc.setStroke(p2.c);
            gc.strokeLine(p2.x, p2.y - (p2.size/2), p2.x, p2.y + (p2.size/2));

            gc.setFill(b.c);
            gc.fillOval(b.x - b.size/2, b.y - b.size/2, b.size, b.size);
        }
    }
}
