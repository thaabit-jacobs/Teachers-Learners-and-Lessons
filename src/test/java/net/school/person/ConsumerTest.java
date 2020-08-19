package net.school.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.person.consumer.Consumer;

class ConsumerTest {
	
	private Consumer john = new Consumer("John", "Jones", "jone@gmail");
	
	@Test
	void shouldAddToUserTokens() {
		john.addTokens(5);
		assertEquals(5, john.getTokens());
	}
	
	@Test
	void shouldDeductTokens() {
		john.addTokens(5);
		john.deductTokens(3);
		assertEquals(2, john.getTokens());
	}
	
	@Test
	void shouldReturnFalseForInsufficientTokens() {
		assertEquals(false, john.hasEnoughTokens(5));
	}
	
	@Test
	void shouldReturnTrueForTokensSufficentTokens() {
		john.addTokens(5);
		assertEquals(true, john.hasEnoughTokens(5));
	}
}
