package net.school.curriculum.lessons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

class LessonTest {
	
	Principal principal = new Principal("Ruiter", "Brad", "");
	
	Learner learner  = new Learner("James", "Bald", "");
	
	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	
	@Test
	void shouldGetTeacherObject() {
		assertEquals("Thaabit", lesson.getTeacher().getFirstName());
	}
	
	@Test
	void shouldGetLocalTimeObject() {
		assertEquals("11:30", lesson.getTime().toString());
	}
	
	@Test
	void shouldGetSubject() {
		assertEquals(Subject.MATH, lesson.getSubject());
	}
	
	@Test
	void shouldReturnTrueWhenLearnerIsAddedToMethod() {
		assertEquals(true, lesson.addLearnerLesson(learner));
	}
	
	@Test
	void shouldReturnTrueForCancelledLessonForLearnersAtendingLessThanFive() {
		lesson.addLearnerLesson(learner);
		assertEquals(true, lesson.isCancelled());
	}
	
	@Test
	void shouldReturnLessonStatusIsCancelledIfIsCancelledTrue() {
		lesson.addLearnerLesson(learner);
		lesson.isCancelled();
		assertEquals(LessonStatus.CANCELLED, lesson.getLessonStatus());
	}
	
	@Test
	void shouldReturnlessonHasBeenCancelledForInSufficnetLearnerCount() {
		assertEquals("Lesson has been cancelled", lesson.start());
	}
	
	@Test
	void shouldReturnLessonHasStartedForSufficentStudentCount() {
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		assertEquals("Lesson has been started", lesson.start());
	}
	
	@Test
	void shouldReturnLessonHasntFinishedIfLessonHasntStarted() {
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		assertEquals("Lesson is PENDING", lesson.end());
	}
	
	@Test
	void shouldReturnLessonHasFinsishedWhenLessonIsStarted() {
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner);
		lesson.start();
		assertEquals("Lesson is finished", lesson.end());
	}
	
	@Test
	void shouldSetAttendingLessonToFalse() {
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.MATH);
		
		lesson.addLearnerLesson(learner);
		
		lesson.start();
		lesson.end();
		assertEquals(true, learner.getAttendingLesson() == false);
	}
}
