/*
 *  @author  Fernando Loro Velardo
 *  
 */

public class Queue {
	
	private LinkedList data;
	
	public Queue() {
		data = new LinkedList();
	}

	// Time complexity: O(n)
	public void push(Object o) {
		data.addLast(o);
	}

	// Time complexity: O(1)
	public Object pop() {
		Object o = data.getFirst();
		data.removeFirst();
		return o;
	}

	// Time complexity: O(1)
	public Object top() {
		return data.getFirst();
	}

	// Time complexity: O(n)
	public int size() {
		return data.size();
	}

	// Time complexity: O(n)
	public boolean empty() {
		return data.isEmpty();
	}
}
