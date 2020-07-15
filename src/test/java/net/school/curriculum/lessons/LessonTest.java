package net.school.curriculum.lessons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

class LessonTest {
	
	Principal principal = new Principal("Ruiter", "Brad", "");
	
	Learner learner  = new Learner("James", "Bald", "");
	Learner learner2  = new Learner("James", "Bald", "");
	Learner learner3  = new Learner("James", "Bald", "");
	Learner learner4  = new Learner("James", "Bald", "");
	Learner learner5  = new Learner("James", "Bald", "");
	
	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	
	
	@Test
	void shouldReturnFalseForTeacherNotQualifiedToTeachSubject() {
		assertEquals(true, !lesson.isQualifiedToTeachSubject());
	}
	
	@Test
	void shouldReturnTrueForTeacherQualifiedToTeachSubject() {
		teacher.addQualifiedSubject(Subject.MATH);
		assertEquals(true, lesson.isQualifiedToTeachSubject());
	}
	
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
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
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
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner2.addSubject(Subject.MATH);
		learner2.addSubject(Subject.AFRIKAANS);
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner3.addSubject(Subject.MATH);
		learner3.addSubject(Subject.AFRIKAANS);
		learner3.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner4.addSubject(Subject.MATH);
		learner4.addSubject(Subject.AFRIKAANS);
		learner4.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner5.addSubject(Subject.MATH);
		learner5.addSubject(Subject.AFRIKAANS);
		learner5.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner2);
		lesson.addLearnerLesson(learner3);
		lesson.addLearnerLesson(learner4);
		lesson.addLearnerLesson(learner5);
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
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner2.addSubject(Subject.MATH);
		learner2.addSubject(Subject.AFRIKAANS);
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner3.addSubject(Subject.MATH);
		learner3.addSubject(Subject.AFRIKAANS);
		learner3.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner4.addSubject(Subject.MATH);
		learner4.addSubject(Subject.AFRIKAANS);
		learner4.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner5.addSubject(Subject.MATH);
		learner5.addSubject(Subject.AFRIKAANS);
		learner5.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner2);
		lesson.addLearnerLesson(learner3);
		lesson.addLearnerLesson(learner4);
		lesson.addLearnerLesson(learner5);
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
	
	@Test
	void shouldAddTokensToLarnersAfterAttendingLesson() {
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner2.addSubject(Subject.MATH);
		learner2.addSubject(Subject.AFRIKAANS);
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner3.addSubject(Subject.MATH);
		learner3.addSubject(Subject.AFRIKAANS);
		learner3.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner4.addSubject(Subject.MATH);
		learner4.addSubject(Subject.AFRIKAANS);
		learner4.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner5.addSubject(Subject.MATH);
		learner5.addSubject(Subject.AFRIKAANS);
		learner5.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner2);
		lesson.addLearnerLesson(learner3);
		lesson.addLearnerLesson(learner4);
		lesson.addLearnerLesson(learner5);
		
		lesson.start();
		lesson.end();
		
		assertEquals(3, lesson.getLearnerAttending().get(0).getTokens());
	}
	
	@Test
	void shouldAddNotesToLearnersAfterAttendingLesson() {
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner2.addSubject(Subject.MATH);
		learner2.addSubject(Subject.AFRIKAANS);
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner3.addSubject(Subject.MATH);
		learner3.addSubject(Subject.AFRIKAANS);
		learner3.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner4.addSubject(Subject.MATH);
		learner4.addSubject(Subject.AFRIKAANS);
		learner4.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner5.addSubject(Subject.MATH);
		learner5.addSubject(Subject.AFRIKAANS);
		learner5.addSubject(Subject.BUSSINESS_STUDIES);
		
		lesson.addLearnerLesson(learner);
		lesson.addLearnerLesson(learner2);
		lesson.addLearnerLesson(learner3);
		lesson.addLearnerLesson(learner4);
		lesson.addLearnerLesson(learner5);
		
		lesson.start();
		lesson.end();
		
		assertEquals(true, AquiredType.ATTENDED_LESSON.equals(lesson.getLearnerAttending().get(0).getNotes().get(lesson)));
	}
}
