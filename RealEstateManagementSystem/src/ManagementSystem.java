/*
 * The ManagementSystem class represents Real Estate Management System. 
 * In our Management System we can store different types of real estates,
 * e.g. houses and apartments. We can also store clients which can be two
 * different types: regular and VIP clients. The ManagementSystem class also
 * allows us to organize visits to properties.
 *  
 *  @author  Fernando Loro Velardo
 */

public class ManagementSystem implements IManagementSystem {

	/*
	 * The propertyList attribute stores the List of the Houses and Apartments
	 * available in our Management System ordered by price. 
	 * 
	 */
	private Tree propertyList;

	/*
	 * The clientList attribute stores the List of the Clients registered in
	 * our Management System. This List stores both regular clients adn VIP clients.
	 * 
	 */
	private Tree clientList;

	/*
	 * The housesCount attribute stores the number of houses stored in our Management System,
	 * this attribute is used for assigning a unique ID for each new House based on the total 
	 * number of properties already existing.
	 * 
	 */
	private int housesCount;

	/*
	 * The apartmentsCount attribute stores the number of houses stored in our Management System,
	 * this attribute is used for assigning a unique ID for each new Apartment based on the total 
	 * number of properties already existing.
	 * 
	 */
	private int apartmentsCount;

	/*
	 * The clientsCount attribute stores the number of regular clients stored in our Management 
	 * System, this attribute is used for assigning a unique ID for each new Client based on 
	 * the total number of clients already existing.
	 * 
	 */
	private int clientsCount;

	/*
	 * The vipClientsCount attribute stores the number of VIP clients stored in our Management 
	 * System, this attribute is used for assigning a unique ID for each new VIP Client based on 
	 * the total number of clients already existing.
	 * 
	 */
	private int vipClientsCount;

	/*
	 * The map attribute stores the map of the neighborhood/city. The map of the area consists 
	 * of several connected streets of various length. This data structure allows us to obtain 
	 * the distances between streets and properties.
	 * 
	 */
	private Graph map;

	/*
	 * Constructor of the class that initializes each attribute.
	 */
	public ManagementSystem() {
		propertyList = new Tree();
		clientList = new Tree();
		housesCount = 0;
		apartmentsCount= 0;
		clientsCount = 0;
		vipClientsCount = 0;
		map = new Graph();
	}

	/*
	 * Add a new house with given parameters - street where the house is located,
	 * number of bedrooms, number of bathrooms, price per month - to the management system
	 * 
	 * Time complexity: O(log(n))
	 *
	 * @param street where the house is located
	 *
	 * @param bedrooms number of bedrooms
	 * 
	 * @param bathrooms number of bathroom
	 * 
	 * @param price price per month
	 *
	 * @return ID of the house
	 */
	@Override
	public int addNewHouse(String street, int bedrooms, int bathrooms, int price) {
		//We create the new house and add it to the house List
		int createdID = housesCount + apartmentsCount;
		housesCount++;
		House newHouse = new House(createdID, street, bedrooms, bathrooms, price);
		propertyList.insert(newHouse);
		//We increase the base ID for the next element.
		return createdID;
	}

	/*
	 * Add a new apartment with given parameters - street where the apartment is located, 
	 * number of bedrooms, number of bathrooms, price per month, indication whether 
	 * there's a lift in the building, floor on which the apartment is, 
	 * number of floors in the building - to the management system
	 * 
	 * Time complexity: O(log(n))
	 *
	 * @param street where the house is located
	 *
	 * @param bedrooms number of bedrooms
	 * 
	 * @param bathrooms number of bathrooms
	 * 
	 * @param price price per month
	 * 
	 * @param lift is there a lift in the building
	 * 
	 * @param apartmentFloor floor on which is the apartment
	 * 
	 * @param buildingFloors number of floors in the building
	 *
	 * @return ID of the apartment
	 */
	@Override
	public int addNewApartment(String street, int bedrooms, int bathrooms, int price, boolean lift, 
			int apartmentFloor, int buildingFloors) {
		//We create the new ID based on the number of houses and apartments that already exist
		int createdID = housesCount + apartmentsCount;
		//We increase the number of apartments.
		apartmentsCount++;
		//We create the new apartment and add it to the apartment List
		Apartment newApartment = new Apartment(createdID, street, bedrooms, 
				bathrooms, price, lift, apartmentFloor, buildingFloors);
		propertyList.insert(newApartment);
		return createdID;
	}

