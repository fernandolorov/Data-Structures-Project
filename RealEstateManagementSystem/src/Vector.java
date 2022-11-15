/*
 *  @author  Fernando Loro Velardo
 *  
 */

public class Vector {
	
	private Object data[];
	private int count;
	
	public Vector(int capacity) {
		data = new Object[capacity];
		count = 0;
	}

	// Time complexity: O(1)
	public int size() {
		return count;
	}
 
	// Time complexity: O(1)
	public boolean isEmpty() {
		return size() == 0;
	}

	// Time complexity: O(1)
	public Object get(int index) {
		return data[index];
	}

	// Time complexity: O(1)
	public void set(int index, Object obj) {
		data[index] = obj;
	}

	// Time complexity: O(n)
	public boolean contains(Object obj) {
		for(int i=0;i<count;i++) {
			if(data[i] == obj) return true;
		}
		return false;
	}
	
	// Time complexity: O(1)
	public void addFirst(Object item) {
		if(count == data.length){
			this.extendCapacity();
		}
		if(count==0) {
			data[0]=item;
			count++;
		}
		else { 
			for(int i=count-1; i>=0; i--) {
				data[i+1]=data[i];	
			}
			data[0]=item;
			count++;
		}			
	}
	
	// Time complexity: O(1)
	public void addLast(Object o) {
		if(count==data.length){
			this.extendCapacity();
		}

		data[count] = o;
		count++;
	}
	
	/*
	public boolean binarySearch(Object key) {
		int start = 0;
		int end = count - 1;
		while(start <= end) {
			int middle = (start + end + 1) / 2;
			if(key < data[middle]) end = middle -1;
			else if(key > data[middle]) start = middle + 1;
			else return true;
		}
		return false;
	}
	*/

	// Time complexity: O(1)
	public Object getFirst() {
		
		return data[0];
	}

	// Time complexity: O(1)
	public Object getLast() {
		if(count>0) {
			return data[count-1];
		}
		else return null;
	}

	// Time complexity: O(1)
	public void removeLast() {
		if(count>0) {
			data[count-1]=null;
			count--;
		}
			
	} 

	// Time complexity: O(1)
	public void removeFirst() {
		if(count>0) {
			for(int i=0; i<count-1; i++) {
				data[i]=data[i+1];
			}
			data[count-1]=null;
			count--;
		}
			
	}
	
	// Time complexity: O(n)
	public void reverse() {
		if(count>0) {		
			for(int i=0; i<count/2; i++) {
				Object temp=data[i];
				data[i]=data[count-1-i];
				data[count-1-i]=temp;		
			}
		}
		else return;
	}
	
	// Time complexity: O(n)
	private void extendCapacity() {
		Object data2[] = new Object[data.length*2];
		for(int i=0; i< data.length; i++){
			data2[i] = data [i];
		}
		data = data2;
	}
	
	// Time complexity: O(n)
	public void print() {
		System.out.println("This is my Vector");
		for(int i=0; i<count; i++) {
			System.out.println(data[i]);
		}
	}

	// Time complexity: O(n)
	public String toString() {
		String vector = "";
		for(int i=0; i<count; i++) {
			vector += data[i].toString() + ", ";
		}
		return vector;
	}
	
	/*
	public Vector doubleVector() {
		Vector v2 = new Vector(data.length*2);
		for(int i=0; i<data.length; i++) {
			v2.data[2*i]=data[i];
			v2.data[2*i+1]=data[i];
		}
		return v2;
	}
	*/
}