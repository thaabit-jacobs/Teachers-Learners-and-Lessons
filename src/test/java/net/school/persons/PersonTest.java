package net.school.persons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void shouldReturnTheFirstNameInCorrectCase() {
		Person p = new Person("thaabit", "JACOBS", "thaabitjacobs@gmail.com");
		assertEquals("Thaabit", p.getFirstName());
	}

	@Test
	void shouldReturnTheLastNameInCorrectCase() {
		Person p = new Person("thaabit", "JACOBS", "thaabitjacobs@gmail.com");
		assertEquals("Jacobs", p.getLastName());
	}

	@Test
	void shouldReturnTheUserFullNameInCorrectCase() {
		Person p = new Person("thaabit", "JACOBS", "thaabitjacobs@gmail.com");
		assertEquals("Thaabit Jacobs", p.getFullName());
	}
	
	@Test
	void shouldSetEmailToDefaultForInvalidEmailEntered() {
		Person p = new Person("thaabit", "JACOBS", "thaabitjacobsgmail.com");
		assertEquals("ThaabitJacobs@school.net", p.getEmailAddress());
	}
	
	@Test
	void shouldReturnEmailEntered() {
		Person p = new Person("thaabit", "JACOBS", "thaabitjacobs@gmail.com");
		assertEquals("thaabitjacobs@gmail.com", p.getEmailAddress());
	}

}
