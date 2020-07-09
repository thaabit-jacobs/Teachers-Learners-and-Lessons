package net.school.persons.principal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

class PrincipalTest {
	
	Principal principal = new Principal("Ruiter", "Brad", "");
	
	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson math = new MathLesson(teacher, LocalTime.of(11, 30));
	Lesson math2 = new MathLesson(teacher, LocalTime.of(11, 30));
	Lesson eng = new EnglishLesson(teacher, LocalTime.of(11, 30));
	
	@Test
	void shouldReturnTwoForCancelledLesson() {
		teacher.addQualifiedSubject(Subject.MATH);
		teacher.teach(math);
		teacher.teach(math2);
		assertEquals(2, principal.getCancelledLessonCount());
	}
	
	@Test
	void shouldAddOneTooEnglishLessonCount() {
		assertEquals(1, principal.getLessonCount().get(Subject.ENGLISH));
	}
}
