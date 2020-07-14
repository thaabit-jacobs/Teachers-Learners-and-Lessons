package net.school.persons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConsumerTest {

	@Test
	void shouldGetCurrentTokenCount() {
		Consumer con = new Consumer("Thaabit", "Jacobs", "");
		assertEquals(0, con.getTokens());
	}
	
	@Test
	void shouldAddTokensToTheCount() {
		Consumer con = new Consumer("Thaabit", "Jacobs", "");
		con.addTokens(5);
		assertEquals(5, con.getTokens());
	}
	
	@Test
	void shouldDeductFromTokenCount() {
		Consumer con = new Consumer("Thaabit", "Jacobs", "");
		con.addTokens(10);
		con.deductTokens(5);
		assertEquals(5, con.getTokens());
	}

}
