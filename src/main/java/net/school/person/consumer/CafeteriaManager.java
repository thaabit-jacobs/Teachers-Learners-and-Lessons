package net.school.person.consumer;

import java.util.ArrayList;
import java.util.HashMap;

import net.school.cafeteria.menue.MenueItem;

public class CafeteriaManager extends Consumer{
	
	private HashMap<Consumer, ArrayList<MenueItem>> sales;
	
	public CafeteriaManager(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		sales = new HashMap<>();
	}
	
	public HashMap<Consumer, ArrayList<MenueItem>> getSales(){
		return sales;
	}
	
	public void newSale(Consumer co, MenueItem mi) {
		if(sales.containsKey(co)) {
			ArrayList<MenueItem> menueItem  = sales.get(co);
			menueItem.add(mi);
			sales.put(co, menueItem);
			
		} else {
			ArrayList<MenueItem> menue = new ArrayList<MenueItem>();
			menue.add(mi);
			sales.put(co, menue); 
		}
	}
	
	public void endOfDayStatus() {
		sales.forEach((person, purchases) -> System.out.println(person.getFirstName() + ":" + purchases));
		System.out.println("Tokens :" + this.getTokens());
	}
}
