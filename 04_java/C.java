public class C {
	A a = new A();	// vlo�en� referencia (!) na objekt a typu A
	B b = new B();	// vlo�en� referencia (!) na objekt b typu B

	public static void main(String[] args) {
		C c = new C();	// vytvoren� objekt obsahuj�ci a:A aj b:B
		c.a.doA();		// intern� met�dy A, B by mali by� skryt� v C
		c.b.doB();
	}
}

