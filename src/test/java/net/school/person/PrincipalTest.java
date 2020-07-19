package net.school.person;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Teacher;

class PrincipalTest {

	private Principal prin = new Principal("James", "May", "");
	
	private Teacher bill = new Teacher("Bil", "James", "");
	
	private Lesson math = new Lesson(bill, Subject.MATH, LocalTime.now());
	
	//@Test
	void shouldReturnCancelledLessonCount() {
		math.start();
		assertEquals(1, prin.getCancelledLessonCount(math));
	}
	
	//@Test
	void shouldReturnDailyLessonCount() {
		assertEquals(1, prin.getDailyLessonCount(math).get(Subject.MATH));
	}

}
