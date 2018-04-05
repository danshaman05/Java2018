/** PrioritnyFront - cvicenie 5
 * 
 */

import java.util.PriorityQueue;

/** Java contains a class PrioirtyQueue, we can utilize it for our purpose, 
 *  and simply implement a wrapper.
 */
public class PrioritnyFront<E> 
{
	/** a wrapper class for elements with integer priority */
	private class Elem<F> /* implements Comparable<Elem<F>> */ {
		public F elem;		/** stores element */
		public int prio;	/** stores priority */
		public Elem(F element, int priority) {
			elem = element;
			prio = priority;
		}
		/** java.lang.PriorityQueue requires comparable elements */
	}
	public PrioritnyFront() { 
	}
	/** add new element to priority queue */
	public void enqueue(E elem, int prio) {
	}
	/** remove (and return) the element with the highest priority from queue */
	public E dequeue() {
    return null;
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
}
