package net.school.persons.teachers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;

class TeacherTest {

	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	
	Learner learner  = new Learner("Thaabit", "Jacobs", "");
	
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
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		assertEquals("Lesson has been started", teacher.teach(lesson));
	}
	
	@Test
	void shouldReturnFlaseForInsufficentLessonsTaught() {
		assertEquals(false, teacher.qualifiesForDiscount());
	}
	
	@Test
	void shouldReturnTrueForSuffiecentLessonsTaught() {
		teacher.addQualifiedSubject(Subject.MATH);
		teacher.teach(lesson);
		teacher.teach(lesson);
		teacher.teach(lesson);
		teacher.teach(lesson);
		teacher.teach(lesson);
		assertEquals(true, teacher.qualifiesForDiscount());
	}
}
