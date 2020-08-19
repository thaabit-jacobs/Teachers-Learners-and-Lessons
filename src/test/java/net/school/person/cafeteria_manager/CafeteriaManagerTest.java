package net.school.person.cafeteria_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.school.cafeteria.menue.MenueItem;
import net.school.person.consumer.CafeteriaManager;
import net.school.person.consumer.Learner;

class CafeteriaManagerTest {
	
	private CafeteriaManager caf = new CafeteriaManager("John", "Jones", " ");
	private Learner jim = new Learner("Jim", "Jones", " ");
	
	@Test
	void shouldAddANewSaleAndAddToTheMenueItem() {
		caf.newSale(jim, MenueItem.DRINK);
		caf.newSale(jim, MenueItem.LUNCH);
		
		assertEquals("[DRINK, LUNCH]", caf.getSales().get(jim).toString());
	}
}
