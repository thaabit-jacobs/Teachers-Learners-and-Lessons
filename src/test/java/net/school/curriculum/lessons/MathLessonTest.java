package net.school.curriculum.lessons;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.school.curriculum.subjects.Subject;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

class MathLessonTest {
	
	Principal principal = new Principal("Ruiter", "Brad", "");

	@Test
	void shouldReturnMathAsSubject() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(Subject.ENGLISH);
		
		Teacher teach = new Teacher("Thaabit", "Jacobs", " ");
		Lesson ml = new MathLesson(teach, LocalTime.now());
		
		assertEquals(Subject.MATH, ml.getSubject());
	}

}
