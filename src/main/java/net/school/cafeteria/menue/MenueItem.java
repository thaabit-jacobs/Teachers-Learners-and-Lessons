package net.school.cafeteria.menue;

public enum MenueItem {
	
	BREAKFAST(4),
	LUNCH(6),
	AFTERNOON_SNACK(3),
	DRINK(2);
	
	private int cost;
	
	MenueItem(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
}
