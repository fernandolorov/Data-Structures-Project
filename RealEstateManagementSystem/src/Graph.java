/*
 *  @author  Fernando Loro Velardo
 *  
 */

public class Graph {
	
    public class Node implements Comparable {
        private Comparable info;
        private Tree edges;
        boolean visited;
        
        public Node(Comparable label) {
            info = label;
            edges = new Tree();
            visited = false;
            
        }
        
        // Time complexity: O(log(n))
        public void addEdge(Edge e) {
            edges.insert(e);
        }
        
        // Time complexity: O(n)
        public boolean isConected(Node node2) {
        	boolean conected[] = {false};
        	edges.traverse(new TreeAction() {
				@Override
				public void run(Tree.TreeNode n) {	
					if(((Edge) n.getValue()).toNode==node2) {
    					conected[0] = true;
    				}
				}
    		});
        	
        	return conected[0];
        }
        
        // Time complexity: O(1)
        public void setVisited(boolean visited) {
        	this.visited = visited;
        }
        
        // Time complexity: O(1)
        public int compareTo(Object o) {
            // two nodes are equal if they have the same label
            Node n = (Node)o;
            return n.info.compareTo(info);
        }
        
        // Time complexity: O(1)
        public Comparable getLabel() {
            return info;
        }
        
        
    }
    
    private class Edge implements Comparable {
        private Node toNode;
        private double weight;
        
        public Edge(Node to, double weight) {
            this.toNode = to;
            this.weight = weight;
        }
        
        // Time complexity: O(1)
        public int compareTo(Object o) {
            // two edges are equal if they point
            // to the same node.
            // this assumes that the edges are
            // starting from the same node !!!
            Edge n = (Edge)o;
            return n.toNode.compareTo(toNode);
        }
    }
    
    private Tree nodes;
    
    public Graph() {
        nodes = new Tree();
    }
    
    // Time complexity: O(log(n))
    public void addNode(Comparable label) {
        nodes.insert(new Node(label));
    }
    
    // Time complexity: O(log(n))
    public Node findNode(Comparable nodeLabel) {
    	if(nodes.find(new Node(nodeLabel)) == null) {
    		System.out.println("The Node is not in the Graph");
    	}
    	else {
    		Node node = (Node) nodes.find(new Node(nodeLabel)).getValue();
    		return node;
    	}
    	
    	return null;
    }
    
    // Time complexity: O(log(n))
    public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2, double weight) {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge(n2, weight));
    }
    
    // Time complexity: O(n^2)
    public LinkedList findPath(Comparable nodeLabel1, Comparable nodeLabel2) {
    	Node startState = findNode(nodeLabel1);
    	Node endState = findNode(nodeLabel2);  	
    	
    	Stack toDoList = new Stack();
    	toDoList.push(startState);
    	
    	LinkedList path = new LinkedList();
    	path.addLast(startState);
    	
    	while (!toDoList.empty()) {
    		Node current = (Node) toDoList.pop();
    		current.setVisited(true);
    		boolean conected = false;
    		while(conected == false) {
    			Node lastNode = (Node) path.getLast();
    			if(lastNode == current) {
    				conected=true;
    				path.removeLast();
    			}
    			else if(lastNode.isConected(current)) {
    				conected=true;
    				break;
    			}
    			else{
    				path.removeLast();
    			}
    		}    	
    		path.addLast(current);
    		
    		if (current == endState) {
    			this.setUnvisited();
    			return path;
    		}
    			
    		else{
    			
    			current.edges.traverse(new TreeAction() {
    				@Override
    				public void run(Tree.TreeNode n) {	
    					Edge edge = (Edge) n.getValue();
    					if(!edge.toNode.visited){
        					toDoList.push(edge.toNode);
        				}
    				}
        		});
    		}   			
    		
    	}
    	this.setUnvisited();
    	System.out.println("There is no path");
    	return null;
    }
    
    // Time complexity: O(n)
    public void setUnvisited() {
    	nodes.traverse(new TreeAction() {
			public void run(Tree.TreeNode n) {
				((Node) n.getValue()).setVisited(false);
			}
		});
    }
    
    // Time complexity: O(n^2)
    public double getDistance(Comparable nodeLabel1, Comparable nodeLabel2) {
    	LinkedList path = this.findPath(nodeLabel1, nodeLabel2);
    	double[] distance = {0};
    	if(path == null) {
    		return 999999999;
    	}
    	else {
    		for (int i = 0; i < path.size() - 1; i++){
    			Node node = (Node) path.get(i);
    			Node nextNode = (Node) path.get(i + 1);
    			node.edges.traverse(new TreeAction(){
    				@Override
    				public void run(Tree.TreeNode n) {	
    					Edge edge = (Edge) n.getValue();
    					if (edge.toNode ==  nextNode){
    						distance[0] += edge.weight;
    					}
    				}
    			});
    		}

    		return distance[0];
    	}
    }
    
 
    /*
	 * Given a node label and a radius, the method returns all the Nodes that are inside the 
	 * radius range.
	 *
	 * Time complexity: O(n^2)
	 *
	 * @param nodeLabel1 is a center Node for the search
	 * 
	 * @param radius is radius (sum of weights) for which the search is applied
	 */
    public Vector getNodesOnDistance(Comparable nodeLabel1, double radius) {
    	Node startState = findNode(nodeLabel1);
    	
    	Vector nodes = new Vector(10);
    	nodes.addFirst(startState.info);
    	
    	startState.setVisited(true);
		startState.edges.traverse(new TreeAction() {
			@Override
			public void run(Tree.TreeNode n) {	
				Edge edge = (Edge) n.getValue();
				if(!edge.toNode.visited & (radius - edge.weight) >= 0) {
					edge.toNode.setVisited(true);
					//nodes.addFirst(edge.toNode.info);
					Vector newNodes = getNodesOnDistance(edge.toNode.info, radius - edge.weight);
					for(int i = 0; i < newNodes.size(); i++) {
						nodes.addFirst(newNodes.get(i));
					}
				}
			}
		});
		//Setting back all the Nodes to unvisited
		this.setUnvisited();
		return nodes;
    }
    
    // Time complexity: O(n)
	public void print() {
		nodes.traverse(new TreeAction() {
			public void run(Tree.TreeNode n) {
				Node node = (Node) n.getValue();
				System.out.print(node.getLabel() + ":  ");
				node.edges.traverse(new TreeAction() {
					public void run(Tree.TreeNode m) {
						Edge edge = (Edge) m.getValue();
						System.out.print(edge.toNode.getLabel() + " " + edge.weight + "  ");
					}
				});
				System.out.print("\n");
				
			}
		});

	}

}