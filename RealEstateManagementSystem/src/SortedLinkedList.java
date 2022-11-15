/*
 *  @author  Fernando Loro Velardo
 *  
 */

public class SortedLinkedList {

	private class ListElement {
		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Comparable el) {
			this(el, null);
		}

		// Time complexity: O(1)
		public Comparable first() {
			return el1;
		}

		// Time complexity: O(1)
		public ListElement rest() {
			return el2;
		}

		// Time complexity: O(1)
		public void setFirst(Comparable value) {
			el1 = value;
		}

		// Time complexity: O(1)
		public void setRest(ListElement value) {
			el2 = value;
		}
	}

	private ListElement head;

	public SortedLinkedList() {
		head = null;
	}

	// Time complexity: O(n)
	public void addSorted(Comparable o) {
		// an empty list , add element in front
		if( head == null ) head = new ListElement (o , null );
		else if( head.first().compareTo(o) > 0) {
			// we have to add the element in front
			head = new ListElement (o , head );
		}
		else {
			// we have to find the first element which is bigger
			ListElement d = head ;
			while ((d.rest() != null)&&(d.rest().first().compareTo(o) <= 0)) {
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(o, next));
		}
	}
	
	// Time complexity: O(1)
	public Comparable getFirst() {
		try {
			return head.first();
		}
		catch(Exception e) {
			System.out.println("List is empty");
			return null;
		}
	}
	
	// Time complexity: O(1)
	public void removeFirst() {
		try{
			head = head.rest();
		}
		catch(Exception e) {
			System.out.println("List is empty");
		}
	}

	// Time complexity: O(n)
	public Comparable getLast() {
		try{
			ListElement d = head;
			while(d.rest() != null) {
				d = d.rest();
			}
			return d.first();
		}
		catch(Exception e) {
			System.out.println("List is empty");
			return null;
		}
	}

	// Time complexity: O(n)
	public void removeLast() {
		try{
			ListElement d = head;
			ListElement previous = head;
			if(head.rest() == null) {
				head = null;
			}
			else {
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
	public Comparable get(int n) {
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
	public int size() {
		try{
			ListElement d = head;
			if(head==null || head.first()== null) {
				return 0;
			}
			else {
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
		try{	
			ListElement d = head;
			while (d != null) {
				s += d.first().toString();
				s += " ";
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

