package H3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Main extends Application {

    Label lbPlayer = new Label("Player");
    Label lbCas = new Label("Cas");
    PexesoState state = new PexesoState();
    Playground playground;
    BorderPane root;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root = new BorderPane();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Button load = new Button("Load");
        Button save = new Button("Save");
        Button quit = new Button("Quit");

        load.setOnAction(e -> {
            System.out.println("Clicked on load button");
            state = PexesoState.load("savedGame");
            refresh();
        });

        save.setOnAction(e -> {
            System.out.println("Clicked on save button");
            state.save("savedGame");
        });

        quit.setOnAction(e -> {
            System.out.println("Clicked on quit button");
            //System.exit(0);
            Platform.exit();
        });

        refresh(); //vytvori novy playground
        HBox topPanel = new HBox(lbPlayer,lbCas);
        HBox bottomPanel = new HBox(load,save,quit);
        root.setTop(topPanel);
        root.setBottom(bottomPanel);

        topPanel.setAlignment(Pos.CENTER);
        topPanel.setSpacing(40);
        bottomPanel.setAlignment(Pos.CENTER);
        bottomPanel.setSpacing(20);
    }

    public void refresh() {
        this.playground = new Playground(state);
        playground.paint();
        root.setCenter(playground);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
