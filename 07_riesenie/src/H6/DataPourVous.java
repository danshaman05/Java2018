import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataPourVous {
	
	
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("DataPourVous.txt"));
			
			s.useDelimiter("[\\s,]+");
			while(s.hasNext())
			{
				if(s.hasNextInt())
				{
					System.out.println(s.nextInt());
				}
				else
				{
					s.nextLine();
				}
			}
			s.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static int[][] graph = {
		{1,3,4},	// susedia vrchola 0
		{0, 6},		// susedia vrchola 1
		{5},		// susedia vrchola 2
		{0, 6},		// susedia vrchola 3
		{0, 6},		// susedia vrchola 4
		{2},		// susedia vrchola 5
		{1, 3, 4}};	// susedia vrchola 6


}
