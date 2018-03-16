public class Kompozicia {
	private Nadtried n = new Nadtried(); // vlo�en� nadtrieda
	private int addCount = 0;
	// @Override
	public void add(String s) { //pridaj 1
		addCount++;
		n.add(s);
	}
	// @Override
	public void addAll(String[] c) {// pridaj v�etky
		addCount += c.length;
		n.addAll(c);
	}
	public int getAddCount() {
		return addCount;
	}
	public static void main(String[] args) {
	    Kompozicia s = new Kompozicia();
	    s.addAll(new String[]{"Peter", "Pavol"});
	    System.out.println(s.getAddCount());
	}
}

