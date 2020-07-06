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
	
	@Test
	void shouldTrueWhenSubJectAdded() {
		assertEquals(true, learner.addSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldTrueToAttendLessonForThreeOrMoreRegisteredSubjects() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.AFRIKAANS);
		assertEquals(true, learner.canAttendLesson());
	}
	
	@Test
	void shouldReturnTrueForSubjectLearnerIsRegisteredFor() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		assertEquals(true, learner.registeredForSubject(Subject.BUSSINESS_STUDIES));
	}
}
