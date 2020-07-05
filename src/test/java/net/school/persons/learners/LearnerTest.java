package net.school.persons.learners;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

class LearnerTest {

	@Test
	void shouldSetAttendingLesson() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Learner learn = new Learner("thaabit", "jacobs", " ", subjects);
		
		learn.setAttendingLesson(true);
		assertEquals(true, learn.getAttendingLesson());
	}
	
	@Test
	void shouldReturnAlreadyAttendingLessonWhenAttendingLessonTrue() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		
		Learner learn = new Learner("thaabit", "jacobs", " ", subjects);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		
		learn.setAttendingLesson(true);
		assertEquals("Thaabit Jacobs already attending a lesson", learn.attendLesson(less));
	}
	
	@Test
	void shouldReturnMustRegister3OrMoreToAttendLessonForInvalidNimberOfSubjects() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		
		Learner learn = new Learner("thaabit", "jacobs", " ", subjects);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		
		assertEquals("Thaabit Jacobs must be registered for 3 or more subjects to attend lesson", learn.attendLesson(less));
	}
	
	@Test
	void shouldReturnNotRegisteredForSubjectForInvalidSubject() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.LIFE_SCIENCES);
		
		Learner learn = new Learner("thaabit", "jacobs", " ", subjects);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.MATH);
		
		assertEquals("Thaabit Jacobs not registered for lesson", learn.attendLesson(less));
	}
	
	@Test
	void shouldReturnAttendingLesson() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.LIFE_SCIENCES);
		
		Learner learn = new Learner("thaabit", "jacobs", " ", subjects);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		
		assertEquals("Thaabit Jacobs attending lesson", learn.attendLesson(less));
	}
	
	@Test
	void shouldIncrementTokensBy3WhenAttendingLesson() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.LIFE_SCIENCES);
		
		Learner learn = new Learner("thaabit", "jacobs", " ", subjects);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		
		learn.attendLesson(less);
		
		assertEquals(3, learn.getTokens());
	}

}
