package net.school.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LearnerDbTest {
	
	private final LearnerDb db = new LearnerDb();
	
	@Test
	void shouldReturnLearnerIdForValidEmail() {
		int learnerId = db.getLearnerId("thaabitj@gmail.com");
		assertEquals(1, learnerId);
	}
	
	@Test
	void shouldReturnLearnerZeroForInValidEmail() {
		int learnerId = db.getLearnerId("thaabitjgmail.com");
		assertEquals(0, learnerId);
	}
	
	@Test
	void shouldReturnLearnerEmailForValidId() {
		String learnerEmail = db.getLearnerEmail(1);
		assertEquals("thaabitj@gmail.com", learnerEmail);
	}
	
	@Test
	void shouldReturnEmptyStringForInValidId() {
		String learnerEmail = db.getLearnerEmail(-5);
		assertEquals("", learnerEmail);
	}
	
	@Test
	void shouldReturnTrueForLearnerThatExist() {
		assertTrue(db.learnerExist("thaabitj@gmail.com"));
	}
	
	@Test
	void shouldReturnFlaseForLearnerThatDoesNotExist() {
		assertFalse(db.learnerExist("thaabitj@gmailm"));
	}

}
