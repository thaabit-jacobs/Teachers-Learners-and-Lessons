package net.school.persons.learners;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.AfrikaansLesson;
import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

class LearnerTest {	
	
	@Test
	void shouldTrueWhenSubJectAdded() {
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		assertEquals(true, learner.addSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldTrueToAttendLessonForThreeOrMoreRegisteredSubjects() {
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.AFRIKAANS);
		assertEquals(true, learner.hasThreeOrMoreSubjects());
	}
	
	
	@Test
	void shouldReturnTrueForSubjectLearnerIsRegisteredFor() {
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		assertEquals(true, learner.registeredForSubject(Subject.BUSSINESS_STUDIES));
	}
	
	@Test
	void shouldReturnLearnerNotAddedToLessonForInsufficeintSubjects() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		assertEquals("Thaabit could not be added to lesson", learner.attendLesson(lesson));
	}
	
	@Test
	void shouldReturnLearnerAddedToLessonForValidSubjectNumberAndRegisteredSubjects() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		assertEquals("Thaabit added to lesson", learner.attendLesson(lesson));
	}
	
	@Test
	void shouldIncrementTokensBy3() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		learner.attendLesson(lesson);
		
		assertEquals(3, learner.getTokens());
	}
	
	@Test
	void shouldReturnTrueForLessonNotes() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		learner.attendLesson(lesson);
		
		assertEquals(true, learner.hasLessonNotes(learner, lesson));
	}
	
	@Test
	void shouldReturnDoesNotHaveLessonNotesWhenAskingAlearnerWithoutNotes() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		Learner learner2 = new Learner("James", "Bald", "");
		assertEquals("James does not have lesson notes", learner.askForNotes(learner2, lesson));
	}
	
	@Test
	void shouldNotEnoughTokensWhenTryingToByNotesWithoutTokens() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		Learner learner2 = new Learner("James", "Bald", "");
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		learner2.addSubject(Subject.ENGLISH);
		learner2.addSubject(Subject.MATH);
		learner2.attendLesson(lesson);
		
		assertEquals("Not enough tokens", learner.askForNotes(learner2, lesson));
	}
	
	@Test
	void shouldBuyLessonNotesForTwoTokens() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		Learner learner2 = new Learner("James", "Bald", "");
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		learner2.addSubject(Subject.ENGLISH);
		learner2.addSubject(Subject.MATH);
		learner2.attendLesson(lesson);
		
		Lesson english = new EnglishLesson(teacher, LocalTime.now());
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		learner.attendLesson(english);
		
		assertEquals("Bought lesson notes for 2 tokens", learner.askForNotes(learner2, lesson));
	}
	
	@Test
	void shouldBuyLessonNotesForFiveTokens() {
		Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
		Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
		Learner learner = new Learner("Thaabit", "Jacobs", "");
		Learner learner2 = new Learner("James", "Bald", "");
		learner2.addSubject(Subject.BUSSINESS_STUDIES);
		learner2.addSubject(Subject.ENGLISH);
		learner2.addSubject(Subject.MATH);
		learner2.attendLesson(lesson);
		
		Lesson english = new EnglishLesson(teacher, LocalTime.now());
		Lesson afrikaans = new AfrikaansLesson(teacher, LocalTime.now());
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.AFRIKAANS);
		learner.attendLesson(english);
		english.addLearnerLesson(learner);
		english.addLearnerLesson(learner);
		english.addLearnerLesson(learner);
		english.addLearnerLesson(learner);
		english.addLearnerLesson(learner);
		english.start();
		english.end();
		learner.attendLesson(afrikaans);
		
		assertEquals("Bought lesson notes for 5 tokens", learner.askForNotes(learner2, lesson));
	} 

}
