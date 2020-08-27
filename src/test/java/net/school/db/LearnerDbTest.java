package net.school.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.curriculum.subjects.Subject;

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
	
	@Test
	void shouldReturnTrueForSubjectLearnerIsRegisteredFor() {
		assertTrue(db.isRegisteredSubject("thaabitj@gmail.com", Subject.PHYSICAL_EDUCATIONS));
	}
	
	@Test
	void shouldReturnFalseForSubjectLearnerIsNotRegisteredFor() {
		assertFalse(db.isRegisteredSubject("thaabitj@gmail.com", Subject.MATH));
	}
	
	@Test
	void shouldREturnTRueForLearnerWithThreeOrMoreSubjects() {
		assertTrue(db.isRegisteredThreeOrMoreSubjects("thaabitj@gmail.com"));
	}
	
	@Test
	void shouldREturnFalseForLearnerWithLessThanThreeSubjects() {
		assertFalse(db.isRegisteredThreeOrMoreSubjects("sinawug@gmail.com"));
	}
	
	@Test
	void shouldReturntTrueForLearnerThatCanAttendLesson() {
		assertTrue(db.canAttendLesson("thaabitj@gmail.com", Subject.PHYSICAL_EDUCATIONS));
	}
	
	@Test
	void shouldReturntFlaseForLearnerThatCanNotAttendLesson() {
		assertFalse(db.canAttendLesson("thaabitj@gmail.com", Subject.LIFE_SCIENCES));
	}
	
	@Test
	void shouldREgisterNewSubjectIfSubjectNotRegistered() {
		assertTrue(db.registerNewSubject("thaabitj@gmail.com", Subject.GEOGRAPHY));
		db.deleteSubject("thaabitj@gmail.com", Subject.GEOGRAPHY);
	} 
	
	@Test
	void shouldREgisterNotNewSubjectIfSubjectIsRegistered() {
		assertFalse(db.registerNewSubject("thaabitj@gmail.com", Subject.PHYSICAL_EDUCATIONS));
	} 
}
