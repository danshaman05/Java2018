public class ArrayPF<E> implements FrontInterface<E> {

	public ArrayPF(int size) {
    //...
	}
	@Override
	public void enqueue(E elem, int prio) {
    // ...
	}

	@Override
	public E dequeue() {
    // ...
		return null;
	}

	@Override
	public boolean isEmpty() {
    //...
		return false;
	}

	 public static void main(String[] args) {
		 ArrayPF<String> f = new ArrayPF<String>(100);
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
