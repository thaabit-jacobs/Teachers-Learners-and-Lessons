package net.school.cafeteria.menue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenueItemTest {

	@Test
	void shouldGetTheCostOfMenueitem() {
		assertEquals(6, MenueItem.LUNCH.getCost());
	}

}
