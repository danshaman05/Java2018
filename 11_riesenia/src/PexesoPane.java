

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class PexesoPane extends GridPane {

	PexesoState state;

	public PexesoPane(PexesoState s, int SIZE){
		state = s;
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				add(new PexesoButton(state.pole[i][j], i, j, state),j,i);
			}
		}
	}
	public void refresh(){
		System.out.println("refresh");
		for (final Node child : getChildren()) {
			final PexesoButton btn = (PexesoButton) child;
			btn.setIcon();
		}
	}

}
