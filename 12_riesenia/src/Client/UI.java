package Client;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class UI extends FlowPane{
	
	NetworkHandler networkHandler;
	
	public UI(){
		TextField server = new TextField("localhost");
		server.setFocusTraversable(false);
		
		TextField port = new TextField("65432");
		port.setFocusTraversable(false);
		
		Button connect = new Button("Connect");
		connect.setFocusTraversable(false);
		
		connect.setOnAction(e -> {
			networkHandler.setServerAddress(server.getText());
			networkHandler.setServerPort(port.getText());
			networkHandler.start();
		});
		
		getChildren().add(server);
		getChildren().add(port);
		getChildren().add(connect);
	}
	
	
}
