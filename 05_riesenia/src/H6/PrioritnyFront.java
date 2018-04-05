/** PrioritnyFront - cvicenie 5
 * 
 */

import java.util.PriorityQueue;

/** Java contains a class PrioirtyQueue, we can utilize it for our purpose, 
 *  and simply implement a wrapper.
 */
public class PrioritnyFront<E> implements FrontInterface<E>
{
	PriorityQueue<Elem<E>> queue;
	
	public PrioritnyFront() {
		queue = new PriorityQueue<>();
	}
	/** add new element to priority queue */
	public void enqueue(E elem, int prio) {
		Elem<E> newElem = new Elem<>(prio, elem, null); 
		queue.add(newElem);
	}
	/** remove (and return) the element with the highest priority from queue */
	public E dequeue() {
		if (queue.peek() == null) {
			return null;
		}
		return queue.poll().getElement();
	}
	/** return the element with the highest priority from queue, but do not remove it */ 
	public E front() {
    return null;
	}
	
	/** return the number of elements that remain in the queue */
	public int size()
	{
    return 0;
	}
	
	/** Test program - inserts random elements to priority queue and retrieves them
	 * @param args - program takes no arguments
	 */
	public static void main(String[] args) 
	{
		// create our implementation of the priority queue
		PrioritnyFront<Integer> f = new PrioritnyFront<Integer>();
		
		// generate 10 random numbers 0-49 and insert them on the queue
		// with the same priority as their value
		for (int i = 0; i < 10; i++)
		{
			int x = (int)(50 * Math.random());
			f.enqueue(x, x);
		}
		
		// now remove the numbers from the queue in the priority order and print them
		for (int i = 0; i < 10; i++)
			System.out.print(f.dequeue() + ",");
		if (f.size() == 0) System.out.println("empty");
	}
	@Override
	public boolean isEmpty() {	
		return queue.isEmpty();
	}
}
