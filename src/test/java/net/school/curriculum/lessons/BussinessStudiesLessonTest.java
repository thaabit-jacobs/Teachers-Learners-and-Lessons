package net.school.curriculum.lessons;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

class BussinessStudiesLessonTest {

	@Test
	void shouldReturnBussinessStudiesAsSubject() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ");
		Lesson ml = new BussinessStudiesLesson(teach, LocalTime.now());
		
		assertEquals(Subject.BUSSINESS_STUDIES, ml.getSubject());
	}

}
