package net.school.persons.teachers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;

class TeacherTest {

	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	
	@Test
	void shouldReturnTrueWhenAddingSubjectToRegisteredSubjects() {
		assertEquals(true, teacher.addQualifiedSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldReturnIfTeacherIsQualifiedToTeachSubject() {
		teacher.addQualifiedSubject(Subject.AFRIKAANS);
		assertEquals(true, teacher.isQualifiedToTeachSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldIsNotQualifiedForSubject() {
		assertEquals("Thaabit is not qualified to teach lesson", teacher.teach(lesson));
	}
	
	@Test
	void shouldReturnIsQualifiedForQualifiedSubjects() {
		teacher.addQualifiedSubject(Subject.MATH);
		assertEquals("Thaabit is teaching lesson", teacher.teach(lesson));
	}
}
