import static org.junit.Assert.*;

import org.junit.Test;

public class Pole2DTest {

	@Test
	public void testPocet() {
		assertEquals(6, Pole2D.pocet(Polia.pole1));
		assertEquals(6, Pole2D.pocet(Polia.pole2));
		assertEquals(0, Pole2D.pocet(Polia.pole3));
		assertEquals(0, Pole2D.pocet(Polia.pole4));
	//	fail("Not yet implemented");		
	}

}
