package net.school.person.teacher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Teacher;

class TeacherTest {
	
	private Teacher linda = new Teacher("Linda", "Smith", "lindas@gmail.com");
	
	@Test
	void shouldReturnFalseForSubjectThatNotRegistered() {
		
		assertEquals(false, linda.isSubjectRegsitered(Subject.BUSSINESS_STUDIES));
	}
	
	
	@Test
	void shouldReturnTruewhenRegisteringNewSubject() {
		assertEquals(true, linda.registerNewSubject(Subject.BUSSINESS_STUDIES));
		linda.getTeacherDb().deleteSubjectFromTeacher("lindas@gmail.com", Subject.BUSSINESS_STUDIES);
	}
	
	
	@Test
	void shouldReturnFalsewhenRegisteringSubjectThatAlreadyExist() {
		assertEquals(false, linda.registerNewSubject(Subject.ENGLISH));
	}
	
	@Test
	void shouldAddAmountToListenCount() {
		linda.incrementLessonCount();
		linda.incrementLessonCount();
		linda.incrementLessonCount();
		assertEquals(3, linda.getTeacherLessonCount());
		linda.getTeacherDb().setLessonCountToZero("lindas@gmail.com");
	}
	
	
	@Test
	void shouldReturnFalseForLessonCountLessThanFive() {
		assertEquals(false, linda.qualiesfyForDiscount());
	}
	
	@Test
	void shouldReturnTrueForLessonCountMoreOrEqualToFive() {
		linda.incrementLessonCount();
		linda.incrementLessonCount();
		linda.incrementLessonCount();
		linda.incrementLessonCount();
		linda.incrementLessonCount();
		assertEquals(true, linda.qualiesfyForDiscount());
		linda.getTeacherDb().setLessonCountToZero("lindas@gmail.com");
	}
	
}
