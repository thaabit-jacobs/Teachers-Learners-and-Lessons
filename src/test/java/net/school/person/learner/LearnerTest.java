package net.school.person.learner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Learner;

class LearnerTest {
	
	private Learner learner = new Learner("John", "Jones", "jones@gmail.com");
	private Learner learner2 = new Learner("Mikey", "James", "mickey@gmail.com");
	
	@Test
	void shouldReturnFalseForSubjectNotInList() {
		assertEquals(false, learner.isSubjectRegsitered(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnTrueWhenNewSubjectRegistered() {
		assertEquals(true, learner.registerNewSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnFalseForRegisteredSubjectsLessThanThree() {
		assertEquals(false, learner.isRegisteredForThreeOrMoreSubjects());
	}
	
	@Test
	void shouldReturnTrueForRegisteredSubjectsMoreThanThree() {
		learner.registerNewSubject(Subject.AFRIKAANS);
		learner.registerNewSubject(Subject.BUSSINESS_STUDIES);
		learner.registerNewSubject(Subject.ENGLISH);
		assertEquals(true, learner.isRegisteredForThreeOrMoreSubjects());
	}
	
	@Test
	void shouldSetIsAttendingLessonToTrue() {
		learner.setIsAttendLesson(true);
		assertEquals(true, learner.getIsAttendingLesson());
	}
	
	@Test
	void shouldReturnFalseForLearnerWithoutLessonNotes() {
		assertEquals(false, learner.learnerHasLessonNotes(learner, Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnTrueForLearnerWithLessonNotes() {
		learner.addNewLessonNotes(Subject.AFRIKAANS, AquiredType.ATTENDED_LESSON);
		assertEquals(true, learner.learnerHasLessonNotes(learner, Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnLearnerDoesNotHaveLessonForLearnerWithoutLessonNotes() {
		assertEquals("Learner does not have lesson notes", learner.askNotes(learner2, Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnNotEnoughTokens() {
		learner2.addNewLessonNotes(Subject.AFRIKAANS, AquiredType.ATTENDED_LESSON);
		assertEquals("Not enough tokens", learner.askNotes(learner2, Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnBoughtLessonNotes() {
		learner.addTokens(5);
		learner2.addNewLessonNotes(Subject.AFRIKAANS, AquiredType.ATTENDED_LESSON);
		assertEquals("Bought lesson notes", learner.askNotes(learner2, Subject.AFRIKAANS));
	}
}
