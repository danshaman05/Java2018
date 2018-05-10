package H3_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Labyrinth extends Application {

    private char[][] map;
    private int startX, startY;
    private int finishX, finishY;
    private int velkostStvorceka = 40;
    private int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // vas kod



    	readMap("map.txt");
    	System.out.println(map.length + " pocet stlpcov: " + map[0].length);

    	Playground p = new Playground(startX,startY);
    	Scene sc = new Scene(p, velkostStvorceka*map[0].length,
    							velkostStvorceka*map.length  );
    	p.paint();
    	sc.setOnMouseClicked(event -> {
    		System.out.println("klikol som X " + event.getX());
    		System.out.println("klikol som Y " + event.getY());
    		int x = (int) (event.getX()/velkostStvorceka);
    		int y = (int) (event.getY()/velkostStvorceka);
    		p.gx = x;
    		p.gy = y;
    		p.paint();

    	});
    	Timeline tim = new Timeline(new KeyFrame(Duration.seconds(1),
    			e->{count++;p.paint();}
    	));
    	tim.setCycleCount(Timeline.INDEFINITE);
		tim.play();
    	sc.setOnKeyPressed(event ->{
    		int oldGx = p.gx;
    		int oldGy = p.gy;
    		System.out.println("stlacil som " + event.getCode());
    		if (event.getCode().equals(KeyCode.UP)) {
    			//if (map[p.gy-1][p.gx] != '#') {
    			p.gy--;
    		}
    		else if (event.getCode().equals(KeyCode.DOWN)) {
    			p.gy++;
    		}
    		else if (event.getCode().equals(KeyCode.RIGHT)) {
    			p.gx++;
    		}
    		else if (event.getCode().equals(KeyCode.LEFT)) {
    			p.gx--;
    		}
    		if (map[p.gy][p.gx] == '#') {
    			p.gx = oldGx;
    			p.gy = oldGy;
    		}
    		else if (p.gx == finishX && p.gy == finishY) {
    			p.paint();
    			Text t = new Text(p.getWidth()/2, p.getHeight()/2,
    					":)");
    			t.setFont(new Font("Arial", 20));

    			p.getChildren().add(t);
    		}
    		else {
    			p.paint();
    		}
    	});

    	primaryStage.setScene(sc);
    	primaryStage.show();
    }

    public void readMap(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

            String[] dimensions = br.readLine().split(" ");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);
//            System.out.println(width + " " + height);

            map = new char[height][];

            for (int i = 0; i < height; i++) {
                String row = br.readLine();

                int idxA = row.indexOf('A');
                if (idxA != -1) {
                    startX = idxA;
                    startY = i;
                }

                int idxB = row.indexOf('B');
                if (idxB != -1) {
                    finishX = idxB;
                    finishY = i;
                }

                map[i] = row.toCharArray();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Playground extends Pane {
    	private int gx, gy;

    	public Playground(int x, int y) {
    		this.gx = x;
    		this.gy = y;
    	}

    	public void paint() {
    		this.getChildren().clear();
    		for( int i = 0; i < map.length; i++ ) {
    			for( int j = 0; j < map[i].length; j++ ) {
    				if (Math.abs(gy-i) <= 2 && Math.abs(gx-j) <= 2) {
	    				Rectangle r = new Rectangle(velkostStvorceka, velkostStvorceka, Color.WHITE);
	    				r.setX(j*velkostStvorceka);
	    				r.setY(i*velkostStvorceka);

	    				if( map[i][j] == '#' ) {
	    					r.setFill(Color.BLACK);
	    				} else if( map[i][j] == 'A' ) {
	    					r.setFill(Color.YELLOW);
	    				} else if( map[i][j] == 'B' ) {
	    					r.setFill(Color.BLUE);
	    				}

	    				this.getChildren().add(r);
    				}
    			}
    		}
    		Circle cir = new Circle (gx*velkostStvorceka+velkostStvorceka/2,
    				gy*velkostStvorceka+velkostStvorceka/2, velkostStvorceka/2);
    		cir.setFill(Color.GREEN);
    		this.getChildren().add(cir);
    		Text t = new Text(getWidth()/2, getHeight()/2,
					String.valueOf(count));
			t.setFont(new Font("Arial", 20));
			this.getChildren().add(t);
    	}
    }

}


