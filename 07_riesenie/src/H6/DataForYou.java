import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataForYou {
	
	public static void main(String[] args) {
		ArrayList<String> vsetkyMena = new ArrayList<String>();
		vsetkyMena = readTxt("DataForYou1.txt");
		System.out.println(vsetkyMena);
		
		
		Set<String> mena=new TreeSet<String>(vsetkyMena);
		System.out.println(mena.size());
		System.out.println(mena);
		
		Set<String> podlaDlzky = new TreeSet<>(
				(s1, s2) -> {
					int rozdiel = Integer.compare(s1.length(), s2.length());
					if(rozdiel == 0) {
						return s1.compareTo(s2);
					}
					return rozdiel;
				}
				);
		podlaDlzky.addAll(mena);
		System.out.println(podlaDlzky);
		
		Map<String, Integer> najcastejsie = new TreeMap<>();
		for(int i = 0; i < vsetkyMena.size(); i++) {
			String meno = vsetkyMena.get(i);
			if(najcastejsie.containsKey(meno)) {
				najcastejsie.put(meno, najcastejsie.get(meno) + 1);
			}
			else {
				najcastejsie.put(meno, 1);
			}
			
			//najcastejsie.put(meno, najcastejsie.getOrDefault(meno, 0) + 1);
		}
		System.out.println(najcastejsie);
		int max = 0;
		String meno = "";
		for (String s: najcastejsie.keySet()) {
			int current = najcastejsie.get(s);
			if (current > max) {
				max = current;
				meno = s;
			}
		}
		
//		for(Map.Entry<String, Integer> e : najcastejsie.entrySet()) {
//			e.getKey();
//			e.getValue();
//			//...
//		}
		
		
		System.out.println(meno + ", " + max);
	}
	
	private static ArrayList<String> readTxt(String fileName) {
		ArrayList<String> ret = new ArrayList<String>();
		try (
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)
			){			
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				ret.add(sCurrentLine);
			}	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList <String> mena=new ArrayList<String>();
		for (String riadok: ret) {
			
			mena.addAll(Arrays.asList(riadok.trim().split("\\s+")));
		}
		return mena;
	}
}
