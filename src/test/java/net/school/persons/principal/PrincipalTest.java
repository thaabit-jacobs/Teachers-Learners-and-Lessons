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
	
	Teacher teacher = new Teacher("Thaabit", "Jacobs", "");
	
	Lesson math = new MathLesson(teacher, LocalTime.of(11, 30));
	Lesson math2 = new MathLesson(teacher, LocalTime.of(11, 30));
	Lesson eng = new EnglishLesson(teacher, LocalTime.of(11, 30));
	
	Principal principal = new Principal("Ruiter", "Brad", "");
	
	@Test
	void shouldReturnThreeForCancelledLessonCount() {
		teacher.addQualifiedSubject(Subject.MATH);
		teacher.addQualifiedSubject(Subject.ENGLISH);
		
		teacher.teach(math);
		teacher.teach(math2);
		teacher.teach(eng);
		
		assertEquals(3, principal.getCancelledLessonCount());
	}
	
	
	@Test
	void shouldReturnTwoForMathLesson() {		
		assertEquals(2, principal.getLessonCount().get(Subject.MATH));
	}
	
}
