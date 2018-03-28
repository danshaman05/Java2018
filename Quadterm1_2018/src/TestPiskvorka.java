import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import LISTTestScoring.LISTTestScoring;

public class TestPiskvorka {

	private static LISTTestScoring scoring = null;

	@BeforeClass
	public static void initScoring() {
		scoring = new LISTTestScoring();
		scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
	}

	@Test	
	public void testvRiadku() {
		assertTrue("case 1", Piskvorka.vRiadku(new char[][]{{'X','X','X','X','X'}}));
		assertTrue("case 2", Piskvorka.vRiadku(new char[][]{{'.','X','X','X','X','X'}}));
		assertTrue("case 3", Piskvorka.vRiadku(new char[][]{{'.','O','O','O','O','O'}}));
		assertFalse("case 4", Piskvorka.vRiadku(new char[][]{{'.','O','O','X','O','O'}}));
		assertFalse("case 5", Piskvorka.vRiadku(new char[][]{{'.','O','O','.','O','O','O'}}));
		assertFalse("case 6", Piskvorka.vRiadku(new char[][]{{'.','O','O','.','O','O','O','X','O','O','O','X'}}));
		assertFalse("case 7", Piskvorka.vRiadku(new char[][]{
			{'.','O','O','.','O','O','O','X','O','O','O','X'},
			{'.','O','X','X','X','X','O','X','O','X','x','X'}	}));
		assertFalse("case 8", Piskvorka.vRiadku(new char[][]{
			{'.','O','O'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'}
			}));
		scoring.updateScore("lang:common_list_test_scoring_name", 25);
	}
	@Test	
	public void testvStlpci() {
		assertFalse("case 1", Piskvorka.vStlpci(new char[][]{
			{'.','O','O','.','O','O','O','X','O','O','O','X'},
			{'.','O','X','X','X','X','O','X','O','X','x','X'}	}));
		assertTrue("case 2", Piskvorka.vStlpci(new char[][]{
			{'.','O','O'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'},
			{'.','O','X'}
			}));
		assertFalse("case 3", Piskvorka.vStlpci(new char[][]{
			{'.','O','O'},
			{'.','O','X'},
			{'.','O','O'},
			{'.','O','X'},
			{'.','X','X'},
			{'.','O','X'},
			{'.','O','X'}
			}));
		assertTrue("case 4", Piskvorka.vStlpci(new char[][]{
			{'.','O','O','O','O'},
			{'.','O','X','X','O'},
			{'.','O','O','X','O'},
			{'.','O','X','X','O'},
			{'.','X','X','X','O'},
			{'.','O','X','X','O'},
			{'.','O','X','O','O'}
			}));
		assertFalse("case 5", Piskvorka.vStlpci(new char[][]{
			{'.','O','O','O','O'},
			}));
		scoring.updateScore("lang:common_list_test_scoring_name", 25);
	}
	@Test	
	public void testnaDiagonale() {
		assertFalse("case 1", Piskvorka.naDiagonale(new char[][]{
			{'.','O','O','O','.','.','.','.','.'},
			{'.','O','X','X','.','.','.','.','.'},
			{'.','O','O','X','.','.','.','.','.'},
			{'.','O','X','X','.','.','.','.','.'},
			{'.','X','X','O','.','.','.','.','.'},
			{'.','O','X','X','.','.','.','.','.'},
			{'.','O','X','O','.','.','.','.','.'}
			}));
		assertTrue("case 2", Piskvorka.naDiagonale(new char[][]{
			{'.','O','O','O','.','.','.','.','.'},
			{'.','O','X','X','O','.','.','.','.'},
			{'.','O','O','X','.','O','.','.','.'},
			{'.','O','X','X','.','.','O','.','.'},
			{'.','X','X','O','.','.','.','O','.'},
			{'.','O','X','X','.','.','.','.','.'},
			{'.','O','X','O','.','.','.','.','.'}
			}));
		assertTrue("case 3", Piskvorka.naDiagonale(new char[][]{
			{'.','O','O','O','.','.','.','.','.'},
			{'.','O','X','X','O','.','.','.','X'},
			{'.','O','O','X','.','O','.','X','.'},
			{'.','O','X','X','.','.','X','.','.'},
			{'.','X','X','O','.','X','.','O','.'},
			{'.','O','X','X','X','.','.','.','.'},
			{'.','O','X','O','.','.','.','.','.'}
			}));
		assertTrue("case 4", Piskvorka.naDiagonale(new char[][]{
			{'.','O','O','O','.','.','.','.','.'},
			{'.','O','X','X','O','.','.','.','X'},
			{'.','O','O','X','.','O','.','O','.'},
			{'.','O','X','X','.','.','X','.','.'},
			{'.','X','X','O','.','X','.','O','.'},
			{'.','O','X','X','X','.','.','.','.'},
			{'.','O','X','O','.','.','.','.','.'},
			{'.','O','X','O','.','.','.','.','O'},
			{'.','O','X','O','.','.','.','O','.'},
			{'.','O','X','O','.','.','O','.','.'},
			{'.','O','X','O','.','O','.','.','.'},
			{'.','O','X','O','O','.','.','.','.'}
			}));
		assertTrue("case 5", Piskvorka.naDiagonale(new char[][]{
			{'.','O','O','O','.','.','.','.','.'},
			{'.','O','X','X','O','.','.','.','X'},
			{'.','O','O','X','.','O','.','X','.'},
			{'.','O','X','X','.','.','X','.','.'},
			{'.','X','X','O','.','X','.','O','.'},
			{'.','O','X','X','O','.','.','.','.'},
			{'.','O','X','O','.','.','.','.','.'},
			{'.','O','X','O','X','.','.','.','O'},
			{'.','O','X','O','.','X','.','O','.'},
			{'.','O','X','O','.','.','X','.','.'},
			{'.','O','X','O','.','O','.','X','.'},
			{'.','O','X','O','O','.','.','.','X'}
			}));
		scoring.updateScore("lang:common_list_test_scoring_name", 25);
	}

	@Test	
	public void testBonus() {
		assertFalse("null",  Piskvorka.vRiadku(null));
		assertFalse("{null}", Piskvorka.vRiadku(null));
		assertFalse("{null,null, null}",  Piskvorka.vRiadku(new char[][]{null,null, null}));
		assertFalse("{null,null, null, null,null, null, null,null, null}", Piskvorka.vRiadku(new char[][]{null,null, null, null,null, null, null,null, null}));
		assertTrue("{{ 'X', 'X', 'X', 'X', 'X', '-', '.', '.', '.' }}", Piskvorka.vRiadku(new char[][]{{ 'X', 'X', 'X', 'X', 'X', '-', '.', '.', '.' }}));
		assertFalse("{{ '.', '.', '.', '-', '.', '-', '.', '.', '.' }}", Piskvorka.vRiadku(new char[][]{{ '.', '.', '.', '-', '.', '-', '.', '.', '.' }}));
		assertFalse("scanSomeWhereInTheRow", Piskvorka.vRiadku(scanSomeWhereInTheRow));
		assertFalse("scanNoWhereInTheRow", Piskvorka.vRiadku(scanNoWhereInTheRow));		
		assertFalse("scanSomeWhereInTheColumn", Piskvorka.vRiadku(scanSomeWhereInTheColumn));
		assertFalse("scanNoWhereInTheColumn", Piskvorka.vRiadku(scanNoWhereInTheColumn));		
		assertFalse("scanSomeWhereInTheDiag1", Piskvorka.vRiadku(scanSomeWhereInTheDiag1));
		assertFalse("scanNoWhereInTheDiag1", Piskvorka.vRiadku(scanNoWhereInTheDiag1));
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[3][4] = 'X';
				pole[3][5] = 'X';
				pole[3][6] = 'X';
				pole[3][7] = 'X';
				pole[3][8] = 'X';
				assertTrue("case 1", Piskvorka.vRiadku(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[13][4] = 'X';
				pole[13][5] = 'X';
				pole[13][6] = 'X';
				pole[13][7] = 'O';
				pole[13][8] = 'X';
				assertFalse("case 2", Piskvorka.vRiadku(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[3][14] = 'X';
				pole[4][14] = 'X';
				pole[5][14] = 'X';
				pole[6][14] = 'O';
				pole[7][14] = 'X';
				assertFalse("case 3", Piskvorka.vStlpci(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[3][14] = 'X';
				pole[4][14] = 'X';
				pole[5][14] = 'X';
				pole[6][14] = 'X';
				pole[7][14] = 'X';
				assertTrue("case 4", Piskvorka.vStlpci(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[3][15] = 'X';
				pole[4][16] = 'X';
				pole[5][17] = 'X';
				pole[6][18] = 'O';
				pole[7][19] = 'X';
				assertFalse("case 5", Piskvorka.naDiagonale(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[3][14] = 'X';
				pole[4][15] = 'X';
				pole[5][16] = 'X';
				pole[6][17] = 'X';
				pole[7][18] = 'X';
				assertTrue("case 6", Piskvorka.naDiagonale(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[9][15] = 'X';
				pole[8][16] = 'X';
				pole[7][17] = 'X';
				pole[6][18] = 'O';
				pole[5][19] = 'X';
				assertFalse("case 7", Piskvorka.naDiagonale(pole));
			}
		}
		{
			char[][] pole;
			for(int i = 0; i< 200; i++) {
				pole = new char[19+i][29+i];
				for (int j = 0; j<pole.length; j++)
					for (int k = 0; k<pole[j].length; k++)
						pole[j][k] = ((13*j+37*k) % 2 == 0)?'.':'-';
				pole[11][14] = 'X';
				pole[10][15] = 'X';
				pole[9][16] = 'X';
				pole[8][17] = 'X';
				pole[7][18] = 'X';
				assertTrue("case 8", Piskvorka.naDiagonale(pole));
			}
		}
		//
		scoring.updateScore("lang:common_list_test_scoring_name", 25);
	}
	
	char[][] scanSomeWhereInTheRow = 
		{{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '.', '-', '.', '.' }};	

	char[][] scanNoWhereInTheRow = 
		{ { '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' }};
	
	char[][] scanSomeWhereInTheColumn = 
		{
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },			
		};

	char[][] scanNoWhereInTheColumn = 
		{
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },			
		};

	char[][] scanSomeWhereInTheDiag1 = 
		{
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '.', '-', '-', '.', '.' },			
		};

	char[][] scanNoWhereInTheDiag1 = 
		{
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '.', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			null,
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },
			{ '.', '.', '.', '.', '.', '-', '-', '-', '.', '.', '-', '-', '.', '.' },			
		};
		
}

