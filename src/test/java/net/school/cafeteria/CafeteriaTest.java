package net.school.cafeteria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.cafeteria.menue.MenueItem;
import net.school.person.consumer.CafeteriaManager;
import net.school.person.consumer.Consumer;
import net.school.person.consumer.Learner;
import net.school.person.consumer.Teacher;

class CafeteriaTest {
	
	private CafeteriaManager bill = new CafeteriaManager("Bill", "March", " ");
	
	private Cafeteria cafe = new Cafeteria(bill);
	
	private Consumer con = new Consumer("Juum", "Jones", " ");
	
	private Teacher sarah = new Teacher("Sarah", "Marks", " ");
	
	private Learner kate = new Learner("Kate", "Jen", " ");
	
	@Test
	void shouldRetutnFalseForNtATeacherOrLearner() {
		assertEquals(false, cafe.isTeacherOrIsLeanrner(con));
	}
	
	@Test
	void shouldRetutnTrueForTeacherObject() {
		assertEquals(true, cafe.isTeacherOrIsLeanrner(sarah));
	}
	
	@Test
	void shouldRetutnTrueForLearnerObj() {
		assertEquals(true, cafe.isTeacherOrIsLeanrner(kate));
	}
	
	@Test
	void shouldRetutnOnlyTeachersAndLearnersCanPurchase() {
		assertEquals("Only teachers or learners can make purchases", cafe.buy(con, MenueItem.DRINK));
	}
	
	@Test
	void shouldRetutnNotEnoughTokensForTeacherWithIsufficentTokens() {
		assertEquals("Not enough tokens", cafe.buy(sarah, MenueItem.DRINK));
	}
	
	@Test
	void shouldRetutnNotEnoughTokensForLearnerWithIsufficentTokens() {
		assertEquals("Not enough tokens", cafe.buy(kate, MenueItem.DRINK));
	}
	
	@Test
	void shouldRetutnNameBoughtForTeacher() {
		sarah.addTokens(5);
		assertEquals("Sarah bought DRINK", cafe.buy(sarah, MenueItem.DRINK));
	}
	
	@Test
	void shouldRetutnNameBoughtForLearner() {
		kate.addTokens(5);
		assertEquals("Kate bought DRINK", cafe.buy(kate, MenueItem.DRINK));
	}

}
