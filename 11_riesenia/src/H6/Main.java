package H6;
	
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public static final int rows = 6;
	public static final int cols = 6;
	
	List<Image> obrazky = new ArrayList<>();
	
	
	
	
	// Layout
	BorderPane root;
	FlowPane buttons;
	FlowPane vrch;
	GridPane plocha;
	
	Button save;
	Button load;
	Button quit;
	
	Label nextPlayer;
	Label time;
	Label score;
	
	stavHry stavHry = new stavHry(rows, cols);
	
	@Override
	public void start(Stage primaryStage) {
		
		for (File s :(new File("images")).listFiles()) {
			obrazky.add(new Image("file:" + s.getAbsolutePath()));
		}
		
		
		
		buttons = new FlowPane();
		save = new Button("save");
		load = new Button("load");
		quit = new Button("quit");
		buttons.getChildren().add(save);
		buttons.getChildren().add(load);
		buttons.getChildren().add(quit);
		buttons.setHgap(10);
		buttons.setVgap(10);
		buttons.setAlignment(Pos.CENTER);
		buttons.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));
		
		nextPlayer = new Label("Next player is: ");
		score = new Label("Score: ");
		time = new Label("Time: ");
		vrch = new FlowPane(nextPlayer, time, score);
		vrch.setHgap(10);
		vrch.setVgap(10);
		vrch.setAlignment(Pos.CENTER);
		vrch.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));
		
		quit.setOnAction(event -> {
			System.exit(0);
		});
		
		
		plocha = new GridPane();
		//plocha.setStyle("-fx-background-color: #000000; ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				plocha.add(new PexesoCanvas(stavHry.getIndex(i, j),i,j,this),i ,j);
			}
		}
		
		root = new BorderPane();
		root.setBottom(buttons);
		root.setTop(vrch);
		root.setCenter(plocha);
		
		// stage
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
