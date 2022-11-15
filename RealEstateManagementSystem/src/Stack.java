/*
 *  @author  Fernando Loro Velardo
 *  
 */

public class Stack {
	
	private LinkedList data;

	public Stack() {
		 data = new LinkedList();
	}

	// Time complexity: O(1)
	public void push(Object o) {
		data.addFirst(o);
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

	// Time complexity: O(1)
	public boolean empty() {
		return data.isEmpty();
	}
	
	// Time complexity: O(n)
	public String toString() {
		return data.toString();
	}
}
