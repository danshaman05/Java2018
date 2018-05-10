package H3;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GUIKarticka extends Pane {
    Karticka karticka;

    public GUIKarticka(Karticka karticka) {
        this.karticka = karticka;
        this.setWidth(40);
        this.setHeight(40);
        this.setOnMousePressed(e -> {
            karticka.otocena = !karticka.otocena;
            paint();
        });
    }

    public void paint() {
        //System.out.println("gu karticka");
        getChildren().clear();
        if (karticka.otocena) {
            System.out.println("gu karticka otocena");
            ImageView obrazok = new ImageView("file:images/" + karticka.id + ".gif");
            getChildren().add(obrazok);
            //System.out.println("Vykreslujem obrazok " + karticka.id + " " + getWidth() + " " + getHeight());
        } else {
            Rectangle rectangle = new Rectangle(0,0,40,40);
            rectangle.setFill(Color.GRAY);
            rectangle.setStroke(Color.BLACK);
            getChildren().add(rectangle);
        }
        //setStyle("-fx-background-color: #00FF00");
    }
}
