package net.school.curriculum.lessons;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

class LessonTest {

	@Test
	void shouldGetTeacherObjSubjectssedIn() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		assertEquals(true, teach.equals(less.getTeacher()));
	}
	
	@Test
	void shouldGetLocalTimeObjPassedIn() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		LocalTime time = LocalTime.of(16, 24, 12);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		
		assertEquals("16:24:12", time.toString());
	}
	
	@Test
	void shouldGetSubject() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		subjects.add(Subject.AFRIKAANS);
		subjects.add(Subject.GEOGRAPHY);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ", subjects);
		LocalTime time = LocalTime.of(16, 24, 12);
		Lesson less = new Lesson(teach, LocalTime.now(), Subject.ENGLISH);
		
		assertEquals(Subject.ENGLISH, less.getSubject());
	}

}
