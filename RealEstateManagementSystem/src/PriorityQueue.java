/*
 *  @author  Fernando Loro Velardo
 *  
 */

import java.util.Comparator;


public class PriorityQueue {       
	
	public class Pair implements Comparable {
		public Object element;
		public Object priority;

		public Pair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}
		
		// Time complexity: O(1)
		public int compareTo(Object a) {
			Pair p2 = (Pair) a;
			return ((Comparable)priority).compareTo(p2.priority);
		}
	}

	private SortedLinkedList data;

	public PriorityQueue() {
		data = new SortedLinkedList();
	}

	// Time complexity: O(n)
	public void push(Object o, int priority) {
		// make a pair of o and priority
		// add this pair to the sorted linked list.
		Pair newPair = new Pair(o,priority);
		data.addSorted(newPair);
		
	}

	// Time complexity: O(1)
	public Object pop() {
		Pair pair = (Pair)data.getFirst();
		data.removeFirst();
		try{
			return pair.element;
		}
		catch(Exception e) {
			return null;
		}
	}

	// Time complexity: O(1)
	public Object top() {
		return data.getFirst();
	}
	
	// Time complexity: O(n)
	public String toString() {
		return data.toString();
	}

	// Time complexity: O(n)
	public int size() {
		return data.size();
	}
	
}
