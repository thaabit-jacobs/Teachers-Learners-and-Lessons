package net.school.persons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {
	
	private Person p = new Person("thaabit", "JACOBS", "thaabitjacobs@gmail.com");
	
	@Test
	void shouldReturnTheFirstNameInCorrectCase() {
		assertEquals("Thaabit", p.getFirstName());
	}

	@Test
	void shouldReturnTheLastNameInCorrectCase() {
		assertEquals("Jacobs", p.getLastName());
	}
	
	@Test
	void shouldSetEmailToDefaultForInvalidEmailEntered() {
		 Person p2 = new Person("thaabit", "JACOBS", "thaabitjacobsgmail.com");
		assertEquals("ThaabitJacobs@school.net", p2.getEmailAddress());
	}
	
	@Test
	void shouldReturnEmailEntered() {
		assertEquals("thaabitjacobs@gmail.com", p.getEmailAddress());
	}
	
	
	@Test
	void shouldAddTokens() {
		p.addTokens(10);
		assertEquals(10, p.getTokens());
	}
	
	@Test
	void shouldFromTokens() {
		p.addTokens(10);
		p.deductTokens(5);
		assertEquals(5, p.getTokens());
	}
}