	/*
	 * Add a new client with given parameters - name, email address to the
	 * management system
	 * 
	 * Time complexity: O(log(n))
	 *
	 * @param name 		name of the client
	 * 
	 * @param emailAddress 	email address of the client
	 *
	 * @return 		ID of the client
	 */
	@Override
	public int addRegularClient(String name, String emailAddress) {
		//We increase the client count. for the next element.
		int createdID = clientsCount + vipClientsCount;
		clientsCount++;
		//We create the new regular client and add it to the client List
		Client newClient = new Client(createdID, name, emailAddress, false);
		clientList.insert(newClient);
		return createdID;
	}

	/*
	 * Add a new VIP client with given parameters - name, email address to the
	 * management system
	 * 
	 * Time complexity: O(log(n))
	 *
	 * @param name		name of the client
	 * 
	 * @param emailAddress 	email address of the client
	 *
	 * @return		ID of the VIP client
	 */
	@Override
	public int addVIPClient(String name, String emailAddress) {
		//We increase the client count. for the next element.
		int createdID = clientsCount + vipClientsCount;
		vipClientsCount++;
		//We create the new VIP client and add it to the client List
		Client newVIPClient = new Client(createdID, name, emailAddress, true);
		clientList.insert(newVIPClient);
		return createdID;
	}

	/*
	 * Print all houses in the system. Print number of houses and a summary
	 * details about each one.
	 * 
	 * Time complexity: O(n)
	 * 
	 */
	public void printHouses() {
		System.out.println("Houses:\n");
		System.out.println("  Number of houses: " + housesCount + "\n");
		//We traverse the property list printing only the instances of House.
		propertyList.traverse(new TreeAction() {
			public void run(Tree.TreeNode n) {
				if(n.getValue() instanceof House) {
					System.out.println(n.getValue());
				}	
			}
		});
	}

	/*
	 * Print all apartments in the system. Print number of apartments and a
	 * summary details about each one.
	 * 
	 * Time complexity: O(n)
	 * 
	 */
	@Override
	public void printApartments() {
		System.out.println("Apartments:\n");
		System.out.println("  Number of apartments: " + apartmentsCount + "\n");
		//We traverse the property list printing only the instances of Apartment.
		propertyList.traverse(new TreeAction(){
			public void run(Tree.TreeNode n){
				if(n.getValue() instanceof Apartment){
					System.out.println(n.getValue());
				}	
			}
		});
	}

	/*
	 * Print all regular clients. Print number of clients and a summary details
	 * about each one.
	 * 
	 * Time complexity: O(n)
	 * 
	 */
	@Override
	public void printRegularClients() {
		System.out.println("Regular clients:\n");
		System.out.println("  Number of regular clients: " + clientsCount + "\n");
		//We traverse the client list printing only the Regular Clients.
		clientList.traverse(new TreeAction(){
			public void run(Tree.TreeNode n){
				if(!((Client)n.getValue()).getVIP()){
					System.out.println(n.getValue());
				}	
			}
		});	
	}

	/*
	 * Print all VIP clients. Print number of VIP clients and a summary details
	 * about each one.
	 * 
	 * Time complexity: O(n)
	 * 
	 */
	@Override
	public void printVIPClient() {
		System.out.println("VIP clients:\n");
		System.out.println("  Number of VIP clients: " + vipClientsCount + "\n");
		//We traverse the client list printing only the VIP Clients.
		clientList.traverse(new TreeAction(){
			public void run(Tree.TreeNode n){
				if(((Client)n.getValue()).getVIP()){
					System.out.println(n.getValue());
				}	
			}
		});
	}

	/*
	 * Search for a place based on the price range. Print all the found properties.
	 *
	 * Time complexity: O(n)
	 *
	 * @param minPrice 	minimal price of a place (house or apartment)
	 * 
	 * @param maxPrice 	maximal price of a place (house or apartment)
	 */
	@Override
	public void searchOnPrice(int minPrice, int maxPrice) {
		System.out.println("Properties in the price range: \n");
		//We traverse the property list printing only the properties that fulfill the price requirements.
		propertyList.traverse(new TreeAction(){
			public void run(Tree.TreeNode n){
				if(minPrice <= ((Property) n.getValue()).getPrice() && 
						((Property) n.getValue()).getPrice() <= maxPrice){
					System.out.println(n.getValue());
				}	
			}
		});
	}

	/*
	 * Search for a place based on the minimum number of bedrooms and max price. Print all the 
	 * found properties.
	 * 
	 * Time complexity: O(n)
	 *
	 * @param minBedrooms	minimum of bedrooms in the house or apartment
	 * 
	 * @param maxPrice	maximal price of a place (house or apartment)
	 */
	@Override
	public void searchOnBedroomsAndPrice(int minBedrooms, int maxPrice) {
		System.out.println("Properties in the price range with a minimum number of bedrooms: \n");
		//We traverse the property list printing only the properties that fulfill the price 
		//and bedrooms requirements.
		propertyList.traverse(new TreeAction() {
			public void run(Tree.TreeNode n){
				if(minBedrooms <= ((Property) n.getValue()).getBedrooms() && 
						((Property) n.getValue()).getPrice() <= maxPrice){
					System.out.println(n.getValue());
				}	
			}
		});
	}

