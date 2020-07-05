package net.school.persons.learners;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.notes.AquiredType;
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
	
	@Test//
	void shouldReturnEnglishNotesForAttendingEnglishLesson() {
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
	
	@Test
	void shouldReturnLearnerNotRegisesteredForSubject() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.MATH);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		
		assertEquals("Thaabit Jacobs has no notes on MATH", Learner2.askNotes(Learner1, Subject.MATH));
	}
	
	@Test
	void shouldReturnNotEnpughTokensEvenThoughLeanerIsRgisteredForSubject() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		Learner1.getNotes().put(Subject.ENGLISH, AquiredType.BOUGHT);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.ENGLISH);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		
		assertEquals("Not Enough tokens", Learner2.askNotes(Learner1, Subject.ENGLISH));
	}
	
	@Test
	void shouldReturnNotEnpughTokensForSubjectLearnerIsNotRegisteredFor() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		Learner1.getNotes().put(Subject.ENGLISH, AquiredType.BOUGHT);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.MATH);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		
		assertEquals("Not Enough tokens", Learner2.askNotes(Learner1, Subject.ENGLISH));
	}
	
	@Test
	void shouldBuyNotesFromLearner() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		Learner1.getNotes().put(Subject.ENGLISH, AquiredType.BOUGHT);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.ENGLISH);
		subjectsLearner2.add(Subject.AFRIKAANS);
		subjectsLearner2.add(Subject.BUSSINESS_STUDIES);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjectsLearner1);
		Lesson lesson = new EnglishLesson(teach, LocalTime.now());
		
		Learner2.attendLesson(lesson);
		
		assertEquals("Bought notes for ENGLISH cost 2 tokens", Learner2.askNotes(Learner1, Subject.ENGLISH));
	}
	
	@Test
	void shouldDecrementTokensBy2ForBuyingNotesOnRegisteredSubjects() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		Learner1.getNotes().put(Subject.ENGLISH, AquiredType.BOUGHT);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.ENGLISH);
		subjectsLearner2.add(Subject.AFRIKAANS);
		subjectsLearner2.add(Subject.BUSSINESS_STUDIES);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjectsLearner1);
		Lesson lesson = new EnglishLesson(teach, LocalTime.now());
		
		Learner2.attendLesson(lesson);
		Learner2.askNotes(Learner1, Subject.ENGLISH);
		
		assertEquals(1, Learner2.getTokens());
	}
	
	@Test
	void shouldBuyNotesFromLearnerUnRegisteredSubjects() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		Learner1.getNotes().put(Subject.LIFE_SCIENCES, AquiredType.BOUGHT);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.ENGLISH);
		subjectsLearner2.add(Subject.AFRIKAANS);
		subjectsLearner2.add(Subject.BUSSINESS_STUDIES);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjectsLearner1);
		Lesson lesson = new EnglishLesson(teach, LocalTime.now());
		
		Learner2.attendLesson(lesson);
		Learner2.setAttendingLesson(false);
		Learner2.attendLesson(lesson);
		
		assertEquals("Bought notes for LIFE_SCIENCES cost 5 tokens", Learner2.askNotes(Learner1, Subject.LIFE_SCIENCES));
	}
	
	@Test
	void shouldDecrementTokenBy5WhenBuyingNotesForUnregisteredSubjects() {
		ArrayList<Subject> subjectsLearner1 = new ArrayList<>();
		subjectsLearner1.add(Subject.ENGLISH);
		Learner Learner1 = new Learner("thaabit", "jacobs", " ", subjectsLearner1);
		Learner1.getNotes().put(Subject.LIFE_SCIENCES, AquiredType.BOUGHT);
		
		ArrayList<Subject> subjectsLearner2 = new ArrayList<>();
		subjectsLearner2.add(Subject.ENGLISH);
		subjectsLearner2.add(Subject.AFRIKAANS);
		subjectsLearner2.add(Subject.BUSSINESS_STUDIES);
		Learner Learner2 = new Learner("Jasn", "Jame", " ", subjectsLearner2);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjectsLearner1);
		Lesson lesson = new EnglishLesson(teach, LocalTime.now());
		
		Learner2.attendLesson(lesson);
		Learner2.setAttendingLesson(false);
		Learner2.attendLesson(lesson);
		Learner2.askNotes(Learner1, Subject.LIFE_SCIENCES);
		
		assertEquals(1, Learner2.getTokens());
	}
}
