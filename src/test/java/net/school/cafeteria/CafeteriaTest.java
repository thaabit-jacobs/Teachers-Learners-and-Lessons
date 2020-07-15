package net.school.cafeteria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.cafeteria.menue.MenueItem;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.caferteria_manager.CafeteriaManager;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

class CafeteriaTest {
	
	Principal pprn = new Principal("Bill", "Gates", "");
	
	CafeteriaManager cafeMan = new CafeteriaManager("Thaabit", "Jacobs", "");

	Cafeteria cafe = new Cafeteria(cafeMan);
	
	Teacher teacher = new Teacher("James", "Bald", "");
	
	Learner learner1 = new Learner("Matt", "Brown", "");
	Learner learner2 = new Learner("Matt", "Brown", "");
	Learner learner3 = new Learner("Matt", "Brown", "");
	Learner learner4 = new Learner("Matt", "Brown", "");
	Learner learner5 = new Learner("Matt", "Brown", "");
	
	Lesson mathLesson = new MathLesson(teacher, LocalTime.now());
	
	@Test
	void shouldReturnNotEnoughTokens() {
		assertEquals("Not enough tokens", cafe.buy(teacher, MenueItem.BREAKFAST));
	}
	
	@Test
	void teacherShouldBuyItemAtFulPrice() {
		teacher.addQualifiedSubject(Subject.MATH);
		
		learner1.addSubject(Subject.MATH);
		learner1.addSubject(Subject.AFRIKAANS);
		learner1.addSubject(Subject.BUSSINESS_STUDIES);
		
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
		
		mathLesson.addLearnerLesson(learner1);
		mathLesson.addLearnerLesson(learner2);
		mathLesson.addLearnerLesson(learner3);
		mathLesson.addLearnerLesson(learner4);
		mathLesson.addLearnerLesson(learner5);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		
		assertEquals("James bought BREAKFAST for 4 tokens", cafe.buy(teacher, MenueItem.BREAKFAST));
	}
	
	@Test
	void teacherShouldBuyItemAtDiscountedPriceFulPrice() {
		teacher.addQualifiedSubject(Subject.MATH);
		learner1.addSubject(Subject.MATH);
		learner1.addSubject(Subject.AFRIKAANS);
		learner1.addSubject(Subject.BUSSINESS_STUDIES);
		
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
		
		mathLesson.addLearnerLesson(learner1);
		mathLesson.addLearnerLesson(learner2);
		mathLesson.addLearnerLesson(learner3);
		mathLesson.addLearnerLesson(learner4);
		mathLesson.addLearnerLesson(learner5);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		assertEquals("James bought BREAKFAST for 3 tokens", cafe.buy(teacher, MenueItem.BREAKFAST));
	}
	
	@Test
	void learnerShouldBuyItemAtFulPrice() {
		teacher.addQualifiedSubject(Subject.MATH);
		learner1.addSubject(Subject.MATH);
		learner1.addSubject(Subject.AFRIKAANS);
		learner1.addSubject(Subject.BUSSINESS_STUDIES);
		
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
		
		mathLesson.addLearnerLesson(learner1);
		mathLesson.addLearnerLesson(learner2);
		mathLesson.addLearnerLesson(learner3);
		mathLesson.addLearnerLesson(learner4);
		mathLesson.addLearnerLesson(learner5);
		teacher.teach(mathLesson);
		teacher.endLesson(mathLesson);
		
		assertEquals("Matt bought DRINK for 2 tokens", cafe.buy(learner1, MenueItem.DRINK));
	}

}
