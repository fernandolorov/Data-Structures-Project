/*
 *  @author  Fernando Loro Velardo
 *  
 */

public class LinkedList {

	private class ListElement {
		private Object el1;
		private ListElement el2;

		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Object el) {
			this(el, null);
		}
		
		// Time complexity: O(1)
		public Object first() {
			return el1;
		}

		// Time complexity: O(1)
		public ListElement rest() {
			return el2;
		}

		// Time complexity: O(1)
		public void setFirst(Object value) { 
			el1 = value;
		}

		// Time complexity: O(1)
		public void setRest(ListElement value) {
			el2 = value;
		}
	}

	private ListElement head;

	public LinkedList() {
		head = null;
	}

	// Time complexity: O(1)
	public Object getFirst() {
		try{
			return head.first();
		}
		catch(Exception e){
			System.out.println("List is empty");
			return null;
		}
	}
	
	// Time complexity: O(1)
	public void addFirst(Object o) {
		head = new ListElement(o, head);
	}

	// Time complexity: O(1)
	public void removeFirst() {
		try{
			head = head.rest();
		}
		catch(Exception e){
			System.out.println("List is empty");
		}
	}

	// Time complexity: O(n)
	public Object getLast() {
		try{
			ListElement d = head;
			while(d.rest() != null){
				d = d.rest();
			}
			return d.first();
		}
		catch(Exception e){
			System.out.println("List is empty");
			return null;
		}
	}

	// Time complexity: O(n)
	public void addLast(Object o) {
		ListElement newElement = new ListElement(o,null);
		ListElement d = head;
		if(head==null) {
			head = new ListElement(o, head);
		}
		else{
			while(d.rest() != null) {
				d = d.rest();
			}
			d.setRest(newElement);
		}
	}

	// Time complexity: O(n)
	public void removeLast() {
		try{
			ListElement d = head;
			ListElement previous = head;
			if(head.rest() == null) {
				head = null;
			}else{
				while(d.rest() != null) {
					previous = d;
					d = d.rest();
				}
				previous.setRest(null);
			}
		}
		catch(Exception e) {
			System.out.println("List is empty");
		}
	}
	
	// Time complexity: O(n)
	public Object get(int n) {
		try{
			ListElement d = head;
			while (n > 0) {
				d = d.rest();
				n--;
			}
			return d.first();
		}
		catch(Exception e) {
			System.out.println("List is empty or the index is out of bound");
			return null;
		}
	}

	// Time complexity: O(n)
	public void set(int n, Object o) {

		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(o);

	}

	// Time complexity: O(n)
	public Object find(Object obj) {
		ListElement d = head;
		int n = this.size();
		while (n > 0) {
			if(((Comparable) d.el1).compareTo(obj)==0) {
				return d.el1;
			}
			d = d.rest();
			n--;
		}
		return null;
	}
	
	// Time complexity: O(n)
	public int size() {
		try{
			ListElement d = head;
			if(head==null || head.first()== null) {
				return 0;
			}
			else{
				int size = 1;
				while(d.rest() != null) {
					size++;
					d = d.rest();
				}
				return size;
			}	
		}
		catch(Exception e) {
			System.out.println("List is empty");
			return 0;
		}	
	}	

	// Time complexity: O(1)
	public boolean isEmpty() {
		if(head == null ) {
			return true;
		}
		else if (this.getFirst()==null) {
			return true;
		}
		else {
			return false;
		}
	}

	// Time complexity: O(n)
	public String toString() {
		String s = "(";
		try {	
			ListElement d = head;
			while (d != null) {
				s += d.first().toString();
				s += ", ";
				d = d.rest();
			}
		}
		catch(Exception e) {
			System.out.println("List is empty");
		}
		s += ")";
		return s;
	}

}

