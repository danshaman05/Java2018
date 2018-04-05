import java.util.ArrayList;
import java.util.List;

public class ArrayListPF<E> implements FrontInterface<E> {

	class Tuple<E>{

		E value;
		int priorita;

		public Tuple(E value, int priorita){
			this.value = value;
			this.priorita = priorita;

		}
	}
	List<Tuple<E>> pole;

	public ArrayListPF(int size) {
		pole = new ArrayList<Tuple<E>>(size);
    //...
	}
	@Override
	public void enqueue(E elem, int prio) {
		Tuple<E> tuple = new Tuple<E>(elem, prio);
		int i = 0;
		for(; i < pole.size(); i++){
			if(prio	< pole.get(i).priorita){
				break;
			}
		}
		pole.add(i, tuple);
	}

	@Override
	public E dequeue() {
		if(pole.size() == 0) return null;
		return pole.remove(0).value;
	}

	@Override
	public boolean isEmpty() {
    //...
		return pole.isEmpty();
	}

	 public static void main(String[] args) {
		 ArrayListPF<String> f = new ArrayListPF<String>(100);
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
