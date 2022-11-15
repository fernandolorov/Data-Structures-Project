/*
 * This class represent any real estate. We use the Property class as the 
 * parent class for each different type of Real Estate.
 *  
 *  @author  Fernando Loro Velardo
 */

public class Property implements Comparable<Property> {
	
	/*
	 * The id attribute stores the unique ID assigned to the property.
	 */
	private int id;
	
	/*
	 * The street attribute stores the street where the property is located.
	 */
	private String street;
	
	/*
	 * The bedrooms attribute stores the number of bedrooms in the property.
	 */
	private int bedrooms;
	
	/*
	 * The bedrooms attribute stores the number of bathrooms in the property.
	 */
	private int bathrooms; 
	
	/*
	 * The price attribute stores the price of the property.
	 */
	private int price;
	
	/*
	 * The visit attribute stores the priority queue of clients waiting for visiting the property.
	 */
	
	private PriorityQueue visit;
	
	/*
	 * Constructor of the class that initializes each attribute.
	 */
	public Property(int id, String street, int bedrooms, int bathrooms, int price) {
		this.id = id;
		this.street = street;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.price = price;
		this.visit = new PriorityQueue();
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the ID assigned to the property.
	 */
	public int getId() {
		return id;
	}
	
	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the street name of the property.
	 */
	public String getStreet() {
		return street;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the number of bedrooms in the property.
	 */
	public int getBedrooms() {
		return bedrooms;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the number of bathrooms in the property.
	 */
	public int getBathrooms() {
		return bathrooms;
	}
	
	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the price of the property.
	 */
	public int getPrice() {
		return price;
	}
	
	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the the priority queue of clients waiting for visiting the property.
	 */
	public PriorityQueue getVisit() {
		return visit;
	}

	/*
	 * Changes the current price of the property to a new one.
	 * 
	 * Time complexity: O(1)
	 *
	 * @param price 	the new price for the property.
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * Sets a new priority queue of clients waiting for a visit
	 * 
	 * Time complexity: O(1)
	 *
	 * @param visit 	the new priority queue of clients.
	 */
	public void setVisit(PriorityQueue visit) {
		this.visit = visit;
	}
	
	/*
	 * Print a summary details about the property.
	 * 
	 * Time complexity: O(1)
	 */
	public void printProperty() {
		System.out.println("  Property ID: " + getId());
		System.out.println("  Price: " + getPrice()+"\n");
	}
	
	
	/*
	 * Compares the property with another one based on the ID of each property.
	 * 
	 * Time complexity: O(1)
	 * 
	 * @param arg0		the second property to compare.
	 * 
	 * @return		1 if the current property ID is higher than the compared property ID.
	 * 				0 if the current property ID is equals to the compared property ID.
	 * 			   -1 if the current property ID is lower than the compared property ID.
	 */
	@Override
	public int compareTo(Property arg0) {
		if(this.getId()>arg0.getId()) {
			return 1;
		}
		else if(this.getId()==arg0.getId()) {
			return 0;
		}
		else {
			return -1;
		}
	
	}
}