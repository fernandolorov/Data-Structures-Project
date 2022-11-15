/*
 * This class is used to test the Real Management System.
 *  
 *  @author  Fernando Loro Velardo
 */

public class Main {

	public static void main(String[] args) {
		
		//Checking the behavior of the Data Structure:
		
		/*
		Vector newVector = new Vector(1);
		newVector.addFirst(1);
		newVector.addFirst(2);
		newVector.addLast(4);
		newVector.addLast(4);
		newVector.addLast(2);
		newVector.print();
		LinkedList myList = new LinkedList();
		System.out.println("Adding and setting new elements");
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		myList.addFirst(1);
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		myList.addFirst(2);
		myList.addFirst(3);
		myList.addFirst(4);
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		System.out.println("Last element: " + myList.getLast());
		myList.set(2,10);
		System.out.println(myList.toString());
		myList.addLast(12);
		System.out.println(myList.toString());
		System.out.println("Last element: " + myList.getLast());
		
		System.out.println("\nRemoving all the elements");
		myList.removeLast();
		myList.removeLast();
		myList.removeLast();
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		myList.removeLast();
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		myList.removeLast();
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		myList.removeLast();
		
		System.out.println("\nAdding in diferent orders");
		myList.addLast(7);
		myList.addFirst(8);
		myList.addLast(9);
		myList.addFirst(10);
		System.out.println(myList.toString());
		System.out.println("Size: " + myList.size());
		System.out.println("Last element: " + myList.getLast() );
		
		Graph newGraph = new Graph();
		
		newGraph.addNode("A");
		newGraph.addNode("B");
		newGraph.addNode("C");
		newGraph.addNode("D");
		newGraph.addEdge("A", "B", 2);
		newGraph.addEdge("B", "C", 3);
		newGraph.addEdge("C", "D", 4);
	
		
		System.out.println(newGraph.getNodesOnDistance("A", 5).toString());
		System.out.println(newGraph.getNodesOnDistance("A", 2).size());
		 */

			
		

		
		//Checking the behavior of the Management System:
		
		//Creating the Management System
		ManagementSystem MS = new ManagementSystem();
		
		//Adding and printing Apartments
		MS.addNewApartment("Boulevard Du Triomphe", 5, 2, 2050, true, 7, 8);
		MS.addNewApartment("Av Ramirez de Maeztu", 3, 1, 600, false, 3, 5);
		MS.addNewApartment("Romero Robledo", 1, 1, 450, true, 4, 6);	
		MS.addNewApartment("Coto", 6, 4, 3500, false, 3, 5);
		MS.addNewApartment("Av Ramirez de Maeztu", 3, 1, 650, true, 3, 5);
		MS.addNewApartment("Santa Engracia", 2, 2, 750, true, 3, 5);
		MS.printApartments();
		
		//Adding and printing Houses
		MS.addNewHouse("Romero Robledo", 1, 1, 550);
		MS.addNewHouse("Av Ramirez de Maeztu", 4, 2, 1050);
		MS.addNewHouse("Coto", 2, 1, 850);
		MS.addNewHouse("Romero Robledo", 5, 3, 2550);
		MS.addNewHouse("Boulevard Du Triomphe", 1, 1, 250);
		MS.printHouses();
		
		//Adding and printing VIP Clients
		MS.addVIPClient("Fernando", "fer@brussels.be");
		MS.printVIPClient();

		//Adding and printing regular clients
		MS.addRegularClient("Perico", "pericoeldelospalotes@brussels.be");
		MS.addRegularClient("Manolo", "manolo@brussels.be");
		MS.addRegularClient("Paco", "sumorenochulo@brussels.be");
		MS.addRegularClient("Pedro", "manolo@brussels.be");
		MS.addRegularClient("Ramiro", "manolo@brussels.be");
		MS.addRegularClient("Jose Antonio", "manolo@brussels.be");
		MS.printRegularClients();
		
		//Adding streets to the graph
		MS.addStreet("Romero Robledo");
		MS.addStreet("Av Ramirez de Maeztu");
		MS.addStreet("Coto");
		MS.addStreet("Santa Engracia");
		MS.addStreet("Boulevard Du Triomphe");
		
		//Connecting the streets
		MS.connectStreets("Romero Robledo", "Av Ramirez de Maeztu", 10);
		MS.connectStreets("Romero Robledo", "Santa Engracia", 3);
		MS.connectStreets("Coto", "Av Ramirez de Maeztu", 4);
		MS.connectStreets("Coto", "Santa Engracia", 5);
		MS.connectStreets("Romero Robledo", "Boulevard Du Triomphe", 1);
		
		
		//Checking the search on price functionality:
		MS.searchOnPrice(500, 2000);
		
		//Checking the search on bedrooms and price functionality:
		MS.searchOnBedroomsAndPrice(3, 2000);
		
		//Checking the search on radius functionality:
		MS.searchOnDistance("Romero Robledo", 14);
		
		//Checking the search on radius functionality:
		MS.searchOnDistance("Romero Robledo", 7);
		
		//Trying to register a client that does not exists in a visit.
		MS.requestVisit(25, 1);
		
		//Trying to register a property that does not exists in the visits.
		MS.requestVisit(4, 9999);
		
		//Properly registering clients for visiting a property.
		MS.requestVisit(2, 2);
		MS.requestVisit(4, 2);
		MS.requestVisit(6, 2);
		MS.requestVisit(5, 2);
		MS.requestVisit(0, 2);
		MS.requestVisit(1, 2);
		
		//Organizing visits
		MS.organizeVisits();
		
		//Trying to organize again a visit to check that there are not enough clients registered for a visit
		MS.organizeVisits();	
		
		
		
	}

}
