package net.school.cafeteria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.cafeteria.menue.MenueItem;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;
import net.school.persons.caferteria_manager.CafeteriaManager;
import net.school.persons.learners.Learner;
import net.school.persons.teachers.Teacher;

class CafeteriaTest {
	
	private CafeteriaManager cafeMan = new CafeteriaManager("Thaabit", "Jacobs", "");

	private Cafeteria cafe = new Cafeteria(cafeMan);
	
	private Teacher teacher = new Teacher("James", "Bald", "");
	
	private Learner learner = new Learner("Matt", "Brown", "");
	
	private Lesson mathLesson = new MathLesson(teacher, LocalTime.now());
	
	@Test
	void shouldReturnNotEnoughTokens() {
		assertEquals("Not enough tokens", cafe.buy(teacher, MenueItem.BREAKFAST));
	}
	
	@Test
	void teacherShouldBuyItemAtFulPrice() {
		teacher.addQualifiedSubject(Subject.MATH);
		teacher.teach(mathLesson);
		
		assertEquals("James bought BREAKFAST for 4 tokens", cafe.buy(teacher, MenueItem.BREAKFAST));
	}
	
	@Test
	void teacherShouldBuyItemAtDiscountedPriceFulPrice() {
		teacher.addQualifiedSubject(Subject.MATH);
		teacher.teach(mathLesson);
		teacher.teach(mathLesson);
		teacher.teach(mathLesson);
		teacher.teach(mathLesson);
		teacher.teach(mathLesson);
		
		assertEquals("James bought BREAKFAST for 3 tokens", cafe.buy(teacher, MenueItem.BREAKFAST));
	}
	
	@Test
	void learnerShouldBuyItemAtFulPrice() {
		learner.addSubject(Subject.AFRIKAANS);
		learner.addSubject(Subject.BUSSINESS_STUDIES);
		learner.addSubject(Subject.MATH);
		learner.attendLesson(mathLesson);
		
		assertEquals("Matt bought DRINK for 2 tokens", cafe.buy(learner, MenueItem.DRINK));
	}

}
