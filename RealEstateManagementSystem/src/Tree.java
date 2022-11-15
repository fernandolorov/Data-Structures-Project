/*
 *  @author  Fernando Loro Velardo
 *  
 */

import java.util.Comparator;

public class Tree {
	/*
	private class NaturalComparator implements Comparator
	{
		public int compare(Object a, Object b)
		{
			return ((Comparable)a).compareTo(b);
		}
	}
	*/
	// the class for implementing a node in the tree.
	// contains a value, a pointer to the left child and a pointer to the right child
	
	public class TreeNode implements Comparable {
		
		private Comparable value;
		private TreeNode leftNode;
		private TreeNode rightNode;
		
		public TreeNode(Comparable v) {
			value = v;
			leftNode = null;
			rightNode = null;
		}
		  
		public TreeNode(Comparable v, TreeNode left, TreeNode right) {
			value = v;
			leftNode = left;
			rightNode = right;
		}
		
		// Time complexity: O(1)
		public TreeNode getLeftTree() {
			return leftNode;
		}
		 
		// Time complexity: O(1)
		public TreeNode getRightTree() {
			return rightNode;
		}
		 
		// Time complexity: O(1)
		public Comparable getValue() {
			return value;
		}

		// Time complexity: O(1)
		@Override
		public int compareTo(Object o) {
			return value.compareTo(((TreeNode)o).value);
		}
	}
	
		
	// start of the actual tree class
	
	// the root of our tree
	private TreeNode root;
	
	public Tree() {
		root = null;
	}
	
	// Time complexity: O(n)
	public void traverse(TreeAction action) {
		Queue t = new Queue();
		//Stack t = new Stack();
		t.push(root);
		while(!t.empty()) {
			TreeNode n = (TreeNode)t.pop();
			action.run(n);
			if(n.getLeftTree() != null) t.push(n.getLeftTree());
			if(n.getRightTree() != null) t.push(n.getRightTree());
		}
	}
	
	// Time complexity: O(n)
	public void traverseNode(TreeNode n,TreeAction action) {
		if(n != null) {
			if(n.getLeftTree() != null) traverseNode(n.getLeftTree(),action); 
			action.run(n);
			if(n.getRightTree() != null) traverseNode(n.getRightTree(),action);
		}
	}
	
	// Time complexity: O(n)
	public void traverseInOrder(TreeAction action) {
		traverseNode(root,action);
	} 
	
	// Time complexity: O(log(n))
	private TreeNode findNode(Comparable element, TreeNode current) {
		if(current == null) return null;
		else if (element.compareTo(current.value) == 0){
			return current;
		}
		else if (element.compareTo(current.value) < 0) {
			return findNode(element, current.getLeftTree());
		}
		else return findNode(element, current.getRightTree());
	}

	// Time complexity: O(log(n))
	public TreeNode find(Comparable element) {
		return findNode(element , root );
	}
	
	// Time complexity: O(log(n))
	public void insert(Comparable element) {
		insertAtNode(element,root,null);
	}	
	
	// We traverse the tree.
	// Current holds the pointer to the TreeNode we are currently checking
	// Parent holds the pointer to the parent of the current TreeNode
	// Time complexity: O(log(n))
	private void insertAtNode(Comparable element,TreeNode current,TreeNode parent) {
		// if the node we check is empty
		if(current == null) {
			TreeNode newNode = new TreeNode(element);
			// the current node is empty, but we have a parent
			if(parent != null)
			{
				// Add it to the left
				if (element.compareTo(parent.value) < 0) {
					parent.leftNode = newNode;
				}
				// Add it to the right
				else {
					parent.rightNode = newNode;
				}
			}
			// We have an empty tree
			else root = newNode;
		}
		else if(element.compareTo(current.value) == 0) {
			// If the element is already in the tree we do nothing
		}
		// If the element is smaller than current, go left
		else if(element.compareTo(current.value) < 0) {
			insertAtNode(element,current.getLeftTree(),current);
		}
		// If the element is bigger than current, go right
		else insertAtNode(element,current.getRightTree(),current);
	}
	
	// Time complexity: O(n log(n))
	public int getDepthNode(TreeNode current) {
		int depth = 0;
		if(current == null) {
			// We reach the bottom of the branch
			return 0;
		}
		else {
			//Increase the depth by 1
			depth++;
			if(current.getLeftTree() != null) {
				depth += getDepthNode(current.getLeftTree());		
			}
			
			if(current.getRightTree() != null) {
				depth += getDepthNode(current.getLeftTree());		
			}
		}	
		return depth;
	}
	
	// Time complexity: O(n log(n))
	public int getDepth() {
		return getDepthNode(root);
	}
	
	// Time complexity: O(log(n))
	public Comparable findBiggestNode(TreeNode current, Comparable biggest) {	
		//Go through the entire tree repeating the process
		if(current == null) {
			//We reach the botton of the branch
			return biggest;
		}
		else {
			//If the new node value is bigger we overwritte our actual bigger
			if(current.getValue().compareTo(biggest) > 0) {
				biggest = current.getValue();
			}
			
			/* The biggest element is never on the left side
			if(current.getLeftTree() != null){
				findBiggestNode(current.getLeftTree(), biggest);		
			}
			*/
			if(current.getRightTree() != null) {
				biggest = findBiggestNode(current.getRightTree(), biggest);		
			}
		}	
		return biggest;
	}
	
	// Time complexity: O(log(n))
	public Comparable findBiggest() {
		return findBiggestNode(root, 0);
	}
	
	// Time complexity: O(n)
	public void print() {
		traverse(new TreeAction() {
			public void run(TreeNode n)	{
				System.out.println(n.getValue());
			}
		});
	}
}

