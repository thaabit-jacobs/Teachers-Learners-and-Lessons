package net.school.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {
	
	private Person john = new Person("John", "Jones", "jones@gmail.com");
	
	@Test
	void shouldGetUserFirstName() {
		assertEquals("John", john.getFirstName());
	}
	
	@Test
	void shouldGetUserLastName() {
		assertEquals("Jones", john.getLastName());
	}
	
	@Test
	void shouldGetUserEmailName() {
		assertEquals("jones@gmail.com", john.getEmail());
	}
	
	@Test
	void shouldCreateDeafultEmail() {
		Person john = new Person("John", "Jones", "jonesgmail.com");
		assertEquals("JohnJones@school.net", john.getEmail());
	}
}
