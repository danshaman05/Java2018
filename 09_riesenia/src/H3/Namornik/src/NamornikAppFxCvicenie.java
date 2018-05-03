import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Jednoducha aplikacia s jednym namornikom, ktory chodi nahodne po kruhovom mole a
 * utopi sa
 */
public class NamornikAppFxCvicenie extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane(new NamornikCanvas()); // do panelu vlozime Canvas
		Scene scene = new Scene(pane);				// vytvor scenu
		primaryStage.setTitle("Opity namornik"); 	// pomenuj okno aplikacie,
													// javisko
		primaryStage.setScene(scene); 	// vloz scenu do hlavneho okna, na javisko
		primaryStage.show(); 			// zobraz javisko
	}

}

class NamornikCanvas extends Canvas {
	/** sirka*/
	int sizeX = 600;
	/** vyska */
	int sizeY = 600;
	/** suradnice stredu mola (x) */
	int centerX = sizeX / 2;
	/** suradnice stredu mola (y) */
	int centerY = sizeY / 2;
	/** skalovaci koeficient na prepocitavanie molovych a pixlovych suradnic */
	int scale = 25;
	/** velkost mola v molovych suradniciach */
	int moloSize = 10;
	/** na mole chodi jeden namornik */
	private NamornikFx namornik1;
    private NamornikFx namornik2;

	public NamornikCanvas() {
		this.setWidth(sizeX);
		this.setHeight(sizeY);
		// TODO
        namornik1 = new NamornikFx(this);
        namornik2 = new NamornikFx(this);
        namornik1.setIny(namornik2);
        namornik2.setIny(namornik1);
        namornik1.start();
        namornik2.start();
		// vytvor namornika
		// spusti jeho simulaciu
	}

	public void paintCanvas() {
		GraphicsContext gc = getGraphicsContext2D();	// kreslenie do canvasu
		gc.clearRect(0, 0, sizeX, sizeY);
		gc.setFill(Color.gray(0, 0.2));
		gc.fillOval(centerX - scale * moloSize, centerY - scale * moloSize,
					scale * 2 * moloSize, scale * 2 * moloSize);
		/**
		 * vykresli namornika na jeho aktualnych suradniciach do grafickej
		 * plochy
		 */
        kresliNamornika(gc, namornik1);
        kresliNamornika(gc, namornik2);
    }

    private void kresliNamornika(GraphicsContext gc, NamornikFx namornik1) {
        if (namornik1.alive) { // ak sa este neutopil, nakresli obrazok namornika
            gc.drawImage(namornik1.img, namornik1.getXPixel(false), namornik1.getYPixel(false));
            // TODO
            //... kresli ziveho namornika
        } else { // ak uz je utopeny, nakresli vlny
            gc.setStroke(Color.BLUE);
            gc.strokeOval(namornik1.getXPixel(true) - 15, namornik1.getYPixel(true) - 15, 30, 30);
            gc.strokeOval(namornik1.getXPixel(true) - 25, namornik1.getYPixel(true) - 25, 50, 50);
            gc.strokeOval(namornik1.getXPixel(true) - 35 , namornik1.getYPixel(true) - 35, 70, 70);
            // TODO
            //... kresli utopeneho namornika
        }
    }
}

/**
 * @author PP
 */

/**
 * Trieda reprezentuje opiteho namornika, ktory sa nahodne pohybuje po kruhovom
 * mole az kym nespadne do vody. Namornik je vizualizovany obrazkom zo suboru
 * namornik.gif alebo po utopeni sustrednym vlnenim na povrchu hladiny.
 */
class NamornikFx extends Thread {
	/** poloha namornika - x */
	double x;
	/** poloha namornika - y */
	double y;
	/** obrazok namornika - je zdielany medzi vsetkymi namornikmi */
	static Image img;
	static Image vychodzi;
	static Image rum;
	/** maximalna velkost kroku namornika v x-ovej a y-ovej zlozke */
	double stepSize = 1.75;
	/** referencia na canvas, kde sa namornik tacka */
	NamornikCanvas molo;
	/** ci namornik este nespadol do vody */
	boolean alive = true;
	/** velkost najvacsieho kruhu vlniek po utopeni namornika */
	final int waves = 30;
	/** pocet krokov namornika */
	int nsteps = 0;
    Random rnd = new Random();
    NamornikFx iny;


    public void setIny(NamornikFx iny) {
        this.iny = iny;
    }

    public NamornikFx(NamornikCanvas where) {
		/** vytvori namornika v bode (0,0) */
		molo = where; // zapamataj si referenciu na canvas s molom
		// pre istotu synchronizujeme, aby sme obrazok urcite nacitali iba raz
		if (vychodzi == null) // ak obrazok este nie je nacitany, nacitaj ho
			vychodzi = new Image("namornik.gif");

        if (rum == null) // ak obrazok este nie je nacitany, nacitaj ho
            rum = new Image("namornik_rum.gif");
		// zaciname v bode (0,0)
        img = vychodzi;
		x = 0.0;
		y = 0.0;
	}

	public void run() {
        int pocitadlo = 0;
        boolean pijem = false;
		/** main() metoda pre namornika - nahodny pohyb */
		while (alive) /* TODO: kym sa drzi na mole */  {
		    x += rnd.nextDouble() * stepSize - (stepSize / 2);
            y += rnd.nextDouble() * stepSize - (stepSize / 2);
            if(Math.abs(x - iny.x) < 0.5 && Math.abs(y - iny.y) < 0.5 && pocitadlo > 5) {
                pocitadlo = 0;
                img = rum;
                pijem = true;
            }
            /*
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    molo.paintCanvas();
                }
            });*/
            Platform.runLater(() -> molo.paintCanvas());
            if ((x * x + y * y) > molo.moloSize * molo.moloSize)
                break;
			//nsteps++;
			pocitadlo++;
            try {
			    if (pijem) {
			        sleep(1000);
			        pijem = false;
                    img = vychodzi;
                }
                else sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
		// ak spadol z mola, nie je nazive
		alive = false;
	}

	/**
	 * konvertuje molove suradnice na pixelove suradnice (x)
	 * 
	 * @param center
	 *            - ci chceme stred namornika (true) alebo jeho lavy horny roh
	 *            (false)
	 */
	public double getXPixel(boolean center) {
		return molo.centerX + (int) (x * molo.scale)
				- (center ? 0 : (img.getWidth() / 2));
	}

	/**
	 * konvertuje molove suradnice na pixelove suradnice (y)
	 * 
	 * @param center
	 *            - ci chceme stred namornika (true) alebo jeho lavy horny roh
	 *            (false)
	 */
	public double getYPixel(boolean center) {
		return molo.centerY + (int) (y * molo.scale)
				- (center ? 0 : (img.getHeight() / 2));
	}
}
