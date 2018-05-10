

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BottomPane extends GridPane {
// public class BottomPane extends HBox {
	MainPane pexeso;

	public BottomPane(MainPane pexeso, PexesoState ps) {
		this.pexeso = pexeso;
		Button load = new Button("Load");
		Button save = new Button("Save");
		Button quit = new Button("Quit");
		//setSpacing(50);

		//getChildren().addAll(load, save, quit);
		add(load, 0, 0);
		add(save, 1, 0);
		add(quit, 2, 0);
		setHgap(20);
		setAlignment(Pos.CENTER);
		quit.setOnAction((event)->{
			try {
				System.out.println("quit");
				//pexeso.stop();
				//Platform.exit();
				System.exit(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		save.setOnAction((event)->{
			try {
				System.out.println("save");
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save"));
				oos.writeObject(ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		load.setOnAction((event)->{
			try {
				System.out.println("load");				
				ObjectInputStream oos = new ObjectInputStream(new FileInputStream("save"));
				PexesoState newps = (PexesoState)oos.readObject();
				ps.odkryte = newps.odkryte;
				pexeso.playground.refresh();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
