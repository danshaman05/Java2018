public class ListPF<E> implements FrontInterface<E>{
	Elem<E> first;

	public ListPF() {
	}

	@Override
	public void enqueue(E elem, int prio) {
		Elem<E> element = new Elem<E>(prio, elem, null);
		Elem<E> aktualny = first;
		if(aktualny == null){
			first = element;
			return;
		}

		if(aktualny.getPrior() > element.getPrior()) {
			first = element;
			element.setNext(aktualny);
			return;
		}

		while(aktualny.getNext() != null){
			if(aktualny.getNext().getPrior() > prio){
				Elem<E> temp = aktualny.getNext();
				aktualny.setNext(element);
				element.setNext(temp);
				return;
			}
			aktualny = aktualny.getNext();
		}
		aktualny.setNext(element);
	}

	@Override
	public E dequeue() {
		if(first == null) return null;
		Elem<E> vrat = first;
		first = first.getNext();
		return vrat.getElement();
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	 public static void main(String[] args) {
		 ListPF<String> f = new ListPF<String>();
	        f.enqueue(new String("janka"), 5);
	        f.enqueue(new String("danka"), 2);
	        f.enqueue(new String("hanka"), 1);
	        f.enqueue(new String("anka"), 4);
	        f.enqueue(new String("zuzanka"), 3);
	        f.enqueue(new String("elenka"), 1);
	        f.enqueue(new String("zofka"), 6);
	        f.enqueue(new String("evka"), 4);
	        System.out.println(f);
	        while (!f.isEmpty())
	            System.out.println(f.dequeue());    
	    }	
}
