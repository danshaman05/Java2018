package H6_2017;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BottomPane extends HBox{

	public BottomPane(PexesoState ps){
		Button load = new Button("Load");
		Button save = new Button("Save");
		Button quit = new Button("Quit");

		getChildren().addAll(load, save,quit);

		save.setOnAction((event)->{
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save"));
				oos.writeObject(ps);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		load.setOnAction((event)->{
			try {
				ObjectInputStream oos = new ObjectInputStream(new FileInputStream("save"));
				PexesoState newps = (PexesoState)oos.readObject();
				ps.odkryte = newps.odkryte;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
