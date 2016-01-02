package data;

/**Created by AlexOAnder 
 * 02.01.2016**/

public class User {

	public int Id;
	public String FirstName;
	public String LastName;
	
	private final int getId() {
		return Id;
	}
	private final void setId(int id) {
		Id = id;
	}
	private final String getFirstName() {
		return FirstName;
	}
	private final void setFirstName(String firstName) {
		FirstName = firstName;
	}
	private final String getLastName() {
		return LastName;
	}
	private final void setLastName(String lastName) {
		LastName = lastName;
	}
} 
