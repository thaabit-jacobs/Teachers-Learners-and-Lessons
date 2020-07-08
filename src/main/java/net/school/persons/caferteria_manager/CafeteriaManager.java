package net.school.persons.caferteria_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.school.cafeteria.menue.MenueItem;
import net.school.persons.Person;

public class CafeteriaManager extends Person{
	
	private int totalTokens;
	
	private HashMap<Person, ArrayList<MenueItem>> sales;
	
	public CafeteriaManager(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		sales = new HashMap<>();
		
	}
	
	public void addTokens(int amount) {
		totalTokens += amount;
	}
	
	public int getTokens() {
		return totalTokens;
	}
	
	public void newSale(Person p, MenueItem mi) {
		if(sales.containsKey(p)) {
			ArrayList<MenueItem> menueItem  = sales.get(p);
			
			menueItem.add(mi);
			
			sales.put(p, menueItem);
		} else {
			ArrayList<MenueItem> menue = new ArrayList<MenueItem>();
			
			menue.add(mi);
			
			sales.put(p, menue); 
		}
			
	}
	
	public String status() {
		Set<Map.Entry<Person, ArrayList<MenueItem>>> set = sales.entrySet();
		String status = "";
		
		for(Map.Entry<Person, ArrayList<MenueItem>> me: set)
			status += me.getKey().getFirstName()  + " " + me.getKey().getLastName() +  " bought " + " : " + me.getValue() + "\n"; 
		
		status += "Total Tokens : " + getTokens();
		
		return status;
	}
}
