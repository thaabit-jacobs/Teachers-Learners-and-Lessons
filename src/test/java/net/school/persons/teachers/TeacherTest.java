package net.school.persons.teachers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;

class TeacherTest {
	
	Principal principal = new Principal("Ruiter", "Brad", "");
	
	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	
	Learner learner  = new Learner("Thaabit", "Jacobs", "");
	
	@Test
	void shouldReturnTrueWhenAddingSubjectToRegisteredSubjects() {
		assertEquals(true, teacher.addQualifiedSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldIsNotQualifiedForSubject() {
		assertEquals("Thaabit is not qualified to teach lesson", teacher.teach(lesson));
	}
	
	@Test
	void shouldReturnLessonHasStarted() {
		teacher.addQualifiedSubject(Subject.MATH);
		
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		assertEquals("Lesson has been started", teacher.teach(lesson));
	}
	
	@Test
	void shouldReturnLessonHasEnded() {
		teacher.addQualifiedSubject(Subject.MATH);
		
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		
		teacher.teach(lesson);
		
		assertEquals("Lesson is finished", teacher.endLesson(lesson));
	}
	
	@Test
	void shouldReturnFlaseForInsufficentLessonsTaught() {
		assertEquals(false, teacher.qualifiesForDiscount());
	}
	
	@Test
	void shouldReturnTrueForSuffiecentLessonsTaught() {
		teacher.addQualifiedSubject(Subject.MATH);
		
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		
		teacher.teach(lesson);
		teacher.endLesson(lesson);
		
		teacher.teach(lesson);
		teacher.endLesson(lesson);
		
		teacher.teach(lesson);
		teacher.endLesson(lesson);
		
		teacher.teach(lesson);
		teacher.endLesson(lesson);
		
		teacher.teach(lesson);
		teacher.endLesson(lesson);
		
		assertEquals(true, teacher.qualifiesForDiscount());
	}
}
