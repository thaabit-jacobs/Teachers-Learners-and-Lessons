package net.school.persons.caferteria_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.cafeteria.menue.MenueItem;
import net.school.persons.teachers.Teacher;

class CafeteriaManagerTest {
	
	private CafeteriaManager cafeMan = new CafeteriaManager("Thaabit", "Jacobs", "");
	
	@Test
	void shouldAddTokensToTotal() {
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		cafeMan.addTokens(1);
		assertEquals(5, cafeMan.getTokens());
	}
	
	@Test
	void shouldReturnDrinkForItemPurchased() {
		Teacher t = new Teacher("Thaabit", "Jacobs", "");
		cafeMan.newSale(t, MenueItem.DRINK);
		assertEquals("[DRINK]", cafeMan.getSales().get(t).toString());
	}
}
