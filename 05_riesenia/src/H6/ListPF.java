public class ListPF<E> implements FrontInterface<E>{
	Elem<E> first;
	public ListPF() {
		this.first = null;
	}
	@Override
	public void enqueue(E elem, int prio) {
		if (first == null) {
			first = new Elem(prio, elem, null);
		} else {
			if (prio < first.getPrior()) {
				first = new Elem(prio, elem, first);
			} else {
				Elem<E> tmp = first;
				while (tmp.getNext() != null) {
					if (tmp.getNext().getPrior() > prio) {
						tmp.setNext(new Elem(prio, elem, tmp.getNext()));
						return;
					} else {
						tmp = tmp.getNext();
					}
					
				}
				tmp.setNext(new Elem(prio, elem, tmp.getNext()));
			}
		}
	}

	@Override
	public E dequeue() {
		if (first != null) {
			E pom = first.getElement();
			first = first.getNext();
			return pom;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}
	
	

	
	public void print() {
		 Elem<E> tmp = first;
		 while (tmp != null) {
			 System.out.print(tmp.getElement() + ", ");
			 tmp = tmp.getNext();
		 }
		 System.out.println();
	}
	
	public static void main(String[] args) {
		 ListPF<String> f = new ListPF<String>();
	        f.enqueue(new String("janka"), 5);
	        f.print();
	        f.enqueue(new String("danka"), 2);
	        f.print();
	        f.enqueue(new String("hanka"), 1);
	        f.print();
	        f.enqueue(new String("anka"), 4);
	        f.print();
	        f.enqueue(new String("zuzanka"), 3);
	        f.print();
	        f.enqueue(new String("elenka"), 1);
	        f.print();
	        f.enqueue(new String("zofka"), 6);
	        f.print();
	        f.enqueue(new String("evka"), 4);
	        f.print();
	        System.out.println(f);
	        while (!f.isEmpty())
	            System.out.println(f.dequeue());    
	    }	
}
