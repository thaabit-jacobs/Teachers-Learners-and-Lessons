package net.school.persons.learners;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.AfrikaansLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

class LearnerTest {
	
	Principal principal = new Principal("Ruiter", "Brad", "");
	
	Learner learner  = new Learner("Thaabit", "Bald", "");
	Learner learner2  = new Learner("James", "Bald", "");
	Learner learner3  = new Learner("James", "Bald", "");
	Learner learner4  = new Learner("James", "Bald", "");
	Learner learner5  = new Learner("James", "Bald", "");
	Learner learner6  = new Learner("James", "Bald", "");
	
	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson lesson = new Lesson(teacher, LocalTime.of(11, 30), Subject.MATH);
	Lesson afrikaans = new AfrikaansLesson(teacher, LocalTime.of(11, 30));
	
	@Test
	void shouldTrueWhenSubJectAdded() {
		assertEquals(true, learner.addSubject(Subject.AFRIKAANS));
	}
	
	@Test
	void shouldTrueWhenRegisteredForThreeOrMoreRegisteredSubjects() {
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
	void shouldReturnLearnerAddedToLessonForValidSubjectcCountAndRegisteredSubjects() {
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.ENGLISH);
		learner.addSubject(Subject.MATH);
		assertEquals("Thaabit added to lesson", learner.attendLesson(lesson));
	}
	
	@Test
	void shouldReturnDoesNotHaveLessonNotesWhenAskingAlearnerWithoutNotes() {
		assertEquals("James does not have lesson notes", learner.askForNotes(learner2, lesson));
	}

	@Test
	void shouldReturnNotEnoughTokensWhenTryingToByNotesWithoutTokens() {
		learner6.addSubject(Subject.MATH);
		learner6.addSubject(Subject.AFRIKAANS);
		learner6.addSubject(Subject.BUSSINESS_STUDIES);
		
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
		
		learner6.attendLesson(lesson);
		learner2.attendLesson(lesson);
		learner3.attendLesson(lesson);
		learner4.attendLesson(lesson);
		learner5.attendLesson(lesson);
		
		lesson.start();
		lesson.end();
		
		assertEquals("Not enough tokens", learner.askForNotes(learner2, lesson));
	}
	
	
	@Test
	void shouldBuyLessonNotesForTwoTokens() {
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
		
		learner.attendLesson(lesson);
		learner2.attendLesson(lesson);
		learner3.attendLesson(lesson);
		learner4.attendLesson(lesson);
		learner5.attendLesson(lesson);
		
		lesson.start();
		lesson.end();		
		assertEquals("Thaabit bought lesson notes for 2 tokens", learner.askForNotes(learner2, lesson));
	}
	
	
	@Test
	void shouldBuyLessonNotesForFiveTokens() {
		learner.addSubject(Subject.MATH);
		learner.addSubject(Subject.ENGLISH);
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
		
		learner6.addSubject(Subject.MATH);
		learner6.addSubject(Subject.AFRIKAANS);
		learner6.addSubject(Subject.BUSSINESS_STUDIES);
		
		learner.attendLesson(lesson);
		learner2.attendLesson(lesson);
		learner3.attendLesson(lesson);
		learner4.attendLesson(lesson);
		learner5.attendLesson(lesson);
		
		lesson.start();
		lesson.end();
		
		learner.attendLesson(lesson);
		learner2.attendLesson(lesson);
		learner3.attendLesson(lesson);
		learner4.attendLesson(lesson);
		learner5.attendLesson(lesson);
		
		lesson.start();
		lesson.end();
		
		learner6.attendLesson(afrikaans);
		learner2.attendLesson(afrikaans);
		learner3.attendLesson(afrikaans);
		learner4.attendLesson(afrikaans);
		learner5.attendLesson(afrikaans);
		
		afrikaans.start();
		afrikaans.end();
		
		assertEquals("Thaabit bought lesson notes for 5 tokens", learner.askForNotes(learner2, afrikaans));
	}

}
