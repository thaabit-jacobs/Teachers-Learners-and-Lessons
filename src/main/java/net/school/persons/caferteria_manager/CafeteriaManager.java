package net.school.persons.caferteria_manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.school.cafeteria.menue.MenueItem;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.notes.AquiredType;
import net.school.persons.Person;

public class CafeteriaManager extends Person{
	
	private int totalTokens;
	
	private HashMap<Person, MenueItem> sales;
	
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
		sales.put(p, mi);
	}
	
	public String status() {
		Set<Map.Entry<Person, MenueItem>> set = sales.entrySet();
		String status = "";
		
		for(Map.Entry<Person, MenueItem> me: set)
			status += me.getKey().getFirstName()  + " " + me.getKey().getLastName() +  "bought " + " : " + me.getValue() + "\n"; 
		
		status += "Total Tokens : " + getTokens();
		
		return status;
	}
}
