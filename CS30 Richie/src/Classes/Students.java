package Classes;

public class Students {

	// ACCESS MODIFIERS
	// PUBLIC - can be accessed by anyone
	// PRIVATE - cannot be accessed by anyone
	// PROTECTED - can only be accessed by an object of the same class
	// Class attributes/variables
	
	public String firstName;
	public String lastName;
	private int grade;
	private int age;
	private double average;
	private int studentID;
	private boolean enrolled;

	// ACCESSORS AND MODIFIERS
	// GETTERS AND SETTERS

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newName) {
		firstName = newName;
	}

	public void setAge(int newAge) {
		if (age >= 0)
			age = newAge;
	}

}
