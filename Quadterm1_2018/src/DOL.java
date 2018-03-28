public class DOL {
	String[][] pravidla;

	public DOL(String[][] pravidla) {
		this.pravidla = pravidla;
	}

	public boolean isDOL() {
		String lefts = "";
		for (int i = 0; i < pravidla.length; i++)
			if (pravidla[i][0] == null || pravidla[i][0].length() != 1)
				return false;								// pravidlo 1
			else
				lefts += pravidla[i][0].charAt(0);
		for (int i = 0; i < pravidla.length; i++) 
			if (lefts.indexOf(pravidla[i][0].charAt(0)) < 0)  // pravidlo 2
				return false;
		for (int i = 0; i < pravidla.length; i++)
			for(int j = 0; j < pravidla[i][1].length(); j++)
				if (lefts.indexOf(pravidla[i][1].charAt(j)) < 0)// pravidlo 3
					return false;
		return true;
	}

	public String oneStep(String initString) {
		String result = "";
		next:
		for (int i = 0; i < initString.length(); i++) {
			char ch = initString.charAt(i);
			for (int j = 0; j < pravidla.length; j++)
				if (pravidla[j][0].equals(""+ch)) {
					result += pravidla[j][1];
					continue next;
				}
		}
		return result;
	}

	public String manySteps(int n, String initString) {
		String result = initString;
		for (int i = 0; i < n; i++) {
			result = this.oneStep(result);
		}
		return result;
	}
}