/*
 * This class represent a client of the Real Estates Management Sysytem.
 *  
 *  @author  Fernando Loro Velardo
 */

public class Client implements Comparable<Client> {
	
	/*
	 * The id attribute stores the unique ID assigned to the client.
	 */
	protected int id;
	
	/*
	 * The name attribute stores the name of the client.
	 */
	protected String name;
	
	/*
	 * The emailAddress attribute stores the email address of the client.
	 */
	protected String emailAddress;
	
	/*
	 * The vip attribute stores if a client is vip or not.
	 */
	protected boolean vip;
	
	/*
	 * Constructor of the class that initializes each attribute.
	 */
	public Client(int id, String name, String emailAddress, boolean vip) {
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.vip = vip;
		
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the ID assigned to the client.
	 */
	public int getId() {
		return id;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the name of the client.
	 */
	public String getName() {
		return name;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		the email address of the client.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/*	
	 * Time complexity: O(1)
	 * 
	 * @return		if the client is vip or not.
	 */
	public boolean getVIP() {
		return vip;
	}
	
	/*
	 * Changes the current email address of the client to a new one.
	 *
	 * Time complexity: O(1)
	 *
	 * @param emailAddress	 	the new email address of the client.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/*
	 * Changes the current vip status of the client to a new one.
	 *
	 * Time complexity: O(1)
	 * 
	 * @param vip	 	the new vip status of the client.
	 */
	public void setVIP(boolean vip) {
		this.vip = vip;
	}

	
	/*
	 * Print a summary details about the client.
	 * 
	 * Time complexity: O(1)
	 */
	public void printClient() {
		System.out.println("  Client ID: " + getId());
		System.out.println("	Client name: " + getName());
		System.out.println("	Client email address: " + getEmailAddress() + "\n");
	}
	
	/*	
	 * Returns the information of the client.
	 * 
	 * Time complexity: O(1)
	 * 
	 * @return		the information the client as a String.
	 */
	public String toString() {
		String client = "  Client ID: " + getId() + "\n" +
			"	Client name: " + getName()  + "\n" +
			"	Client email address: " + getEmailAddress()  + "\n";
		return client;
	}
	
	/*
	 * Compares the client with another one based on the ID of each client.
	 * 
	 * Time complexity: O(1)
	 * 
	 * @param arg0		the second property to compare.
	 * 
	 * @return		1 if the current client ID is higher than the compared client ID.
	 * 				0 if the current client ID is equals to the compared client ID.
	 * 			   -1 if the current client ID is smaller than the compared client ID.
	 */
	@Override
	public int compareTo(Client arg0) {
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