	/*
	 * Search for a place within a circle, given by center point and radius in kilometers.
	 * Print all the found properties.
	 *
	 * Time complexity: O(n^2) Due to we traverse the entire tree and for each property, we 
	 * do a for loop over all streets in the radius range.
	 *
	 * @param street is a center point for the search
	 * 
	 * @param radius is radius in km for which the search is applied
	 */
	@Override
	public void searchOnDistance(String street, double radius) {
		//We get the list of streets inside the radius:
		
		Vector streets = map.getNodesOnDistance(street, radius);
		
		System.out.println("Properties in the radius range: \n");
		//We traverse the property list printing only the properties that fulfill the radius requirements.
		propertyList.traverse(new TreeAction(){
			public void run(Tree.TreeNode n){
				Property property = (Property) n.getValue();
				//If the property is in one of the streets of the list, we print it
				for(int i = 0; i < streets.size(); i++){
					if(property.getStreet()==streets.get(i)){
						System.out.println(property);
						break;
					}
				}
			}
		});

	}

	/*
	 * Adds a street into the system
	 * 
	 * Time complexity: O(log(n))
	 *
	 * @param streetName name of the street that is added to the system
	 * 
	 */
	@Override
	public void addStreet(String streetName) {
		map.addNode(streetName);
	}

	/*
	 * Adds connection between streets into the system
	 * 
	 * Time complexity: O(log(n))
	 *
	 * @param street1 name of the first street that is being connected
	 * 
	 * @param street2 name of the second street that is being connected
	 * 
	 * @param distance is the distance between the streets
	 * 
	 */
	@Override
	public void connectStreets(String street1, String street2, double distance) {
		map.addEdge(street1, street2, distance);
		map.addEdge(street2, street1, distance);
	}

	/*
	 * Request a visit of selected property (house or apartment)
	 * 
	 * Time complexity of finding clients and properties: O(log(n))
	 * 
	 * Time complexity of pushing into the waiting list: O(n) where 
	 * n is the number of clients already waiting for a visit
	 *
	 * @param client 	ID of a client who's requesting a visit
	 * 
	 * @param property	ID of a property to visit (house or apartment)
	 */
	@Override
	public void requestVisit(int client, int property) {
		//First we find and check if the client is VIP or not:
		int priority= -1;

		Client emptyClient = new Client(client,"","", false);
		Tree.TreeNode foundClientNode = clientList.find(emptyClient);

		//If the client is not registered we end the visit procedure.
		if(foundClientNode==null){
			System.out.println("The client is not registered\n");
			return;
		}
		
		Client foundClient = (Client) foundClientNode.getValue();
		
		//We set the priority
		if(foundClient.getVIP()){
			priority = 0;
		}
		else{
			priority = 1;
		}

		//Then we find and check if the property exists:
		Property emptyProperty = new Property(property,"",0,0,0);
		
		Tree.TreeNode foundPropertyNode = propertyList.find(emptyProperty);

		//If the property is not registered we end the visit procedure.
		if(foundPropertyNode==null){
			System.out.println("The property is not registered\n");
			return;
		}

		Property foundProperty = (Property) foundPropertyNode.getValue();
		
		//We push the new client to the queue
		foundProperty.getVisit().push(client, priority);
	
	}

	/*
	 * Organize visit for each property where 5 or more people requested a visit. 
	 * Print the property details and all client names.
	 * 
	 * Time complexity: O(n)
	 *
	 */
	@Override
	public void organizeVisits() {
		//We traverse the property list checking if the number of clients waiting for a visit.
		propertyList.traverse(new TreeAction(){
			public void run(Tree.TreeNode n){
				//We check if the property has 5 or more clients waiting for a visit.
				if(((Property) n.getValue()).getVisit().size()>=5){
					System.out.println("A visit can be organized for the property:\n");
					System.out.println((Property) n.getValue());
					System.out.println("  Clients going to the visit are:" + "\n");
					for(int j = 0; j < 5; j++){
						//We print and delete from the queue the clients that are going to the visit.
						int clientID = (int) ((Property) n.getValue()).getVisit().pop();
						Client emptyClient = new Client(clientID,"","", false);
						System.out.println("   Client: " + (Client) clientList.find(emptyClient).getValue());
					}
				}
			}
		});

	}
}
