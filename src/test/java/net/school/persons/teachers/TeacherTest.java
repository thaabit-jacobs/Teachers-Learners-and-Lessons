package net.school.persons.teachers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;

class TeacherTest {

	@Test
	void shouldGetListOfQualifiedSubjects() {
		ArrayList<Subject> subjects = new ArrayList<>();
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		assertEquals(Subject.GEOGRAPHY, teach.getQualifiedSubjects().get(2));
	}
	
	@Test
	void shouldGReturnTeacherNotQualifiedMsg() {
		ArrayList<Subject> subjects = new ArrayList<>();
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.MATH);
		
		assertEquals("Teacher is not qualified to teach MATH", teach.teach(less));
	}
	
	@Test
	void shouldTeachingSubjectMsgForValidSubject() {
		ArrayList<Subject> subjects = new ArrayList<>();
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		Learner l1 = new Learner("jan", "jan", " ", subjects);
		Learner l2 = new Learner("jan1", "jan1", " ", subjects);
		Learner l3 = new Learner("jan2", "jan2", " ", subjects);
		Learner l4 = new Learner("jan3", "jan3", " ", subjects);
		Learner l5 = new Learner("jan4", "jan4", " ", subjects);
		
		less.addLearnerLesson(l1);
		less.addLearnerLesson(l2);
		less.addLearnerLesson(l3);
		less.addLearnerLesson(l4);
		less.addLearnerLesson(l5);
		
		assertEquals("Teaching ENGLISH", teach.teach(less));
	}
	
	@Test
	void shouldReturnLessonCancelledMsgForLessThan3Learners() {
		ArrayList<Subject> subjects = new ArrayList<>();
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		Learner l1 = new Learner("jan1", "jan1", " ", subjects);
		Learner l2 = new Learner("jan2", "jan2", " ", subjects);

		less.addLearnerLesson(l1);
		less.addLearnerLesson(l2);
		
		assertEquals("Lesson has been cancelled", teach.teach(less));
	}
	
	@Test
	void shouldIcrementTokenCountBy5WhenLessonIsTaught() {
		ArrayList<Subject> subjects = new ArrayList<>();
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		Learner l1 = new Learner("jan", "jan", " ", subjects);
		Learner l2 = new Learner("jan1", "jan1", " ", subjects);
		Learner l3 = new Learner("jan2", "jan2", " ", subjects);
		Learner l4 = new Learner("jan3", "jan3", " ", subjects);
		Learner l5 = new Learner("jan4", "jan4", " ", subjects);
		
		less.addLearnerLesson(l1);
		less.addLearnerLesson(l2);
		less.addLearnerLesson(l3);
		less.addLearnerLesson(l4);
		less.addLearnerLesson(l5);
		
		teach.teach(less);
		
		assertEquals(5, teach.getTokens());
	}
}
