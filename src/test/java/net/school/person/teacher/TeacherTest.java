package net.school.person.teacher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Teacher;

class TeacherTest {
	
	private Teacher jones = new Teacher("John", "Jones", "jones@gmail.com");
	
	@Test
	void shouldReturnFalseForSubjectThatNotRegistered() {
		assertEquals(false, jones.isSubjectRegsitered(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnTruewhenRegisteringNewSubject() {
		assertEquals(true, jones.registerNewSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnFalsewhenRegisteringSubjectThatAlreadyExist() {
		jones.registerNewSubject(Subject.AFRIKAANS);
		assertEquals(false, jones.registerNewSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldAddAmountToListenCount() {
		jones.incrementLessonCount();
		jones.incrementLessonCount();
		jones.incrementLessonCount();
		assertEquals(3, jones.getTeacherLessonCount());
	}
	
	@Test
	void shouldReturnFalseForLessonCountLessThanFive() {
		assertEquals(false, jones.qualiesfyForDiscount());
	}
	
	@Test
	void shouldReturnTrueForLessonCountMoreOrEqualToFive() {
		jones.incrementLessonCount();
		jones.incrementLessonCount();
		jones.incrementLessonCount();
		jones.incrementLessonCount();
		jones.incrementLessonCount();
		assertEquals(true, jones.qualiesfyForDiscount());
	}
}
