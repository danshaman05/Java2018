package H6_2017;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PexesoButton extends Button{

	int hodnota;
	Image obrazok;
	boolean odkryty;
	PexesoState ps;
	int r, s;

	public PexesoButton(int h, int r, int s, PexesoState ps) {
		hodnota = h;
		odkryty = false;
		this.ps = ps;
		this.r = r;
		this.s = s;
		// obrazky su v: workspace\CvicenieB\bin\images_renamed
		obrazok = new Image("images_renamed\\" + (hodnota+1) + ".gif");
		setMinSize(obrazok.getWidth(), obrazok.getHeight());

		setOnAction((event)->{
			odkryty = !odkryty;
			setGraphic(odkryty ? new ImageView(obrazok) : null);
			ps.prepni(r, s);
		});
	}

}
