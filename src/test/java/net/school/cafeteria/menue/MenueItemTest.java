package net.school.cafeteria.menue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenueItemTest {

	@Test
	void shouldReturnTheCostOfTheMenueItem() {
		assertEquals(6, MenueItem.LUNCH.getCost());
	}

}
