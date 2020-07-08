package net.school.persons;

public class Person {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	public Person(String firstName, String lastName, String email) {
		
		this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
		
		this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
		
		if(email.indexOf("@") == -1)
			this.email = this.firstName + this.lastName + "@school.net";
		else
			this.email = email;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	public String getEmailAddress() {
		return email;
	}
}
