/*
 * This class represent an Apartment as a real estate. The class extends
 * Building inheriting its attributes and methods.
 *  
 *  @author  Fernando Loro Velardo
 */

public class Apartment extends Property {

	/*
	 * The lift attribute indicates if the apartment has a lift.
	 */
	private boolean lift;
	
	/*
	 * The apartmentFloor indicates the floor number on which is the apartment.
	 */
	private int apartmentFloor;
	
	/*
	 * The buildingFloor indicates the number of floors in the building. 
	 */
	private int buildingFloors;
	
	/*
	 * Constructor of the class that initializes each attribute.
	 */
	public Apartment(int id, String street, int bedrooms, int bathrooms, int price, boolean lift, 
			int apartmentFloor, int buildingFloors) {
		super(id, street, bedrooms, bathrooms, price);
		this.lift = lift;
		this.apartmentFloor = apartmentFloor;
		this.buildingFloors = buildingFloors;
	}

	/*
	 * Time complexity: O(1)
	 * 
	 * @return		True if there is a lift and false if there is not a lift.
	 */
	public boolean isLift() {
		return lift;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the floor number on which is the apartment.
	 */
	public int getApartmentFloor() {
		return apartmentFloor;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the number of floors in the building.
	 */
	public int getBuildingFloors() {
		return buildingFloors;
	}
	
	/*	
	 * Returns a summary details about the apartment
	 * 
	 * Time complexity: O(1)
	 * 
	 * @return		the information of the apartment as a String.
	 */
	public String toString() {
		String lift;
		if(isLift()) {
			lift="	Lift: Yes\n";
		}
		else {
			lift="	Lift: No\n";
		}
		String apartment = "  Apartment ID: " + getId() + "\n" +
			"	Street: " + getStreet()  + "\n" +
			"	Number of bedrooms: " + getBedrooms()  + "\n" +
			"	Number of bathrooms: " + getBathrooms()  + "\n" +
			"	Floor Number: " + getApartmentFloor() + "\n" + 
			lift + 
			"	Price: " + getPrice() + "\n";
		return apartment;
	}
}
