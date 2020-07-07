package net.school.persons.caferteria_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CafeteriaManagerTest {
	
	private CafeteriaManager cafeMan = new CafeteriaManager("Thaabit", "Jacobs", "");
	
	@Test
	void shouldAddTokensToTotal() {
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		assertEquals(5, cafeMan.getTokens());
	}

}
