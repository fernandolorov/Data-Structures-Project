/*
 * This class represent a House as a real estate. The class extends
 * Building, inheriting its attributes and methods.
 *  
 *  @author  Fernando Loro Velardo
 */

public class House extends Property {
	
	/*
	 * Constructor of the class that initializes each attribute.
	 */
	public House(int id, String street, int bedrooms, int bathrooms, int price) {
		super(id, street, bedrooms, bathrooms, price);
	}


	/*	
	 * Returns a summary details about the house.
	 * 
	 * Time complexity: O(1)
	 * 
	 * @return		the information the house as a String.
	 */
	public String toString() {
		String house = "  House ID: " + getId() + "\n" +
			"	Street: " + getStreet()  + "\n" +
			"	Number of bedrooms: " + getBedrooms()  + "\n" +
			"	Number of bathrooms: " + getBathrooms()  + "\n" +
			"	Price: " + getPrice()+ "\n";
	
		return house;
	}

}
