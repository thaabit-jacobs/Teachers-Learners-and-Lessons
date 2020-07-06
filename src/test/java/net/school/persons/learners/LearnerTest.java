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

	private Learner learner = new Learner("Thaabit", "Jacobs", "");

	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	
	@Test
	void shouldTrueWhenSubJectAdded() {
		assertEquals(true, learner.addSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldTrueToAttendLessonForThreeOrMoreRegisteredSubjects() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.AFRIKAANS);
		assertEquals(true, learner.hasThreeOrMoreSubjects());
	}
	
	@Test
	void shouldReturnTrueForSubjectLearnerIsRegisteredFor() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		assertEquals(true, learner.registeredForSubject(Subject.BUSSINESS_STUDIES));
	}
	
	@Test
	void shouldReturnLearnerNotAddedToLessonForInsufficeintSubjects() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		assertEquals("Thaabit could not be added to lesson", learner.attendLesson(lesson));
	}
	
	@Test
	void shouldReturnLearnerAddedToLessonForValidSubjectNumberAndRegisteredSubjects() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		assertEquals("Thaabit added to lesson", learner.attendLesson(lesson));
	}
	
	@Test
	void shouldIncrementTokensBy3() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		learner.attendLesson(lesson);
		
		assertEquals(3, learner.getTokens());
	}
	
}
