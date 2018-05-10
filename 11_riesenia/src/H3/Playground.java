package H3;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Playground extends GridPane {
    PexesoState state;

    public Playground(PexesoState state) {
        this.state = state;
        //setStyle("-fx-background-color: #FFFF00");
        setWidth(400);
        setHeight(400);

        for (int riadok = 0; riadok < PexesoState.SIZE; riadok++) {
            for (int stlpec = 0; stlpec < PexesoState.SIZE; stlpec++) {
                GUIKarticka karticka = new GUIKarticka(state.plocha[riadok][stlpec]);
                this.add(karticka, stlpec, riadok);
                karticka.paint();
            }
        }
    }

    public void paint() {
        for (Node node : getChildren()) {
            if (node instanceof GUIKarticka) {
                ((GUIKarticka) node).paint();
            }
        }
    }
}
